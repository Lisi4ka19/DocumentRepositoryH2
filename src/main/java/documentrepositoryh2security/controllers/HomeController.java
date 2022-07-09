package documentrepositoryh2security.controllers;

import documentrepositoryh2security.model.Document;
import documentrepositoryh2security.model.User;
import documentrepositoryh2security.service.DocumentService;
import documentrepositoryh2security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.Date;

@Controller
public class HomeController {

	@Autowired
	DocumentService documentService;

	@Autowired
	UserService userService;

	private User currentUser;


	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String home(Model model) {

		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()){
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username =  auth.getName();
			currentUser = getUser();
			model.addAttribute("currentUser", currentUser.getName());
		}
		else {
			model.addAttribute("currentUser", "");
		}

		return "index";
	}


	private User getUser(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username =  auth.getName();
		User user = userService.getUser(username);
		return user;
	}

	@GetMapping("/addDocument")
	public String addDocument(Model model) {

		Document document = new Document();
		document.setDate(new Date());
		document.setUser(currentUser);
		model.addAttribute("document", document);
		model.addAttribute("currentUser", currentUser.getName());

		return "document-form";
	}

	@PostMapping("/saveDocument")
	public String saveDocument(Model model,  @RequestParam("file") MultipartFile file,
							   @Valid @ModelAttribute("document") Document document,
							    BindingResult bindingResult) {

		document.setUser(currentUser);

		if (bindingResult.hasErrors()) {

			document.setDate(new Date());
			document.setUser(currentUser);
			model.addAttribute("document", document);
			model.addAttribute("currentUser", currentUser.getName());

			return "document-form";
		}
		if(file.getSize() == 0){
			document.setDate(new Date());
			document.setUser(currentUser);
			model.addAttribute("document", document);
			model.addAttribute("currentUser", currentUser.getName());

			model.addAttribute("hasErrorFile", true);
			model.addAttribute("errorFile", "File is empty");

			return "document-form";
		}

		document.setUser(currentUser);

		documentService.saveDocument(document);

		model.addAttribute("currentUser", currentUser.getName());
		model.addAttribute("document", document);

		String rootPath = System.getProperty("user.dir") + "\\files\\";
		File dirFile =new File(rootPath);

		if (!dirFile.exists()){
			dirFile.mkdir();
		}

		String fileName = String.valueOf(document.getId()) + "." + getFileExtension(file.getOriginalFilename());
		String path =  rootPath + fileName;

		System.out.println(path);
		System.out.println(file.getOriginalFilename());

		try(FileOutputStream fos = new FileOutputStream(path)) {

			fos.write(file.getBytes());
		}
		catch (IOException e) {

			model.addAttribute("hasErrorFile", true);
			model.addAttribute("errorFile", e.getMessage());

			return "document-form";


		}
		document.setFileName(fileName);
		documentService.saveDocument(document);

		return "redirect:/documentList";
	}

	@GetMapping("/documentList")
	public String getDocumentList(Model model, @PageableDefault(sort={"id"}, direction = Sort.Direction.ASC) Pageable pageable){

		Page<Document> page = documentService.getAllDocument(pageable);
		PagesInfo pagesInfo = new PagesInfo(page);

		model.addAttribute("allDocuments", page.getContent());

		model.addAttribute("itemPage", pagesInfo.getPageItemsList());
		model.addAttribute("size", page.getSize());
		model.addAttribute("currentUser", currentUser.getName());

		return "document-list";

	}

	private String getFileExtension(String fileName) {

		// если в имени файла есть точка и она не является первым символом в названии файла
		if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			// то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
			return fileName.substring(fileName.lastIndexOf(".")+1);
			// в противном случае возвращаем заглушку, то есть расширение не найдено
		else return "";
	}

}

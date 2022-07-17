package documentrepositoryh2security.controllers;

import documentrepositoryh2security.model.Document;
import documentrepositoryh2security.model.DocumentsAccess;
import documentrepositoryh2security.model.User;
import documentrepositoryh2security.service.DocumentAccessService;

import documentrepositoryh2security.service.DocumentService;
import documentrepositoryh2security.service.DocumentWithAccessService;
import documentrepositoryh2security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

	@Autowired
	DocumentService documentService;

	@Autowired
	UserService userService;

	@Autowired
	DocumentAccessService documentAccessService;

	@Autowired
	DocumentWithAccessService documentWithAccessService;

	private User currentUser;
	private SortType sortType = SortType.IdAsc;

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

		boolean isNewDocument = true;



		if(document.getId()!=0){
			isNewDocument = false;
			document.setUser(documentService.getDocument(document.getId()).getUser());
		}
		else {
			document.setUser(currentUser);
		}

		if (bindingResult.hasErrors()) {

			document.setDate(new Date());
			document.setUser(currentUser);
			model.addAttribute("document", document);
			model.addAttribute("currentUser", currentUser.getName());

			return "document-form";
		}
		if(document.getId() == 0 && file.getSize() == 0){
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

		if(file.getSize() != 0) {
			String rootPath = System.getProperty("user.dir") + "\\files\\";
			File dirFile = new File(rootPath);

			if (!dirFile.exists()) {
				dirFile.mkdir();
			}

			String fileName = String.valueOf(document.getId()) + "." + getFileExtension(file.getOriginalFilename());
			String path = rootPath + fileName;

			System.out.println(path);
			System.out.println(file.getOriginalFilename());

			try (FileOutputStream fos = new FileOutputStream(path)) {

				fos.write(file.getBytes());
			} catch (IOException e) {

				model.addAttribute("hasErrorFile", true);
				model.addAttribute("errorFile", e.getMessage());
				model.addAttribute("document", document);
				model.addAttribute("currentUser", currentUser.getName());

				return "document-form";


			}
			document.setFileName(fileName);
			documentService.saveDocument(document);
		}

		if(isNewDocument) {
			documentAccessService.createFullAccess(document, currentUser);
		}

		return "redirect:/documentList";
	}

	@GetMapping("/documentList")
	public String getDocumentList(Model model, Pageable pageable){


		Page<Document> page = getPageBySort(pageable, currentUser.getId());
		PagesInfo pagesInfo = new PagesInfo(page);

		model.addAttribute("allDocuments", page.getContent());

		model.addAttribute("itemPage", pagesInfo.getPageItemsList());
		if(page.getSize()!=3&&page.getSize()!=5&&page.getSize()!=10) {
			model.addAttribute("size", 10);
		}
		else {
			model.addAttribute("size", page.getSize());
		}
		model.addAttribute("currentUser", currentUser.getName());

		return "document-list";

	}

	@GetMapping("/documentList/sort/{sortTypeS}/{size}")
	public String getDocumentListBySort(@PathVariable String sortTypeS, @PathVariable String size){

		sortType = Enum.valueOf(SortType.class, sortTypeS);

		return "redirect:/documentList" + "?size=" + size;
	}




	@GetMapping("/deleteDocument")
	public String deleteDocument(@RequestParam("id") int id, Model model) {


		documentAccessService.deleteAllByDocument(documentService.getDocument(id));
		documentService.deleteDocument(id);

		return "redirect:/documentList";
	}

	@GetMapping("/updateDocument")
	public String updateDocument(@RequestParam("id") int id, Model model) {


		Document document = documentService.getDocument(id);
		model.addAttribute("document", document);

		model.addAttribute("currentUser", currentUser.getName());

		return "document-form";
	}

	@GetMapping("/updateAccess")
	public String updateAccess(@RequestParam("id") int id, @RequestParam("documentId") int documentId,
							   @RequestParam("user") String user, Model model) {


		DocumentsAccess documentsAccess = documentAccessService.getDocumentsAccessById(id);
		if(documentsAccess==null){
			documentsAccess = new DocumentsAccess();
			documentsAccess.setDocument(documentService.getDocument(documentId));
			documentsAccess.setUser(userService.getUser(user));
		}
		model.addAttribute("documentAccess", documentsAccess);
		model.addAttribute("documentName", documentsAccess.getDocument().getName());
		model.addAttribute("userName", documentsAccess.getUser().getName());

		model.addAttribute("currentUser", currentUser.getName());

		return "view";
	}

	@GetMapping("/settingDocument")
	public String settingDocument(@RequestParam("id") int id, Model model) {

		Document document = documentService.getDocument(id);
		model.addAttribute("document", document);

		model.addAttribute("currentUser", currentUser.getName());

		List<DocumentsAccess> documentsAccessList = documentAccessService.getAllUsersAccessByDocument(document);
		model.addAttribute("allAccess", documentsAccessList);
		model.addAttribute("documentId", document.getId());
		model.addAttribute("documentAuthor", document.getUser());

		return "access-list";
	}

	@PostMapping("/updateAccess/saveAccess")
	public String saveDocument(Model model,   @ModelAttribute("documentsAccess") DocumentsAccess documentsAccess) {

		documentAccessService.save(documentsAccess);

		return "redirect:/settingDocument?id=" + documentsAccess.getDocument().getId();
	}

	@RequestMapping("/previewPDF")
	public String previewPDF(String fileName,Model model) {

		model.addAttribute("fileName", fileName);
		return "preview-pdf";
	}

	private String getFileExtension(String fileName) {

		// если в имени файла есть точка и она не является первым символом в названии файла
		if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			// то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
			return fileName.substring(fileName.lastIndexOf(".")+1);
			// в противном случае возвращаем заглушку, то есть расширение не найдено
		else return "";
	}

	private Page getPageBySort(Pageable pageable, Long userId){

		Page page = null;

		switch (sortType){
			case IdAsc:
				page = documentWithAccessService.getAllDocumentByOrderByIdAsc(pageable, userId);
				break;
			case IdDesc:
				page = documentWithAccessService.getAllDocumentByOrderByIdDesc(pageable, userId);
				break;
			case DateAsc:
				page = documentWithAccessService.getAllDocumentByOrderByDateAsc(pageable, userId);
				break;
			case DateDesc:
				page = documentWithAccessService.getAllDocumentByOrderByDateDesc(pageable, userId);
				break;
			case NameAsc:
				page = documentWithAccessService.getAllDocumentByOrderByNameAsc(pageable, userId);
				break;
			case NameDesc:
				page = documentWithAccessService.getAllDocumentByOrderByNameDesc(pageable, userId);
				break;
			case UserAsc:
				page = documentWithAccessService.getAllDocumentByOrderByUserAsc(pageable, userId);
				break;
			case UserDesc:
				page = documentWithAccessService.getAllDocumentByOrderByUserDesc(pageable, userId);
				break;
			case AnnotationAsc:
				page = documentWithAccessService.getAllDocumentByOrderAnnotationAsc(pageable, userId);
				break;
			case AnnotationDesc:
				page = documentWithAccessService.getAllDocumentByOrderByAnnotationDesc(pageable, userId);
				break;
		}
		return page;
	}

}

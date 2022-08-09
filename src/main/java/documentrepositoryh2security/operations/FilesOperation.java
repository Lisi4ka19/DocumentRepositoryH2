package documentrepositoryh2security.operations;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilesOperation {

    public static String saveFile(MultipartFile file, int id) throws IOException {
        String fileName = "";
        String rootPath = System.getProperty("user.dir") + "\\files\\";
        File dirFile = new File(rootPath);

        if (!dirFile.exists()) {
            dirFile.mkdir();
        }

        fileName = String.valueOf(id) + "." + getFileExtension(file.getOriginalFilename());
        String path = rootPath + fileName;

        System.out.println(path);
        System.out.println(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(path);
        fos.write(file.getBytes());

        return fileName;
    }

        private static String getFileExtension(String fileName) {

            // если в имени файла есть точка и она не является первым символом в названии файла
            if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
                // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
                return fileName.substring(fileName.lastIndexOf(".")+1);
                // в противном случае возвращаем заглушку, то есть расширение не найдено
            else return "";
        }
}

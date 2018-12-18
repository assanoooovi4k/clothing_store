package by.bntu.fitr.povt.assanoooovi4k.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {
    public static String saveFile(MultipartFile file) throws Exception {
        String filePath = "src/main/java/resources/static/img/";
        File javaFile = new File(filePath + file.getOriginalFilename());
        byte[] bytes = file.getBytes();
        javaFile = new File(javaFile.getAbsolutePath());
        BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(javaFile));
        stream.write(bytes);
        stream.flush();
        stream.close();
        return "/img/" + file.getOriginalFilename();
    }



}

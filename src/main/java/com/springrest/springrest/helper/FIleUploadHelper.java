package com.springrest.springrest.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.IOException;

@Component
public class FIleUploadHelper {
    public final String UPLOAD_DIR = new ClassPathResource("static/files/").getFile().getAbsolutePath();

    @Autowired
    public FIleUploadHelper() throws IOException {
        super();
    }

    public boolean uploadFile(MultipartFile multipartFile) {
        boolean isUploaded = false;
        try {
            System.out.println("File type " + multipartFile.getContentType());
            // arguments 1 -> input stream of file, arg 2 -> Paths object with location, arg
            // 3 -> option to copy in this we replace if another file exist with same name
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR +
                            File.separator + multipartFile.getOriginalFilename()),
                    StandardCopyOption.REPLACE_EXISTING);
            isUploaded = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUploaded;
    }
}
/**
 * ------------- Uploading File using Streams--------------
 * InputStream input = multipartFile.getInputStream();
 * byte data[] = new byte[input.available()];
 * // write to folder
 * FileOutputStream output = new FileOutputStream(UPLOAD_DIR + File.separator +
 * multipartFile.getOriginalFilename());
 * output.write(data);
 * output.flush();
 * output.close();
 */
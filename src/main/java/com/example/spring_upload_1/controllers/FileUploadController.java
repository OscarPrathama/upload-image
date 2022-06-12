package com.example.spring_upload_1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.spring_upload_1.config.FolderManagement;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUploadController {

    private FolderManagement folderManagement = new FolderManagement();

    public String uploadDirectory = folderManagement.createFolderUpload();

    @RequestMapping("/")
    public String UploadPage(Model model){
        return "uploadview";
    }

    @RequestMapping("/upload")
    public String upload(Model model, @RequestParam("files") MultipartFile[] files){
        
        StringBuilder fileNames = new StringBuilder();

        String message = "";

        // return example /media/masgan/DATA/java-spring/spring_upload_1/uploads
        System.out.println("path dir :");
        System.out.println(uploadDirectory);



        for (MultipartFile file : files) {

            // return example /media/masgan/DATA/java-spring/spring_upload_1/uploads/1 Dota.jpg
            Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());

            // return example /media/masgan/DATA/java-spring/spring_upload_1/uploads/1 Dota.jpg
            System.out.println("file name and path :");
            System.out.println(fileNameAndPath);

            System.out.println("file");
            // return example image/jpeg
            System.out.println(file.getContentType());
            String fileType = file.getContentType();
            
            // return example files
            System.out.println(file.getName());

            // return example 1 Dota.jpg
            System.out.println(file.getOriginalFilename());
            String fileName = file.getOriginalFilename();

            // return example 141950 bytes
            System.out.println(file.getSize());
            Long fileSize = file.getSize();
            
            // MultipartFile resource [files]
            // System.out.println(file.getResource());

            if(!fileName.isEmpty()){

                if(fileSize <= 2_000_000){
                    if(fileType.equalsIgnoreCase("image/jpeg")){
                        fileNames.append(file.getOriginalFilename());

                        try {

                            // upload file    
                            Files.write(fileNameAndPath, file.getBytes());

                        }catch (IOException e){

                            // handle exceptions and errors
                            // It is a method of Java's throwable class which prints the throwable along 
                            // with other details like the line number and class name 
                            // where the exception occurred. 
                            // printStackTrace() is very useful in diagnosing exceptions.
                            e.printStackTrace();

                        }
                        message = "Successfully upload image "+fileNames.toString();
                    }else{
                        message = "File must be an image";
                    }

                    
                }else{
                    message = "Image must be less than 2mb";
                }

                
            }else{
                message = "You must upload an image";
            }

        }
        model.addAttribute("msg", message);
        return "uploadStatusView";
    }

}

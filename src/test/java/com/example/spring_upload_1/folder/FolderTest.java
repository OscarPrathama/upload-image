package com.example.spring_upload_1.folder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class FolderTest {

    private static String projectPath = System.getProperty("user.dir");
    private static String contentDirPath = projectPath + "/content";
    private static String uploadsDirPath = projectPath + "/uploads";

    @Test
    public void checkContentDir() {
        File ContentDir = new File(contentDirPath);

        // if dir content doesn't exist
        if (!Files.exists(Paths.get(contentDirPath))) {
            
            // create content dir
            Boolean isContentDirCreated = ContentDir.mkdir();
            if(isContentDirCreated){
                System.out.println("Content dir created");
            }else{
                System.out.println("Error while create content dir");
            }
            
        }else{
            System.out.println("Content dir exists");
        }

    }

    @Test
    public void uploadDirManagemet() {
        File uploadsDir = new File(uploadsDirPath);

        if (!Files.exists(Paths.get(uploadsDirPath))) {
            
            Boolean isUploadsDirCreated = uploadsDir.mkdir();
            
            if(!isUploadsDirCreated){
                System.out.println("Error while create Uploads dir");
            }
            
        }

        // create current year folder
        String currentYear = this.getCurrentDate("yyyy");
        String yearDirPath = uploadsDirPath+"/"+currentYear;
        File currentYearDir = new File(yearDirPath);

        if (!Files.exists(Paths.get(yearDirPath))) {
            
            Boolean isCurrentYearDirCreated = currentYearDir.mkdir();
            
            if(!isCurrentYearDirCreated){
                System.out.println("Error while create year dir");
            }
            
        }

        // create current month
        String currentMonth = this.getCurrentDate("MM");
        String monthDirPath = yearDirPath+"/"+currentMonth;
        File currentMonthDir = new File(monthDirPath);

        if (!Files.exists(Paths.get(monthDirPath))) {
            
            Boolean iscCurrentMonthDir = currentMonthDir.mkdir();
            
            if(!iscCurrentMonthDir){
                System.out.println("Error while create month dir");
            }
            
        }

        System.out.println(monthDirPath);

    }

    /***
     * The Files.createDirectories() creates a new directory and parent directories 
     * that do not exist. This method does not throw an exception 
     * if the directory already exists.
     */
    @Test
    public void createDirectory() {
        try {
            Files.createDirectories(Paths.get(projectPath + "/coba/ajalah/adajasda"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void userPath() {
        // return : /media/masgan/DATA/java-spring/spring_upload_1
        // String userDir = System.getProperty("user.dir");

        // return : /home/masgan
        String userHome = System.getProperty("user.home");

        System.out.println(userHome);
    }

    /**
     * @param   String  date (yyyy / MM / dd)
     * 
     * @return  String  current date
    */
    @Test
    public String getCurrentDate(final String date) {
        Date dir = new Date(System.currentTimeMillis());

        // String format = "yyyy-MM-dd";
        String format = date;
        DateFormat dateFormatter = new SimpleDateFormat(format);
        String currentDate = dateFormatter.format(dir);
        
        return currentDate;
    }
}

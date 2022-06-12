package com.example.spring_upload_1.config;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.context.annotation.Bean;

public class FolderManagement {
    
    private static String projectPath = System.getProperty("user.dir");
    private static String uploadsDirPath = projectPath + "/uploads";

    @Bean
    public String createFolderUpload() {
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

        return monthDirPath;
    }

    /**
     * @param   String  date (yyyy / MM / dd)
     * 
     * @return  String  current date
    */
    public String getCurrentDate(final String date) {
        Date dir = new Date(System.currentTimeMillis());

        // String format = "yyyy-MM-dd";
        String format = date;
        DateFormat dateFormatter = new SimpleDateFormat(format);
        String currentDate = dateFormatter.format(dir);
        
        return currentDate;
    }

}

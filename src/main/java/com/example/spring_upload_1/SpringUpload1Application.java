package com.example.spring_upload_1;

// import com.example.spring_upload_1.controllers.FileUploadController;

// import java.io.File;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// specify the packages that we want to be scanned
@ComponentScan({"com.example.spring_upload_1", "controller"})
public class SpringUpload1Application {

	public static void main(String[] args) {
		// new File(FileUploadController.uploadDirectory).mkdir();
		SpringApplication.run(SpringUpload1Application.class, args);
	}

}

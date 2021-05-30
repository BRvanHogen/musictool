package com.backend.eindopdracht.musictool;

import com.backend.eindopdracht.musictool.service.fileupload.FileService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@SpringBootApplication
public class MusictoolApplication implements CommandLineRunner {
	@Resource
	FileService storageService;

	public static void main(String[] args) {
		SpringApplication.run(MusictoolApplication.class, args);
	}

	@Override
	public void run(String... arg) throws Exception {
//		storageService.deleteAll();
//		storageService.init();
	}

//	Hi, look at SpringBootUploadFilesApplication.java, in run() method, we call storageService.deleteAll();
//	for deleting all stored files.
//	So you only need to remove the line.


//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/users/**").allowedOrigins("https://localhost:8444");
//			}
//		};
//	}

}
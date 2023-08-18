package com.example.s3trial;

import com.example.s3trial.s3.S3Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.io.IOException;
import java.nio.file.Files;

@SpringBootApplication
public class S3trialApplication {

	@Autowired
	S3Repository s3Repository;
	public static void main(String[] args) {

		SpringApplication.run(S3trialApplication.class, args);

	}
	@EventListener(ApplicationReadyEvent.class)
	public void doSomethingAfterStartup() throws IOException {
		s3Repository.uploadFile("customers_bucket", "hello123.txt", Files.createTempFile("hello", ".file").toFile());
	}
}

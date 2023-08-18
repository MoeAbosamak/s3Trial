package com.example.s3trial.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class S3Repository {

    @Autowired
    private AmazonS3 amazonS3;

    public void uploadFile(String bucketName, String keyName, File file) {
        amazonS3.putObject(new PutObjectRequest(bucketName, keyName, file));
    }
}

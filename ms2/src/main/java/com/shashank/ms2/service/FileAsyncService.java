/*
package com.shashank.ms2.service;

import com.shashank.ms2.config.FileWriterClient;
import com.shashank.ms2.dto.FileDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class FileAsyncService {

    @Autowired
    private FileWriterClient client;

    @Async("fileExecutor")
    public void writeToFile(FileDetails fileDetails){
        try {
            client.writeToFile(fileDetails);
        }catch (Exception ex){
            System.out.println("SOme issue in file write");
        }

    }
}
*/

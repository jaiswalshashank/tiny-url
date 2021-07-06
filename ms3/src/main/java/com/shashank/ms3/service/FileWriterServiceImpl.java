package com.shashank.ms3.service;

import com.shashank.ms3.controller.FileDetails;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Service
public class FileWriterServiceImpl implements FileWriterService{


    public void writeToFile(String fileDetails)
            throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("FileDetails",true));
        writer.append("\n");
        writer.write(fileDetails);
        writer.close();
    }
}

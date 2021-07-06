package com.shashank.ms3.service;

import com.shashank.ms3.controller.FileDetails;

import java.io.IOException;

public interface FileWriterService {
    void writeToFile(String fileDetails)
            throws IOException;
}

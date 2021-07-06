package com.shashank.ms3.controller;

import com.shashank.ms3.service.FileWriterServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/write")
public class FileWriterController {

    @Autowired
    FileWriterServiceImpl service;

    @PostMapping
    public ResponseEntity<Object> writeToFile(@RequestBody FileDetails file) throws IOException {
        service.writeToFile(file.toString());
        return new ResponseEntity(HttpStatus.OK);
    }
}

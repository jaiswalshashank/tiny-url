package com.shashank.ms1.controller;

import com.shashank.ms1.service.HttpUrlAcceptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/url")
public class HttpUrlAcceptorController {

    @Autowired private HttpUrlAcceptorService service;


    @PostMapping
    public ResponseEntity<String> generateShortUrl(@RequestParam("q") String longUrl){
        return new ResponseEntity(service.getShortenUrlFromMS2(longUrl), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<String> getBigUrl(@RequestParam("q") String shortUrl){
        return new ResponseEntity(service.getBigUrl(shortUrl), HttpStatus.OK);
    }
}

package com.shashank.ms2.controller;

import com.shashank.ms2.service.EncoderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/encode")
public class EncoderController {

    @Autowired
    private EncoderService service;

    @GetMapping
    public ResponseEntity<String> encode(@RequestParam("q") String longUrl){

        return new ResponseEntity<>(service.encode(longUrl), HttpStatus.OK);
    }
}

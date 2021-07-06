package com.shashank.ms3.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class FileDetails implements Serializable {

    private static final long serialVersionUID = 1L;

    private String shortUrl;

    private String longUrl;
}

package com.shashank.ms1.service;

public interface HttpUrlAcceptorService {

    String getShortenUrlFromMS2(String longUrl);

    String getBigUrl(String shortUrl);
}

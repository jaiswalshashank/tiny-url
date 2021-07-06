package com.shashank.ms1.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.shashank.ms1.config.ShortenUrlClient;
import com.shashank.ms1.dao.UrlDao;
import com.shashank.ms1.dao.entity.UrlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

@Service
public class HttpUrlAcceptorServiceImpl implements HttpUrlAcceptorService{

    @Autowired private ShortenUrlClient shortenUrlClient;
    @Autowired private UrlDao dao;

    private final String TINY_URL= "http://www.tinyurl.com/";

    @Override
    @HystrixCommand(
            fallbackMethod = "fallback",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000"),
            }
    )
    public String getShortenUrlFromMS2(String longUrl) {
        String unhashedChar=longUrl.substring(longUrl.indexOf("//"));
        String shortUrl=shortenUrlClient.encode(unhashedChar).getBody();
        UrlEntity entity= dao.findByShortenUrl(shortUrl);
        if(Objects.isNull(entity)){
            UrlEntity url=new UrlEntity();
            url.setLongUrl(longUrl);
            url.setShortenUrl(shortUrl);
            url.setCreated_at(LocalDateTime.now());
            dao.save(url);
            return TINY_URL+shortUrl;
        }else
        return "Already Created::::::"+TINY_URL+shortUrl;
    }

    public String fallback(String longUrl) {
        return "Please provide correct url!!!";
    }

    @Override
    public String getBigUrl(String shortUrl) {
        UrlEntity entity= dao.findByShortenUrl(shortUrl.substring(shortUrl.lastIndexOf("/")+1));
        return Objects.nonNull(entity)?entity.getLongUrl():"Url not exist";
    }
}

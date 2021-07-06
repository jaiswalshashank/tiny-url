package com.shashank.ms1.config;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

//@FeignClient(name = "encoder-service", url = "http://localhost:8081")
@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="encoder-service")
public interface ShortenUrlClient {

    @GetMapping("/encoder-service/encode")
    ResponseEntity<String> encode(@RequestParam("q")String longUrl) ;
}

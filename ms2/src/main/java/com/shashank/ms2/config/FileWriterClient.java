/*
package com.shashank.ms2.config;

import com.shashank.ms2.dto.FileDetails;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="netflix-zuul-api-gateway-server")
@RibbonClient(name="file-writer")
public interface FileWriterClient {

    @PostMapping("/file-writer/write")
    ResponseEntity<Object> writeToFile(@RequestBody FileDetails file);
}
*/

package com.shashank.ms2.service;

import com.shashank.ms2.dto.FileDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

@Service
public class EncoderServiceImpl implements EncoderService {

    /*@Autowired
    private FileAsyncService service;*/

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private Queue queue;

    @Override
    public String encode(String longUrl) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(longUrl.getBytes(StandardCharsets.UTF_8));
            String shortUrl = Base64.getEncoder().encodeToString(
                    messageDigest)
                    .substring(0, 6);
            FileDetails fileDetails = new FileDetails();
            fileDetails.setLongUrl(longUrl);
            fileDetails.setShortUrl(shortUrl);
            //service.writeToFile(fileDetails);
            jmsTemplate.convertAndSend(queue, fileDetails.toString());
            return shortUrl;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}

package com.shashank.ms3.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shashank.ms3.controller.FileDetails;
import com.shashank.ms3.service.FileWriterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@EnableJms
public class MessageConsumer {

    private final Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

    @Autowired private FileWriterService writerService;

    @Autowired private ObjectMapper objectMapper;

    @JmsListener(destination = "file-writer")
    public void listener(String  message) throws IOException {
        logger.info("Message received {} ", message);
        writerService.writeToFile(message);
    }
}
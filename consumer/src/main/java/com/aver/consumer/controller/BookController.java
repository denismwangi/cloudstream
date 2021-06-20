package com.aver.consumer.controller;

import com.aver.consumer.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.web.bind.annotation.RestController;


@EnableBinding(Sink.class)
@RestController
public class BookController {

    private Logger logger = LoggerFactory.getLogger(BookController.class);

    @StreamListener("input")
    public void ConsumeMessage(Book book){

        logger.info("consume payload : " +book);

    }



}

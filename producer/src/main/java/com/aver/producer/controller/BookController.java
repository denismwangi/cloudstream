package com.aver.producer.controller;


import com.aver.producer.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;


import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding(Source.class)
@RestController
public class BookController {


    @Qualifier("output")
    @Autowired
    MessageChannel messageChannel;

    @PostMapping("/publish")
    public Book publishBook(@RequestBody Book book){

        messageChannel.send(MessageBuilder.withPayload(book).build());
        return book;

    }

}

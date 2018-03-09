package com.sample.polling.controller;


import com.sample.polling.service.LongPolling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    LongPolling longPolling;

/*    @RequestMapping("/")
    public String home() {

        return "Sample of Long Polling Check Chrome Console";
    }*/


    @RequestMapping("/polling")
    public ResponseEntity topoll() {

        return ResponseEntity.ok(longPolling.waitFor5To15Seconds());
    }
}

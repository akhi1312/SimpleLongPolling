package com.sample.polling.controller;


import com.sample.polling.service.LongPolling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class Controller {

//     @Autowired
//     LongPolling longPolling;
    private DeferredResult result  ;

    @RequestMapping("/update-price")
    public String updatePrice(Double price) {
        result.setResult(price);
        return "success";
    }

    @RequestMapping("/polling")
    public DeferredResult<Double> topoll() {
        result = new DeferredResult();
        return result;
    }
}

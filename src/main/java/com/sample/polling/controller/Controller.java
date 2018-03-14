package com.sample.polling.controller;


import com.sample.polling.service.LongPolling;
import com.sample.polling.service.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class Controller {


    @Autowired
    private LongPolling longPolling;
    private DeferredResult<ResultView> result  ;


    @PostMapping("/price/clear")
    public String clearPrice() {
        longPolling.clearPrice();
        return "success";
    }

    @PostMapping("/price/update")
    public String updatePrice(Double price) {
       // result.setResult(price);
        longPolling.setValue(price);
        return "success";
    }

    @PostMapping("/price")
    public DeferredResult<ResultView> polling(@RequestParam(required = false,defaultValue = "10") Long timeout) {
        result = new DeferredResult(timeout*1000);
        longPolling.sendResponse(result);
        return result;
    }
}

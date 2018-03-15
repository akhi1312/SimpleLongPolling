package com.sample.polling.controller;


import com.sample.polling.service.LongPolling;
import com.sample.polling.service.ResultView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Controller {

     @Autowired
     private LongPolling longPolling;


    @PostMapping("/price/clear")
    public String clearPrice() {
        longPolling.clearPrice();
        return "success";
    }



    @PostMapping("/price/update")
    public String updatePrice(Double price) {
        longPolling.setValue(price);
        return "success";
    }


    @PostMapping("/price")
    public DeferredResult<ResultView> polling(@RequestParam(required = false,defaultValue = "10") Long timeout) {
        DeferredResult<ResultView>   result = new DeferredResult(timeout * 1000);
            longPolling.sendResponse(result);
            return result;
        }


}


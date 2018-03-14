package com.sample.polling.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;
import java.util.concurrent.*;

@Service
public class LongPolling

    {
        private Stack<ResultView> resultMap = new Stack<>();

        private static SecureRandom secureRandom = new SecureRandom();

        public void clearPrice() {
            // resultMap.empty();
            resultMap = new Stack<>();
        }

        public void setValue(Double value) {
            long waitTimeInMilliSec = 1000L + 1000L* secureRandom.nextInt(10);
            resultMap.push(new ResultView(value , waitTimeInMilliSec));
        }

        @Async
        public void sendResponse(DeferredResult<ResultView> result) {
            try{
                 if (!resultMap.isEmpty()) Thread.sleep(resultMap.peek().getResponseTime());
            } catch (InterruptedException ie) {
              ie.printStackTrace();
             }
            if (!resultMap.isEmpty()) result.setResult(resultMap.peek());
        }


}



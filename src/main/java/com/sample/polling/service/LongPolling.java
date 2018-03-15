package com.sample.polling.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.async.DeferredResult;

import java.security.SecureRandom;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;



@Service
public class LongPolling

    {
        private Deque<ResultView> resultMap = new LinkedList<>();

        private static SecureRandom secureRandom = new SecureRandom();

        public void clearPrice() {
            resultMap = new LinkedList<>();
        }

        public void setValue(Double value) {
            long waitTimeInMilliSec = 1000L + 1000L* secureRandom.nextInt(10);
            resultMap.push(new ResultView(value , waitTimeInMilliSec));
        }

        @Async("myThreadPool")
        public void sendResponse(DeferredResult<ResultView> result) {
            try{
                 if (!resultMap.isEmpty()) Thread.sleep(resultMap.peek().getResponseTime());
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
             }

                 if (!resultMap.isEmpty()) result.setResult(resultMap.peek());


        }



        public ResultView getResponse() {
            try{
                if (!resultMap.isEmpty()) Thread.sleep(resultMap.peek().getResponseTime());
            } catch (InterruptedException ie) {
                Thread.currentThread().interrupt();
            }
            if (!resultMap.isEmpty()) return resultMap.peek();
            else return new ResultView(0.0,0l);
        }
}



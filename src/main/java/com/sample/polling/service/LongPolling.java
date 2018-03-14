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
<<<<<<< HEAD
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

=======
//         private static SecureRandom secureRandom = new SecureRandom();
//         static {
//         secureRandom.setSeed( System.currentTimeMillis() );
//     }

//         static Random rand = new Random();

//     @Async
//     public String waitFor5To15Seconds() {
//         int  first = rand.nextInt(5) + 1;
//          long start = System.currentTimeMillis();
//          try {
//              long sleepTimeInMilli = 1000L*secureRandom.nextInt(10);  // 5 - 15 seconds
//              Thread.sleep(sleepTimeInMilli);
//          } catch (InterruptedException ie) {
//              ie.printStackTrace();
//          }

//         int  last = rand.nextInt(5) + 1;
//          long end = System.currentTimeMillis();
//         if(first != last)
//             return "After " + (end-start) +" ms the server responds with Echo";
//         else
//             return waitFor5To15Seconds();
//     }
>>>>>>> cc138340608e898afa1920cf96560f6ddc955530

}



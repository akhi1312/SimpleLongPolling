package com.sample.polling.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Random;

@Service
public class LongPolling


    {
        private static SecureRandom secureRandom = new SecureRandom();
        static {
        secureRandom.setSeed( System.currentTimeMillis() );
    }

        static Random rand = new Random();

    @Async
    public String waitFor5To15Seconds() {
        int  first = rand.nextInt(5) + 1;
         long start = System.currentTimeMillis();
         try {
             long sleepTimeInMilli = 1000L*secureRandom.nextInt(10);  // 5 - 15 seconds
             Thread.sleep(sleepTimeInMilli);
         } catch (InterruptedException ie) {
             ie.printStackTrace();
         }

        int  last = rand.nextInt(5) + 1;
         long end = System.currentTimeMillis();
        if(first != last)
            return "After " + (end-start) +" ms the server responds with Echo";
        else
            return waitFor5To15Seconds();
    }

}



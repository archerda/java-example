package com.github.archerda.jdk.dateformat;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * SimpleDateFormat线程安全的问题
 * @see "http://www.importnew.com/23010.html"
 * Created by luohd on 17/2/23.
 */
public class SDFError {

    private SDFError(){}

    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(500);
        for (int i = 0; i < 500; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000000; i++) {
                        try {
                            DATE_FORMAT.parse("2014-01-01 00:00:00");
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        Thread.sleep(3000000);
    }
}

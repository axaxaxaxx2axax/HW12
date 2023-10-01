package org.example.task1;

import java.util.Date;

public class CurrentTimeMessage implements Runnable {
    @Override
    public void run() {
        while (true) {
            Date now = new Date();
            System.out.println("Поточний час: " + now);
            sleep();
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

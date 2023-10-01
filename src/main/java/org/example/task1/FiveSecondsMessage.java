package org.example.task1;

public class FiveSecondsMessage implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("Минуло 5 секунд");
            sleep();
        }
    }

    private static void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

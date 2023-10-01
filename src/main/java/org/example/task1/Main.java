package org.example.task1;

public class Main {
    public static void main(String[] args) {
        Runnable currentTimeRun = new CurrentTimeMessage();
        Thread currentTimeThread = new Thread(currentTimeRun);

        Runnable fiveSecondsRun = new FiveSecondsMessage();
        Thread fiveSecondsThread = new Thread(fiveSecondsRun);

        currentTimeThread.start();
        fiveSecondsThread.start();
    }
}
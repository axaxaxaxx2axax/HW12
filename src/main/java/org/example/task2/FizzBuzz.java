package org.example.task2;

import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;
    private volatile int current;

    public FizzBuzz(int n) {
        this.n = n;
        this.current = 1;
    }

    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 3; i <= n; i += 3) {
            if (i % 5 != 0) {
                while (current != i || current % 3 != 0 || current % 5 == 0) {
                    wait();
                }
                printFizz.run();
                if (i + 3 <= n) {
                    System.out.print(", ");
                } else {
                    System.out.print(".");
                }
                current++;
                notifyAll();
            }
        }
    }

    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 5; i <= n; i += 5) {
            if (i % 3 != 0) {
                while (current != i || current % 5 != 0 || current % 3 == 0) {
                    wait();
                }
                printBuzz.run();
                if (i + 5 <= n) {
                    System.out.print(", ");
                } else {
                    System.out.print(".");
                }
                current++;
                notifyAll();
            }
        }
    }

    public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 15; i <= n; i += 15) {
            while (current != i || current % 3 != 0 || current % 5 != 0) {
                wait();
            }
            printFizzBuzz.run();
            if (i + 15 <= n) {
                System.out.print(", ");
            } else {
                System.out.print(".");
            }
            current++;
            notifyAll();
        }
    }

    public synchronized void number(IntConsumer printNumber) throws InterruptedException {
        while (current <= n) {
            while (current % 3 == 0 || current % 5 == 0) {
                wait();
            }
            if (current <= n) {
                printNumber.accept(current);
                if (current + 1 <= n) {
                    System.out.print(", ");
                } else {
                    System.out.print(".");
                }
                current++;
                notifyAll();
            }
        }
    }
}

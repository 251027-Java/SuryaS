package org.example;

public class SomeTask implements Runnable {

    @Override
    public void run() {
        System.out.println("This is a separate class where we implemented the Runnable Interface. The runnable interface has the run() method, which is needed for threads.");
    }
}

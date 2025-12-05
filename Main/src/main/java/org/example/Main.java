package org.example;

public class Main {
    static void main() {

        Runnable task1 = new SomeTask();

        Runnable task2 = () -> {
            String text = "Thread: hello world";
            System.out.println(text);
        };

        Thread thread1 = new Thread(task1);

        Thread thread2 = new Thread(() -> {
            String text = "Thread: this is cool";
            System.out.println(text);
        });

        Thread thread3 = new Thread(task2);
        Thread thread4 = new Thread(task1);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }


}

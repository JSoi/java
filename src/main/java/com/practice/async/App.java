package com.practice.async;

public class App{
    public static void main(String[] args) {
        // sequential
        new Thread(() -> {
            System.out.println("hello");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).run();
        Runner runner = new Runner();
        Runner2 runner2 = new Runner2();
        runner.run();
        runner2.run();

        try {
            runner2.join();
            System.out.println("App.main");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Runner extends  Thread {
    public Runner() {
        System.out.println("Runner.Runner");
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner 1 Executing -> " + i);
            try {
                Thread.sleep(200L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Runner2 extends Thread {
    public Runner2() {
        System.out.println("Runner2.Runner2");
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Runner 2 Executing -> " + i);
            try {
                Thread.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
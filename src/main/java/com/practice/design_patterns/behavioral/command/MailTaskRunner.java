package com.practice.design_patterns.behavioral.command;

import java.util.LinkedList;
import java.util.List;

public class MailTaskRunner implements Runnable {
    private Thread runner;
    List<Command> pendingCommands;
    volatile boolean stop;
    private static final MailTaskRunner INSTANCE = new MailTaskRunner();

    public static MailTaskRunner getInstance() {
        return INSTANCE;
    }

    private MailTaskRunner() {
        pendingCommands = new LinkedList<>();
        runner = new Thread(this);
        runner.start();

    }

    @Override
    public void run() {
        while (true) {
            Command command = null;
            synchronized (pendingCommands) {
                if (pendingCommands.isEmpty()) {
                    try {
                        pendingCommands.wait();
                    } catch (InterruptedException e) {
                        System.out.println("Runner Interrupted");
                        if (stop) {
                            System.out.println("Runner Stopping");
                            return;
                        }
                    }
                } else {
                    command = pendingCommands.removeFirst();
                }
            }
            if (command == null) {
                return;
            }
            command.execute();
        }
    }

    public void addCommand(Command command) {
        synchronized (pendingCommands) {
            this.pendingCommands.add(command);
            this.pendingCommands.notifyAll();
        }
    }

    public void shutDown(){
        this.stop = true;
        this.runner.interrupt();
    }
}

package com.practice.design_patterns.behavioral.command;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        EWSService ewsService = new EWSService();
        Command c1 = new AddMemberCommand("a@a.com", "spam", ewsService);
        MailTaskRunner.getInstance().addCommand(c1);
        Command c2 = new AddMemberCommand("b@b.com", "spam", ewsService);
        MailTaskRunner.getInstance().addCommand(c2);
        Thread.sleep(3000);
        MailTaskRunner.getInstance().shutDown();
    }
}

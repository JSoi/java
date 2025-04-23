package com.practice.design_patterns.behavioral.chain_of_responsibility;

public class PermissionHandler implements Handler{
    private final Handler nextHandler;
    public PermissionHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean canHandle(Request request) {
        return "ADMIN".equals(request.getUserRole());
    }

    @Override
    public void process(Request request) {
        if (!canHandle(request)) {
            System.out.println("인증 실패");
        }
        nextHandler.process(request);
    }
}

package com.practice.design_patterns.behavioral.chain_of_responsibility;

public class ValidationHandler implements Handler {
    private final Handler nextHandler;

    public ValidationHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean canHandle(Request request) {
        return request.getData() != null && !request.getData().isEmpty();
    }

    @Override
    public void process(Request request) {
        if (!canHandle(request)) {
            System.out.println("데이터 유효성 검사 실패");
        }
        nextHandler.process(request);
    }
}

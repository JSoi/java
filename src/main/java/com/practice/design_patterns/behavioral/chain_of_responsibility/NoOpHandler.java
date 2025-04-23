package com.practice.design_patterns.behavioral.chain_of_responsibility;

public class NoOpHandler implements Handler {
    @Override
    public boolean canHandle(Request request) {
        return true; // 어떤 요청도 거부하지 않음
    }

    @Override
    public void process(Request request) {
        // 아무것도 안 함
    }
}

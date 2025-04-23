package com.practice.design_patterns.behavioral.chain_of_responsibility;

public interface Handler {
    boolean canHandle(Request request);
    void process(Request request);
}

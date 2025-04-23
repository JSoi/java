package com.practice.design_patterns.behavioral.chain_of_responsibility;

public class ChainExecution {
    public static void main(String[] args) {
        Handler noOpHandler = new NoOpHandler();
        Handler validationHandler = new PermissionHandler(noOpHandler);
        Handler permissionHandler = new ValidationHandler(validationHandler);
        Handler authenticationHandler = new AuthenticationHandler(permissionHandler);
        authenticationHandler.process(new Request("valid-token","ADMIN", "HIHI"));
    }
}

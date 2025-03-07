package design_patterns.behavioral.chain_of_responsibility;

public class AuthenticationHandler implements Handler{
    private final Handler nextHandler;
    public AuthenticationHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public boolean canHandle(Request request) {
        return request.getToken() != null && request.getToken().equals("valid-token");
    }

    @Override
    public void process(Request request) {
        if (!canHandle(request)) {
            System.out.println("인증 실패");
        }
        nextHandler.process(request);
        System.out.println("요청 처리 완료: " + request.getData());
    }
}

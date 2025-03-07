package design_patterns.behavioral.chain_of_responsibility;

public class Request {
    private String token;
    private String userRole;
    private String data;

    public Request(String token, String userRole, String data) {
        this.token = token;
        this.userRole = userRole;
        this.data = data;
    }

    public String getToken() {
        return token;
    }

    public String getUserRole() {
        return userRole;
    }

    public String getData() {
        return data;
    }
}

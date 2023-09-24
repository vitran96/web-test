package tech.kingoyster.springsimpleserver.hello;

public class HelloResponse {

    private String message;

    public String getMessage() {
        return message;
    }

    public String setMessage(String message) {
        this.message = message;
        return this.message;
    }

    public HelloResponse(String message) {
        this.message = message;
    }

    public HelloResponse() {
        this.message = "Hello, World!";
    }

}

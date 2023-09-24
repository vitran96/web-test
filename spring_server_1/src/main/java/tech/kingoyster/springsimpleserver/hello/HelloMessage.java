package tech.kingoyster.springsimpleserver.hello;

public class HelloMessage {

    private String message;

    public String getMessage() {
        return message;
    }

    public String setMessage(String message) {
        this.message = message;
        return this.message;
    }

    public HelloMessage(String message) {
        this.message = message;
    }

    public HelloMessage() {
        this.message = "Hello, World!";
    }

}

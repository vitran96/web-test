package tech.kingoyster.spring_cli_2.commands;

import org.springframework.stereotype.Component;

import picocli.CommandLine.Command;
import tech.kingoyster.spring_cli_2.client.ServerClient;
import tech.kingoyster.spring_cli_2.model.HelloMessageModel;

@Component
@Command(
    name = "hello",
    mixinStandardHelpOptions = true,
    sortOptions = false,
    description = "Say hello to the server."
)
public class HelloCommand implements Runnable {

    private final ServerClient serverClient;

    public HelloCommand(final ServerClient serverClient) {
        this.serverClient = serverClient;
    }

    @Override
    public void run() {
        HelloMessageModel sayHello = serverClient.sayHello();

        System.out.println("Server messsage: " + sayHello.getMessage());
    }

}

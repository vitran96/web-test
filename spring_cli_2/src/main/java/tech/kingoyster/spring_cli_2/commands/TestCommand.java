package tech.kingoyster.spring_cli_2.commands;

import org.springframework.stereotype.Component;

import picocli.CommandLine.Command;

@Component
@Command(name = "test", sortOptions = false, description = "Test command")
public class TestCommand implements Runnable {

    @Override
    public void run() {
        System.out.println("Test command");
    }
}

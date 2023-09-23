package tech.kingoyster.springcli1.commands;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class TestCommand {

    @ShellMethod(key = "test", value = "Test command")
    public String test() {
        return "Hello, World!";
    }

}

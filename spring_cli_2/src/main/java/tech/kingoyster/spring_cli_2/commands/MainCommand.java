package tech.kingoyster.spring_cli_2.commands;

import org.springframework.stereotype.Component;

import picocli.CommandLine.Command;

@Component
@Command(name = "", hidden = true, sortOptions = false, subcommands = {
        TestCommand.class, HelloCommand.class
}, description = "Main")
public class MainCommand {

}

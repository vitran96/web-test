package tech.kingoyster.spring_cli_2;

import org.springframework.stereotype.Component;

import picocli.CommandLine;
import picocli.CommandLine.IFactory;
import tech.kingoyster.spring_cli_2.commands.MainCommand;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;

@Component
public class ApplicationRunner implements CommandLineRunner, ExitCodeGenerator {

    private final MainCommand mainCommand;

    private final IFactory factory; // auto-configured to inject PicocliSpringFactory

    private int exitCode;

    public ApplicationRunner(MainCommand myCommand, IFactory factory) {

        // To pass in arguments via spring-boot:run please use
        // Spring >= 2.x.x
        // -Dspring-boot.run.arguments=<args>
        this.mainCommand = myCommand;
        this.factory = factory;
    }

    @Override
    public void run(String... args) throws Exception {
        exitCode = new CommandLine(mainCommand, factory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }
}

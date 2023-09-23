package tech.kingoyster.spring_cli_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tech.kingoyster.spring_cli_2.commands.TestCommand;

@SpringBootApplication
public class SpringCli2Application {

	public static void main(String[] args) {
		// Method 1: to not start a web server
		// SpringApplication application = new SpringApplication(MainApplication.class);
		// application.setWebApplicationType(WebApplicationType.NONE);
		// application.run(args);
		System.exit(SpringApplication.exit(SpringApplication.run(SpringCli2Application.class, args)));
	}
}

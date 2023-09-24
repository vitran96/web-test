package tech.kingoyster.spring_cli_2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import tech.kingoyster.spring_cli_2.client.ServerClient;
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

    private static final String API_ROUTE = "/api";

    @Bean
    ServerClient serverClient() {
        WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8080" + API_ROUTE)
            .defaultHeader("Accept", "application/json")
            .build();

        HttpServiceProxyFactory factory = HttpServiceProxyFactory
            .builder(WebClientAdapter.forClient(webClient))
            .build();

        return factory.createClient(ServerClient.class);
    }
}

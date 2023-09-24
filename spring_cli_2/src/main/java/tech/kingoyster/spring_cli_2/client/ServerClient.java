package tech.kingoyster.spring_cli_2.client;

import org.springframework.web.service.annotation.GetExchange;

import tech.kingoyster.spring_cli_2.model.HelloMessageModel;

public interface ServerClient {

    @GetExchange("/hello")
    public HelloMessageModel sayHello();
}

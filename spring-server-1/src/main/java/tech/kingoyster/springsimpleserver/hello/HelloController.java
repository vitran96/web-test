package tech.kingoyster.springsimpleserver.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String hello(HttpServletRequest request) {
        return request.getRemoteAddr();
    }
}

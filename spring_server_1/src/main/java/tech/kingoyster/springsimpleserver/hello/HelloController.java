package tech.kingoyster.springsimpleserver.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public ResponseEntity<HelloResponse> hello(HttpServletRequest request) {

        return ResponseEntity.ok().body(new HelloResponse(request.getRemoteAddr()));
    }
}

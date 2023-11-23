package tech.kingoyster.springsimpleserver.hello;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    @GetMapping("/get")
    public ResponseEntity<HelloMessage> hello(HttpServletRequest request) {

        return ResponseEntity.ok().body(new HelloMessage(request.getRemoteAddr()));
    }

    @GetMapping("/err")
    public ResponseEntity<HelloMessage> helloErr(HttpServletRequest request) {

//        return ResponseEntity.ok().body(new HelloMessage(request.getRemoteAddr()));
        throw new RuntimeException("Hello Error");
    }
}

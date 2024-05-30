package vn.theson.jobhunter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String getHelloWorld() {
        return "Hello World (The Son IT)";
    }
}

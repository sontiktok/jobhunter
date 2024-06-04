package vn.theson.jobhunter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public ResponseEntity<String> getHelloWorld() {
        return ResponseEntity.ok("Hello World - The Son IT HIHIHI");
    }
}

package com.anamnesis.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/home")
    public String getHome(){
        return ("Home Page");
    }
//    public ResponseEntity<String> get() {
//        return ResponseEntity.ok("Hello World!");
//    }
}

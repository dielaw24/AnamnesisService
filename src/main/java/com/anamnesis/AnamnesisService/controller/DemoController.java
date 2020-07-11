package com.anamnesis.AnamnesisService.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DemoController {
    //clase de prueba, eliminar despues
    @GetMapping("/home")
    public String getHome(){
        return ("Home Page");
    }
//    public ResponseEntity<String> get() {
//        return ResponseEntity.ok("Hello World!");
//    }
}

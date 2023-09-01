package com.example.demo.controller;

import com.example.demo.model.Demo;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @Autowired
    private DemoService demoService;

    @PostMapping
    public ResponseEntity<String> sendToExchange(@RequestBody Demo body) {

        try {
            demoService.createNewExchange(body);
            return new ResponseEntity<>("Exchange has been created!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage() ,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping
    public ResponseEntity<String> get() {
        return new ResponseEntity<>("All good", HttpStatus.OK);
    }
}

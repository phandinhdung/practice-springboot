package com.phandinhdung.practice_springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/test")
    ResponseEntity<String> test() {
        return ResponseEntity.ok("test thanh cong");
    }
}

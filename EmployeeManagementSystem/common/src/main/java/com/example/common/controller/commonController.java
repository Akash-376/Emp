package com.example.common.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/common")
public class commonController {

    @GetMapping
    public String sayHello(){
        return "Hello! welcome to the springBoot application";
    }
}

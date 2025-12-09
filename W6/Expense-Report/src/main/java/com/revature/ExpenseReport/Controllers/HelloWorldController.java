package com.revature.ExpenseReport.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Spring uses the concept of reflection to recognize our annotations
@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @GetMapping("/hello")
    public String getHelloWorld(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello %s!".formatted(name);
        //return "Hello "+name+"!";
    }



}

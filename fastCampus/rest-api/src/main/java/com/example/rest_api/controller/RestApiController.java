package com.example.rest_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RestApiController {
    @GetMapping(path = "/hello")
    public String hello() {
        String html = "<html> <body> <h1> Hello Spring Boot </h1> </body </html>";

        return html;
    }

    @GetMapping("/echo/{msg}/{userId}")
    public String echo(@PathVariable(name = "msg") String message, @PathVariable int userId) {
        System.out.println("echo message : " + message + " " + userId);
        return message.toUpperCase();
    }
}

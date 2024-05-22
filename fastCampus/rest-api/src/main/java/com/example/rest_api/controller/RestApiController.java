package com.example.rest_api.controller;

import com.example.rest_api.model.BookQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
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

    @GetMapping("/book")
    public void queryParam(@RequestParam(name = "category") String category,
                           @RequestParam(name = "issuedYear") String issuedYear,
                           @RequestParam(name = "issuedMonth") String issuedMonth,
                           @RequestParam(name = "issuedDay") String issuedDay // issued_day은 추천하지 않음
    ) {
        System.out.println(category);
        System.out.println(issuedYear);
        System.out.println(issuedMonth);
        System.out.println(issuedDay);
    }

    @GetMapping("/book2")
    public void queryParamDto(BookQueryParam bookQueryParam) {
        System.out.println(bookQueryParam.getCategory());
        System.out.println(bookQueryParam.getIssuedYear());
        System.out.println(bookQueryParam.getIssuedMonth());
        System.out.println(bookQueryParam.getIssuedDay());
    }

    @DeleteMapping(path = {
            "/user/{userName}/delete",
            "/user/{userName}/del",
    })
    public void delete(@PathVariable String userName) {
        log.info("user-name : {}", userName);
    }
}

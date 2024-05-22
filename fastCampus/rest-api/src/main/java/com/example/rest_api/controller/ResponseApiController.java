package com.example.rest_api.controller;

import com.example.rest_api.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class ResponseApiController {
    @GetMapping("/object")
    public UserRequest user(){
        UserRequest user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(10);
        user.setEmail("hong@email.com");
        return user;
    }

    @GetMapping("/string")
    public String userString(){     //toString으로는 거의 반환하지 않음
        UserRequest user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(10);
        user.setEmail("hong@email.com");

        log.info("user : {}", user);

        return user.toString();
    }

    @GetMapping("/response-entity")
    public ResponseEntity<UserRequest> userResponseEntity() {
        UserRequest user = new UserRequest();
        user.setUserName("홍길동");
        user.setUserAge(10);
        user.setEmail("hong@email.com");

        log.info("user : {}", user);

        ResponseEntity<UserRequest> response = ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);

        return response;
    }
}

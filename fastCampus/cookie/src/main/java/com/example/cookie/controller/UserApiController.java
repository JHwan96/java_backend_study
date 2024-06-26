package com.example.cookie.controller;

import com.example.cookie.db.UserRepository;
import com.example.cookie.model.UserDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiController {
    private final UserRepository userRepository;

    @GetMapping("/me")
    public UserDto me(HttpServletRequest httpServletRequest,
                      @CookieValue(name = "authorization-cookie", required = false) String authorizationCookie) {
        log.info("authorizationCookie : {}", authorizationCookie);
        Optional<UserDto> optionalUserDto = userRepository.findById(authorizationCookie);
        return optionalUserDto.get();
 /*        Cookie[] cookies = httpServletRequest.getCookies();
       if(cookies != null) {
            for(Cookie cookie : cookies) {
                log.info("key : {}, value : {}", cookie.getName(), cookie.getValue());
            }
        }*/
    }

    @GetMapping("/me2")
    public UserDto me2(HttpServletRequest httpServletRequest,
                       @RequestHeader(name = "authorization", required = false) String authorizationHeader) {
        log.info("authorizationCookie : {}", authorizationHeader);
        Optional<UserDto> optionalUserDto = userRepository.findById(authorizationHeader);
        return optionalUserDto.get();
    }
}

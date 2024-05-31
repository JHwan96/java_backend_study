package com.example.cookie.service;

import com.example.cookie.db.UserRepository;
import com.example.cookie.model.LoginRequest;
import com.example.cookie.model.UserDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    //login logic
    public void login(LoginRequest loginRequest, HttpServletResponse httpServletResponse) {
        String id = loginRequest.getId();
        String password = loginRequest.getPassword();

        Optional<UserDto> optionalUser =  userRepository.findByName(id);
        if(optionalUser.isPresent()){
            UserDto userDto = optionalUser.get();

            if(userDto.getPassword().equals(password)){
                // 쿠키에 해당 정보 저장
                Cookie cookie = new Cookie("authorization-cookie", userDto.getId());
                cookie.setDomain("localhost");
                cookie.setPath("/");
                cookie.setMaxAge(-1);   //session
//                cookie.setSecure(true);
                cookie.setHttpOnly(true);

                httpServletResponse.addCookie(cookie);
            }
        } else {
            throw new RuntimeException("User Not Found");
        }
    }
}

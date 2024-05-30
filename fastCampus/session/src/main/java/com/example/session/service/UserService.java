package com.example.session.service;

import com.example.session.db.UserRepository;
import com.example.session.model.LoginRequest;
import com.example.session.model.UserDto;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    public void login(LoginRequest loginRequest, HttpSession httpSession){
        String id = loginRequest.getId();
        String pw = loginRequest.getPassword();

        Optional<UserDto> optionalUser = userRepository.findByName(id);

        if(optionalUser.isPresent()) {
            UserDto userDto = optionalUser.get();

            if(userDto.getPassword().equals(pw)) {
                httpSession.setAttribute("USER", userDto);
            } else {
                throw new RuntimeException("Password Not Equal");
            }
        } else {
            throw new RuntimeException("User Not Found");
        }

    }
}

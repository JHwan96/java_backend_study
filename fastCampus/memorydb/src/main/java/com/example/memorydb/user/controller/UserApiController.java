package com.example.memorydb.user.controller;

import com.example.memorydb.user.model.UserEntity;
import com.example.memorydb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {
    private final UserService userService;

    @PutMapping("")
    public UserEntity create(@RequestBody UserEntity userEntity){
        return userService.save(userEntity);
    }

    @GetMapping("/all")
    public List<UserEntity> findAll(){
        return userService.findAll();
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable Long id) {
//        userService.delete(id);
    }

    @GetMapping("/id/{id}")
    public UserEntity findOne(@PathVariable Long id) {
        Optional<UserEntity> response = userService.findById(id);
        return response.get();
    }

    @GetMapping("/score")
    public List<UserEntity> findUpperScore(@RequestParam int score) {
        return userService.findByScore(score);
    }

    @GetMapping("/min_max")
    public List<UserEntity> findBetweenMinMax(@RequestParam int min, @RequestParam int max) {
        return userService.filterScore(min, max);
    }

}

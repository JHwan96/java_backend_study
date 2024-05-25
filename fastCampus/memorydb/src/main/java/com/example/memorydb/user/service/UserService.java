package com.example.memorydb.user.service;

import com.example.memorydb.user.model.UserEntity;
import com.example.memorydb.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public UserEntity save(UserEntity userEntity) {
        // save
        userRepository.save(userEntity);
        return userEntity;
    }

    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public void delete(UserEntity id) {
        userRepository.delete(id);
    }

    public List<UserEntity> findByScore(int score) {
        return userRepository.findAllByScoreGreaterThanEqual(score);
    }

    public List<UserEntity> filterScore(int min, int max){
        return userRepository.findAllByScoreGreaterThanEqualAndScoreLessThanEqual(min, max);
    }
}

package com.example.memorydb.user.repository;

import com.example.memorydb.db.SimpleDataRepository;
import com.example.memorydb.user.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRepository extends SimpleDataRepository<UserEntity, Long> {
    public List<UserEntity> findByScore(int score) {
        return dataList.stream().filter(x -> x.getScore() >= score).collect(Collectors.toList());
    }
}

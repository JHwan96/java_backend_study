package com.example.memorydb.user.repository;

import com.example.memorydb.db.SimpleDataRepository;
import com.example.memorydb.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //select * from user where user.score >= score
    public List<UserEntity> findAllByScoreGreaterThanEqual(int score);

    List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int min, int max);

    @Query("SELECT u FROM user u where u.score >= ?1 AND u.score <= ?2")
    List<UserEntity> score(int min, int max);

    @Query(value = "SELECT * FROM user as u where u.score >= :min AND u.score <= :max", nativeQuery = true)
    List<UserEntity> scoreWithNativeQuery(@Param("min") int min, @Param("max") int max);
}

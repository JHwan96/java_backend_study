package com.example.jwt;

import com.example.jwt.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class JwtApplicationTests {
	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {
	}

	@Test
	void tokenCreate() {
		Map<String, Object> claims = new HashMap<>();
		claims.put("user_id", 932);

		LocalDateTime expiredAt = LocalDateTime.now().plusSeconds(10);
		String jwtToken = jwtService.create(claims, expiredAt);
		System.out.println(jwtToken);
	}

	@Test
	void tokenValidation() {
		String token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo5MzIsImV4cCI6MTcxNzM5NTYwNX0.k_TBdFkoBNJ92P4kMaDfm2UqruLQpgJP0QUcYBp87KA";
		jwtService.validation(token);
	}

}

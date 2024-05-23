package com.example.rest_api;

import com.example.rest_api.model.UserRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestApiApplicationTests {

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void contextLoads() throws JsonProcessingException {
		UserRequest user = new UserRequest("홍길동", 10,"hong@gmail.com", true);
		System.out.println(user);

		String test = objectMapper.writeValueAsString(user);
		System.out.println(test);

//		String toDeserialize = "{\"user_name\":\"홍길동\",\"user_age\":10,\"email\":\"hong@gmail.com\",\"is_korean\":true}";
//		UserRequest userRequest = objectMapper.readValue(toDeserialize, UserRequest.class);
//		System.out.println(userRequest);
	}
}

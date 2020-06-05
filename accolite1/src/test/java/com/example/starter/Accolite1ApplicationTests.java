package com.example.starter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.user.UserDao;

@SpringBootTest
class Accolite1ApplicationTests {

	@Autowired
	private UserDao userC;
	
	@Test
	void contextLoads() {
		assertThat(userC).isNotNull();
	}

	@Test
	void getList() {
		userC.getAllUser();
	}
	
}

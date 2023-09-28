package com.trommelschuppen;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.Month;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TrommelschuppenApplicationTests {
	
	@Autowired
	TestRestTemplate restTemplate;

	/*
	 * Testing GET /users/{user_id} -> findById()
	 */
	@Test
	void shouldReturnUserOleWhenDataIsSaved(){
		ResponseEntity<String> res = restTemplate.getForEntity("/users/1", String.class);
		assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);

		DocumentContext body = JsonPath.parse(res.getBody());
        Number id = body.read("$.id");
		assertThat(id).isEqualTo(1);
		
		String username = body.read("$.username");
		assertThat(username).isEqualTo("Ole");
		
		String email = body.read("$.email");
		assertThat(email).isEqualTo("ole@gmail.com");

		LocalDate dob = LocalDate.parse(body.read("$.dob"));
		assertThat(dob).isEqualTo(LocalDate.of(2002, Month.MARCH, 10));
	}

	@Test
	void shouldNotReturnAUserWhenGivenUnknownID(){
		ResponseEntity<String> res = restTemplate.getForEntity("/users/10", String.class);
		assertThat(res.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
	}


	/*
	 * Testing GET /users?limit=2 -> getUsers()
	 */
	@Test
	void shouldReturnAListOfTwoUsers(){
		ResponseEntity<String> res = restTemplate.getForEntity("/users?limit=2", String.class);
		assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		//DocumentContext body = JsonPath.parse(res.getBody());
	}
		@Test
	void shouldReturnAllUsers(){
		ResponseEntity<String> res = restTemplate.getForEntity("/users", String.class);
		assertThat(res.getStatusCode()).isEqualTo(HttpStatus.OK);
		
		//DocumentContext body = JsonPath.parse(res.getBody());
	}

}

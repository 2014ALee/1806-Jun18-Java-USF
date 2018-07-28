package com.revature.test.controllers;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import net.minidev.json.JSONObject;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration("classpath:beans.xml")
public class UserControllerTest {

	private int id;
	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
		RestAssuredMockMvc.mockMvc(mockMvc);
	}

	@Test 
	public void testGetAllCards() {
		given().
		when().
		get("http://localhost:9999/spring-hibernate/flashcards").
		then().
		statusCode(HttpStatus.SC_OK).
		contentType("application/json").
		body(equalTo("[{\"id\":1,\"question\":\"test\",\"answer\":\"answer\"},"
				+ "{\"id\":2,\"question\":\"What does DI promote?\",\"answer\":\"loose-coupling\"},"
				+ "{\"id\":3,\"question\":\"What is the primary IOC container in Spring?\",\"answer\":\"ApplicationContext\"},"
				+ "{\"id\":4,\"question\":\"What are the Spring stereotype annotations?\",\"answer\":\"@Component, @Controller, @Service, and @Repository\"},"
				+ "{\"id\":5,\"question\":\"What is the difference between ApplicationContext and BeanFactory with regard to bean instantiation?\",\"answer\":\"BeanFactory lazily instantiates beans, while ApplicationContext eagerly loads beans\"}]"));
	}
	
	@Test 
	public void testGetCardByValidId() {
		this.id = 1;
		
		given().
		when().
		get("http://localhost:9999/spring-hibernate/flashcards/" + id).
		then().
		statusCode(HttpStatus.SC_OK).
		contentType("application/json").
		body(equalTo("{\"id\":1,\"question\":\"test\",\"answer\":\"answer\"}"));
	}
	
	@Test
	public void testCreateValidCard() {
		JSONObject requestParams = new JSONObject();
		requestParams.put("question", "added question");
		requestParams.put("answer", "added answer");
		
		given().
		header("Content-Type", "application/json").
		body(requestParams.toJSONString()).
		when().
		post("http://localhost:9999/spring-hibernate/flashcards/").
		then().
		statusCode(HttpStatus.SC_CREATED).
		contentType("application/json").
		body(equalTo("{\"id\":6,\"question\":\"added question\",\"answer\":\"added answer\"}"));
	}
	
	@Ignore
	@Test
	public void testValidUpdateCard() {
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("id", 6);
		requestParams.put("question", "What other annotations are implied when we use @SpringBootApplication?");
		requestParams.put("answer", "@Configuration and @ComponentScan");
		
		given().
		header("Content-Type", "application/json").
		body(requestParams.toJSONString()).
		when().
		put("http://localhost:9999/spring-hibernate/flashcards").
		then().
		statusCode(HttpStatus.SC_OK).
		contentType("application/json").
		body(equalTo("{\"id\":6,\"question\":\"What other annotations are implied when we use @SpringBootApplication?\",\"answer\":\"@Configuration and @ComponentScan\"}"));
	}
	
	@Ignore
	@Test
	public void testDeleteCardByValidId() {
		
		this.id = 6;
		
		given().
		when().
		delete("http://localhost:9999/spring-hibernate/flashcards/" + id).
		then().
		statusCode(HttpStatus.SC_OK).
		body(equalTo(""));
	}
}

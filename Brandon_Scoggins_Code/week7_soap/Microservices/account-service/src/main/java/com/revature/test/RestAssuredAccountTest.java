package com.revature.test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;

import com.revature.models.Account;

import static org.hamcrest.core.IsEqual.equalTo;

public class RestAssuredAccountTest {

    // use basic RestAssured to get a JSON object from url
    // and parse with the built in assertions using Hamcrest matchers
	
	// Set the url where we can find the exposed endpoints
	static String url = "http://localhost:8765/ms-demo/account";
	
	// Get the information and display to visually check it
    @Test
    public void canGetAndReadAllAccounts() {
        RestAssured.get(url).prettyPrint();
    }
    
    // Retrieve a specific field from the exposed resource and compare it to an expected value
    	// Returns the object and its methods. Requires a local mirror of the model
    @Test
    public void canGetAccount1() {
    	long accountId = RestAssured.get(url + "/1").as(Account.class).getAccountId();
    	
//    	assertEquals(expected, actual);
    	assertEquals(1, accountId);
    }
    
    // Another way to compare expected vs actual fields
    	// Returns the specified field and performs the specified check
    @Test
    public void canGetAccount2() {
    	RestAssured.get(url + "/2").then().assertThat().body("accountId", equalTo(2));
    }
    
    
    // Can compare objects
    @Test
    public void getAccount1IsCorrect() {
    	Account account1 = new Account(1l, 1l, 500.0);
    	
    	assertEquals(account1, RestAssured.get(url + "/1").as(Account.class));
    }
    
    // Check for an expected status code when accessing an endpoint
    @Test
    public void getAccount_1_StatusCodeIs_200() {
    	RestAssured.get(url + "/1").then().assertThat().statusCode(200);
    }
}
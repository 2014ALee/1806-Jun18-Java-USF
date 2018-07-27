package com.revature.controllers;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/test")
public class TestController {

	@ResponseBody // says the return of this method is the response to the client
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.TEXT_PLAIN_VALUE)
	public String test() {
		return "hello, spring mvc!";
	}
}
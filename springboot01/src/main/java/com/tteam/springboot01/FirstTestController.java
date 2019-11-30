package com.tteam.springboot01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstTestController {
	
	/*
	 * Get req 
	 */
	@GetMapping("/getMessage")
	public String getMessage() {
		return "Hello World";
	}
	
	/*
	 * Get request that takes one path variable 
	 */
	@GetMapping("/getMsg/{messageId}")
	public String getMessageWithId(@PathVariable String messageId) {
		return "Varible is "+messageId;
		
	}
	
	/*
	 * Get req that takes one request(query) parameter mandatory
	 */
	@GetMapping("/getMsgQ")
	public String getQueryParameter(@RequestParam("userId")String uid) {
		return "Request Parameter is "+uid;
	}
	
	/*
	 * Get req that takes one request(query) parameter optional
	 */
	@GetMapping("/getMsgQ2")
	public String getQueryParameter2(@RequestParam(value="userId", required = false, defaultValue = "pshiri")String uid) {
		return "Request Parameter is "+uid;
	}
	
	

}

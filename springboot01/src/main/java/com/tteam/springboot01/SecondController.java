package com.tteam.springboot01;

import java.awt.List;
import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tteam.springboot01.model.Employee;

@RestController
public class SecondController {
	
	/*
	 * Receive Json and reutn OK message
	 */
	@PostMapping("/showJson")
	public ResponseEntity<Object> receiveJson(@RequestBody Employee emp){
		System.out.println(emp.getUserName());
		System.out.println(emp.getPassword());
		return new ResponseEntity<Object>(HttpStatus.OK);
	}
	
	/*
	 * Receive Json and return OK message
	 */
	@PostMapping("/showJson2")
	public ResponseEntity<Object> receiveJson2(@RequestBody Employee emp){
		if(emp.getUserName().equals("")) {
			return new ResponseEntity<Object>("invalid name",HttpStatus.NOT_FOUND);
		}
			
		return new ResponseEntity<Object>(emp,HttpStatus.OK);
	}
	
	/*
	 * Receive Json and return OK message
	 */
	@GetMapping("/showJson3")
	public ResponseEntity<ArrayList<?>> receiveJson3(){
		ArrayList<Employee> empList = getAllEmployee();
		if(empList == null) {
			return new ResponseEntity("empty list",HttpStatus.NOT_FOUND);
		}
			
		return new ResponseEntity(empList,HttpStatus.OK);
	}

	private ArrayList<Employee> getAllEmployee() {
		ArrayList<Employee> list = new ArrayList<Employee>();
		Employee emp1 = new Employee();
		emp1.setUserName("user1");
		emp1.setPassword("password");
		
		Employee emp2 = new Employee();
		emp2.setUserName("user2");
		emp2.setPassword("password");
		
		list.add(emp2);
		list.add(emp1);
		return list;
	}
}

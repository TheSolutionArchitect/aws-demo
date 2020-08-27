package com.awstechguide.aws.springbootdynamodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awstechguide.aws.springbootdynamodb.domain.User;
import com.awstechguide.aws.springbootdynamodb.repository.UserDetailRepository;


@RestController
@RequestMapping("/awstg")
public class UserController {

	@Autowired
	private UserDetailRepository userrepo;
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<User> getOneUser(@PathVariable String userId){
		User user= null;//userrepo.getUserDetails(userId);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@PostMapping("/user")
	public String saveUser(@RequestBody User user){
		//userrepo.addUserDetails(user);
		return "Record Inserted Successfully";
	}
}

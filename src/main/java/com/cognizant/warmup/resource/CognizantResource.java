package com.cognizant.warmup.resource;

import org.springframework.web.bind.annotation.RestController;

import com.cognizant.warmup.domain.User;
import com.cognizant.warmup.model.LoginCredential;
import com.cognizant.warmup.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class CognizantResource {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/login")
	public @ResponseBody String login(@RequestBody LoginCredential login) {
		
		User user = userRepository.findByUsernameAndPassword(login.getUsername(), login.getPassword());
		
		if (user != null) {
			
			return "SUCCESS";
		}
		
		return "FAILURE";
		
	}

}

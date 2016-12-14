package com.lolbbs.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	@RequestMapping(value="/{user}", method=RequestMethod.GET)
    public Long getUser(@PathVariable Long user) {
		
		return user;
        // ...
    }
    
}

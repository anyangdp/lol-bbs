package com.lolbbs.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lolbbs.domain.Greeting;

@RestController
public class GreetingController {
	private static final String template = "Hello,sss %s!";
    private final AtomicLong counter = new AtomicLong();

    @Value("${name}")
    private String name;

    @RequestMapping("/hellos")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }

    @RequestMapping("/name")
    public  String getss() {
    	String sss = "ss";
        return this.name;
    }
}

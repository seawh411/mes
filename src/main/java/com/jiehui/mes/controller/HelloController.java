package com.jiehui.mes.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jiehui.mes.entity.Greeting;

@RestController
public class HelloController {
	
	private final  Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/home")
	 String home() {
		return "Hello World!";
	}

	@RequestMapping("/index")
	 public String index() {
		logger.info("index");
		return "Index";		
		
	}
	
	@RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }
}

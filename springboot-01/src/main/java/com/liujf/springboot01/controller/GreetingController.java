package com.liujf.springboot01.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.liujf.springboot01.service.HelloWorldService;
import com.liujf.springboot01.vo.GreetingVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String TEMPLATE = "say: %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private HelloWorldService helloWorldService;

	@GetMapping("/greeting")
	public GreetingVO greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		String lang = helloWorldService.sayHello();
		return new GreetingVO(counter.incrementAndGet(), String.format(TEMPLATE, lang));
	}
}

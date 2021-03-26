package com.liujf.springboot01.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.liujf.springboot01.vo.GreetingVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public GreetingVO greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new GreetingVO(counter.incrementAndGet(), String.format(template, name));
	}
}

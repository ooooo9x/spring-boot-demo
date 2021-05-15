package com.liujf.springboot01.service.impl;

import com.liujf.springboot01.service.HelloWorldService;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public String sayHello() {
        return "hello world";
    }
}

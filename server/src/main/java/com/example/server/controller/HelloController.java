package com.example.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.csp.sentinel.annotation.SentinelResource;

@RestController
public class HelloController {
  
  @GetMapping(value="/hello/{str}")
  @SentinelResource("hello")
  public String Hello(@PathVariable String str) {
    return "hello:"+str;
  }
}

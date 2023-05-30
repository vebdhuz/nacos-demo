package com.example.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  
  @GetMapping(value="/hello/{str}")
  public String Hello(@PathVariable String str) {
    return "hello:"+str;
  }
}

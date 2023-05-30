package com.example.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.client.service.HelloClient;

@RestController
@RefreshScope
public class HelloController {

  @Autowired
  private HelloClient helloClient;

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping("/hello")
  public String Hello() {
    return helloClient.Hello("asdfasdga");
  }

  @Value("${provider.url:}")
  private String apiUrl;

  @GetMapping("/hello1")
  public String Hello1() {
    return restTemplate.getForObject(apiUrl + "/hello/{str}", String.class, "abc124");
  }
}

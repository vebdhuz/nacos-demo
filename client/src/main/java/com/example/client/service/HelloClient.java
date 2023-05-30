package com.example.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="provider")
public interface HelloClient {

  @GetMapping("/hello/{str}")
  String Hello(@PathVariable String str);
}

package com.example.client.tools;

import java.util.concurrent.Executor;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.alibaba.nacos.NacosConfigProperties;
import org.springframework.stereotype.Component;

import com.alibaba.nacos.api.config.listener.Listener;
import com.alibaba.nacos.api.exception.NacosException;

@Component
public class ConfigListener {
  @Autowired
  private NacosConfigProperties nacosConfigProperties;
  
  @PostConstruct
  public void init() {
    String dataId = "consumer.properties";
    String group = "DEFAULT_GROUP";

    try {
      nacosConfigProperties.configServiceInstance().addListener(dataId, group, (Listener) new Listener() {
        @Override
        public void receiveConfigInfo(String configInfo) {
          System.out.println("Nacos Config Updated: " + configInfo);
        }

        @Override
        public Executor getExecutor() {
          return null;
        }
      });
    } catch (NacosException e) {
      e.printStackTrace();
    }
  }
}

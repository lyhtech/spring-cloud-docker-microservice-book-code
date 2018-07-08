package com.itmuch.cloud.study.controller;

import com.itmuch.cloud.study.entity.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.itmuch.cloud.study.entity.User;
import com.itmuch.cloud.study.repository.UserRepository;

@RestController
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  Environment env;

  @GetMapping("/{id}")
  public User findById(@PathVariable Long id) {
    User findOne = this.userRepository.findOne(id);
    return findOne;
  }

  @GetMapping("/test/{timeZone}")
  public UserConfig userTest(@PathVariable String timeZone) {
    UserConfig config = new UserConfig();
    config.setTimeZone(timeZone);
    config.setServer(env.getProperty("iotconfig.netServerAddress"));
    return config;
  }
}

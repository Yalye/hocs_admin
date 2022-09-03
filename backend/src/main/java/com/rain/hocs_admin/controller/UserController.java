package com.rain.hocs_admin.controller;

import com.rain.hocs_admin.model.User;
import com.rain.hocs_admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rain
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

//  @PostMapping(value = "/login")
//  public ResponseBody String processLogin(String username, String password){
//    User user = userRepository.findUserByUsername(username);
//
//  }

  @PostMapping(value = "/register")
  public @ResponseBody String processRegister(String username, String password){
    User user = userRepository.findUserByUsername(username);
    if (null == user){
      User newUser = new User();
      newUser.setUsername(username);
      System.out.println(username);
      System.out.println(password);
      String encryptedPassword = passwordEncoder.encode(password);
      newUser.setPassword(encryptedPassword);
      userRepository.save(newUser);
      return "Register succeed";
    } else {
      // 已经注册过了
      return "Register failed";
    }
  }

}

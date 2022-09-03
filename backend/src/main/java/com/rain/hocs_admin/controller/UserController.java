package com.rain.hocs_admin.controller;

import com.rain.hocs_admin.model.User;
import com.rain.hocs_admin.repository.UserRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rain
 */
@RestController
@RequestMapping("/user")
@CrossOrigin
//    (originPatterns = "http://localhost:9527")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @GetMapping(value = "/info")
  @ResponseBody
  public ResponseEntity getUserInfoByToken(String token){
//    return {"code":20000,"data":{"roles":["admin"],"introduction":"I am a super administrator","avatar":"https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif","name":"Super Admin"}}
    User user = userRepository.findUserByToken(token);
    Map<String, Object> content = new HashMap<>();
    Map<String, Object> data = new HashMap<>();
    if (null == user) {
      return new ResponseEntity(null, HttpStatus.NO_CONTENT);
    } else {
      content.put("token", user.getToken());
      content.put("introduction", "Editor is me");
      content.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
      content.put("name", "Normal Editor");
      content.put("roles", Arrays.asList("editor"));
      data.put("data", content);
      data.put("code", 20000);
      return new ResponseEntity(data, HttpStatus.OK);
    }
  }

  @PostMapping(value = "/login")
  @ResponseBody
  public ResponseEntity processLogin(@RequestBody Map<String, Object> payload){
    String username = (String)payload.get("username");
    String password = (String)payload.get("password");
    User user = userRepository.findUserByUsername(username);
    Map<String, Object> content = new HashMap<>();
    Map<String, Object> data = new HashMap<>();
    if (null == user){
      content.put("token", "null");
      data.put("data", content);
      return new ResponseEntity(data, HttpStatus.NO_CONTENT);
    } else {
      String encryptedPassword = passwordEncoder.encode(password);
      if (passwordEncoder.matches(password, encryptedPassword)){
        content.put("token", user.getToken());
        data.put("data", content);
        data.put("code", 20000);
        return new ResponseEntity(data, HttpStatus.OK);
      } else {
        //todo
        return new ResponseEntity(null, HttpStatus.OK);
      }
    }
  }

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

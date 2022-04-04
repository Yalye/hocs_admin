package com.rain.hocs_admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rain
 */
@RestController
@RequestMapping("/news")
public class NewsController {

  @GetMapping("/list")
  public String getNewsList(){
    return "hello";
  }
}

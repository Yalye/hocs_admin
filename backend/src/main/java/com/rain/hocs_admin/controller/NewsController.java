package com.rain.hocs_admin.controller;

import com.rain.hocs_admin.model.News;
import com.rain.hocs_admin.model.Website;
import com.rain.hocs_admin.repository.NewsRepository;
import com.rain.hocs_admin.service.NewsService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rain
 */
@RestController
@RequestMapping("/news")
@CrossOrigin
//@CrossOrigin(origins = "http://localhost:8081")
public class NewsController {

  @Autowired
  private NewsService newsService;

  @GetMapping(value = "/list", params = {"page", "limit", "sort"})
  @ResponseBody
  public ResponseEntity getNewsList(@RequestParam("page") int page, @RequestParam("limit") int size, @RequestParam("sort") String sort){
    List<News> websiteList = newsService.getNews(page, size);
    Map<String, Object> content = new HashMap<>();
    Map<String, Object> data = new HashMap<>();
    content.put("items", websiteList);

    // 默认只看1000条
    content.put("total", 1000);

    data.put("data", content);
    data.put("code", 20000);
    return new ResponseEntity(data, HttpStatus.OK);
  }

  @GetMapping("/hello")
  public String getHello(){
    return "hello";
  }
}

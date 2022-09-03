package com.rain.hocs_admin.controller;

import com.rain.hocs_admin.model.News;
import com.rain.hocs_admin.repository.NewsRepository;
import com.rain.hocs_admin.service.NewsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

  @GetMapping(value = "/list", params = {"page", "size"})
  public @ResponseBody Iterable<News> getNewsList(@RequestParam("page") int page, @RequestParam("size") int size){
    List<News> newses = newsService.getNews(page, size);
    return newses;
  }

  @GetMapping("/hello")
  public String getHello(){
    return "hello";
  }
}

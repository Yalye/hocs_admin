package com.rain.hocs_admin.controller;

import com.rain.hocs_admin.model.News;
import com.rain.hocs_admin.repository.NewsRepository;
import com.rain.hocs_admin.service.NewsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class NewsController {

  @Autowired
  private NewsService newsService;

  @GetMapping(value = "/list", params = {"page"})
  public @ResponseBody
  List<News> getNewsList(@RequestParam("page") int page){
    return newsService.getNews(page);
  }

  @GetMapping("/hello")
  public String getHello(){
    return "hello";
  }
}

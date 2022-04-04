package com.rain.hocs_admin.service;

import com.rain.hocs_admin.model.News;
import com.rain.hocs_admin.repository.NewsRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

/**
 * @author rain
 */
@Service
public class NewsService {

  @Autowired
  private NewsRepository newsRepository;

  public List<News> getNews(int page){
    Pageable firstPageWithTwoElements = PageRequest.of(0, 2, Sort.by(Direction.DESC, "updateTime"));
    Page<News> pageNews = newsRepository.findAll(firstPageWithTwoElements);
    List<News> newses = pageNews.getContent();
    return newses;
  }

}

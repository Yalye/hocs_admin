package com.rain.hocs_admin.service;

import com.rain.hocs_admin.model.News;
import com.rain.hocs_admin.model.Website;
import com.rain.hocs_admin.repository.WebsiteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

/**
 * @author rain
 */
@Service
public class WebsiteService {

  @Autowired
  private WebsiteRepository websiteRepository;

  public Iterable<Website> getWebsites(){
    Iterable<Website> websites = websiteRepository.findAll();
    return websites;
  }
}

package com.rain.hocs_admin.controller;

import com.rain.hocs_admin.model.User;
import com.rain.hocs_admin.model.Website;
import com.rain.hocs_admin.service.WebsiteService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author rain
 */
@RestController
@RequestMapping("/website")
@CrossOrigin
public class WebsiteController {

  @Autowired
  private WebsiteService websiteService;

  @GetMapping(value = "/websites", params = {"page", "limit", "sort"})
  @ResponseBody
  public ResponseEntity getWebsiteList(@RequestParam("page") int page, @RequestParam("limit") int size, @RequestParam("sort") String sort) {
    List<Website> websiteList = websiteService.getWebsites(page, size);
    Map<String, Object> content = new HashMap<>();
    Map<String, Object> data = new HashMap<>();
    content.put("items", websiteList);

    Iterable<Website> websites = websiteService.getWebsites();
    int total_count = 0;
    for (Website website : websites) {
      total_count++;
    }
    content.put("total", total_count);

    data.put("data", content);
    data.put("code", 20000);
    return new ResponseEntity(data, HttpStatus.OK);
  }

}

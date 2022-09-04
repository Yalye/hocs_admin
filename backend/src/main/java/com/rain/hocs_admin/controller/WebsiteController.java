package com.rain.hocs_admin.controller;

import com.rain.hocs_admin.model.User;
import com.rain.hocs_admin.model.Website;
import com.rain.hocs_admin.service.WebsiteService;
import java.sql.Date;
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

  @PostMapping(value = "/create")
  @ResponseBody
  public ResponseEntity createWebsite(@RequestBody Map<String, Object> payload){
    int importance = (int)payload.get("importance");
    String description = (String)payload.get("remark");
    String url = (String)payload.get("url");
    String xpath = (String)payload.get("xpath");
    String prefix = (String)payload.get("prefix");

    Website website = new Website();
    website.setDesc(description);
    website.setImportance(importance);
    website.setSpecialDomain(prefix);
    website.setUrl(url);
    website.setXpath(xpath);
    website.setXpath(xpath);

    Date date = new Date(System.currentTimeMillis());
    website.setAddTime(date);
    websiteService.addWebsite(website);

    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("data", "success");
    return new ResponseEntity(result, HttpStatus.OK);

  }
}

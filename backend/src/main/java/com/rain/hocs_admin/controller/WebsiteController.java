package com.rain.hocs_admin.controller;

import com.rain.hocs_admin.model.Website;
import com.rain.hocs_admin.service.WebsiteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping(value = "/websites")
    public @ResponseBody Iterable<Website> getWebsiteList(){
      Iterable<Website> websites = websiteService.getWebsites();
      return websites;
    }
}

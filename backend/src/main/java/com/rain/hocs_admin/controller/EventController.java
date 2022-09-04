package com.rain.hocs_admin.controller;

import com.rain.hocs_admin.model.HistoryEvent;
import com.rain.hocs_admin.model.News;
import com.rain.hocs_admin.repository.EventRepository;
import com.rain.hocs_admin.service.EventService;
import java.util.ArrayList;
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
@RequestMapping("/event")
@CrossOrigin
public class EventController {

  @Autowired
  private EventRepository eventRepository;

  @Autowired
  private EventService eventService;

//  @GetMapping(value = "/list", params = {"year", "month", "day"})
//public ResponseEntity getEventList(@RequestParam("year") int year, @RequestParam("month") int month, @RequestParam("day") int day){

  @GetMapping(value = "/list")
  @ResponseBody
  public ResponseEntity getEventList(){
    Iterable<HistoryEvent> eventList = eventService.getAllEvent();

    List<HistoryEvent> historyEvents = new ArrayList<>();
    for (HistoryEvent event : eventList) {
      historyEvents.add(event);
    }
    Map<String, Object> content = new HashMap<>();
    Map<String, Object> data = new HashMap<>();
    content.put("items", historyEvents);

    // 默认只看1000条
    content.put("total", historyEvents.size());

    data.put("data", content);
    data.put("code", 20000);
    return new ResponseEntity(data, HttpStatus.OK);
  }

}

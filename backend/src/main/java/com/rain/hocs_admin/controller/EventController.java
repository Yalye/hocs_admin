package com.rain.hocs_admin.controller;

import com.rain.hocs_admin.model.HistoryEvent;
import com.rain.hocs_admin.model.News;
import com.rain.hocs_admin.model.Website;
import com.rain.hocs_admin.repository.EventRepository;
import com.rain.hocs_admin.service.EventService;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.persistence.criteria.CriteriaBuilder.In;
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
  public ResponseEntity getEventList(@RequestParam("year") Optional<Integer> year,
      @RequestParam("month") Optional<Integer> month,
      @RequestParam("day") Optional<Integer> day){
    Iterable<HistoryEvent> eventList = eventService.getAllEvent();

    List<HistoryEvent> historyEvents = new ArrayList<>();
    for (HistoryEvent event : eventList) {
      historyEvents.add(event);
    }

    if (year.isPresent() && month.isPresent() && day.isPresent()){
//      historyEvents = eventService.getAllEventByParams(year.get());
      historyEvents = eventRepository.findByYearAndMonthAndDay(year.get(),month.get(),day.get());
    } else if (month.isPresent() && day.isPresent()) {
      historyEvents = eventRepository.findByMonthAndDay(month.get(),day.get());
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

  @PostMapping(value = "/create")
  @ResponseBody
  public ResponseEntity createWebsite(@RequestBody Map<String, Object> payload){
    String title = (String)payload.get("title");
    int year = (int)payload.get("year");
    int month = (int)payload.get("month");
    int day = (int)payload.get("day");

    HistoryEvent event = new HistoryEvent();
    event.setEventTitle(title);
    event.setYear(year);
    event.setMonth(month);
    event.setDay(day);

    eventRepository.save(event);

    Map<String, Object> result = new HashMap<>();
    result.put("code", 20000);
    result.put("data", "success");
    return new ResponseEntity(result, HttpStatus.OK);
  }
}

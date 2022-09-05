package com.rain.hocs_admin.service;

import com.rain.hocs_admin.model.HistoryEvent;
import com.rain.hocs_admin.model.News;
import com.rain.hocs_admin.repository.EventRepository;
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
public class EventService {

  @Autowired
  private EventRepository eventRepository;

  public Iterable<HistoryEvent> getAllEvent(){
    Iterable<HistoryEvent> events = eventRepository.findAll();
    return events;
  }

  public List<HistoryEvent> getAllEventByParams(int year){
    List<HistoryEvent> events = eventRepository.findByYear(year);
    return events;
  }
}

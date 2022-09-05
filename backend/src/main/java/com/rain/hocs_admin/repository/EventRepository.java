package com.rain.hocs_admin.repository;

import com.rain.hocs_admin.model.HistoryEvent;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rain
 */
@Repository
public interface EventRepository extends PagingAndSortingRepository<HistoryEvent, Integer> {
  public List<HistoryEvent> findByYear(int year);

  public List<HistoryEvent> findByYearAndMonthAndDay(int year, int month, int day);

  public List<HistoryEvent> findByMonthAndDay(int month, int day);

}

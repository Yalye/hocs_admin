package com.rain.hocs_admin.repository;

import com.rain.hocs_admin.model.HistoryEvent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rain
 */
@Repository
public interface EventRepository extends PagingAndSortingRepository<HistoryEvent, Integer> {

}

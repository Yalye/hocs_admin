package com.rain.hocs_admin.repository;

import com.rain.hocs_admin.model.News;
import com.rain.hocs_admin.model.Website;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

/**
 * @author rain
 */
@Repository
public interface WebsiteRepository extends PagingAndSortingRepository<Website, Integer> {
}

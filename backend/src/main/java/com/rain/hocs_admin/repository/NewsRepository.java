package com.rain.hocs_admin.repository;

import com.rain.hocs_admin.model.News;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author rain
 */
@Repository
public interface NewsRepository extends PagingAndSortingRepository<News, Integer> {
//  Page<News> findAll(Pageable pageable);
}

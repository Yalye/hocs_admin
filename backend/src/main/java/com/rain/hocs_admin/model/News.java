package com.rain.hocs_admin.model;

import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author rain
 */
@Entity
@Table(name = "tb_news_info")
public class News {
  @Id
  private Integer id;

  private String title;

  private String url;

  private LocalTime updateTime;

  private String author;

  private String website;


}

package com.rain.hocs_admin.model;

import java.sql.Date;
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

  private String title;

  @Id
  private String url;

  private Date updateTime;

  private String author;

  private String website;

  @Override
  public String toString(){
    return title + ": " + url;
  }
}

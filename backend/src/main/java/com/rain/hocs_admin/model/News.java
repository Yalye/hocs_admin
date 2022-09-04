package com.rain.hocs_admin.model;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author rain
 */
@Entity
@Table(name = "tb_news_info")
@Data
public class News {

  private String title;

  @Id
  private String url;

  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private Date updateTime;

  private String author;

  private String website;

  @Override
  public String toString(){
    return title + ": " + url;
  }
}

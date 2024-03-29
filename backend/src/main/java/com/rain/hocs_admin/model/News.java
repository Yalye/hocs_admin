package com.rain.hocs_admin.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TemporalType;
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

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")
  private Date updateTime;

  private String author;

  private String website;

  @Override
  public String toString(){
    return title + ": " + url;
  }
}

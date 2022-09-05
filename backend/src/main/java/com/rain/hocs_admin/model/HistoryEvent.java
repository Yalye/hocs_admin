package com.rain.hocs_admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author rain
 */
@Entity
@Table(name = "tb_history_event")
@Data
public class HistoryEvent {

  @Id
  private int id;

  private String eventTitle;

  @Column(name = "event_year")
  private int year;

  @Column(name = "event_month")
  private int month;

  @Column(name = "event_day")
  private int day;
}

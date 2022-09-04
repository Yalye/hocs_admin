package com.rain.hocs_admin.model;

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

  private int eventYear;

  private int eventMonth;

  private int eventDay;
}

package com.rain.hocs_admin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import java.sql.Date;


/**
 * @author rain
 */
@Entity
@Table(name = "tb_website_info")
@Data
public class Website {
  @Id
  private String url;

  @Column(name = "des")
  private String desc;

  private String xpath;

  @Column(name = "special_domain")
  private String prefix;

  private int usingProxy;

  private Date addTime;

  private int importance;
}

package com.rain.hocs_admin.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 * @author rain
 */
@Entity
@Table(name = "tb_user")
@Data
public class User {

  @Id
  private int id;

  private String username;

  private String password;
}

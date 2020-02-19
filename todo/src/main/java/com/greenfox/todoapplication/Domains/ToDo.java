package com.greenfox.todoapplication.Domains;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
public class ToDo {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long toDoId;

  private String title;
  private String content;
  private boolean urgent;
  private boolean done;

  @Temporal(TemporalType.TIMESTAMP)
  private Date date;

  @ManyToOne()
  private Assignee assignee;

  public ToDo(String title, String content, Assignee assignee) {
    this.title = title;
    this.content = content;
    this.done = false;
    this.urgent = false;
    this.assignee = assignee;
    this.date = new Date();
  }

 /* public ToDo(String title, String content) {
    this.title = title;
    this.content = content;
    this.done = false;
    this.urgent = false;
    this.date = new Date();
  }

  */

  public ToDo() {
  }
}

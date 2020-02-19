package com.greenfox.todoapplication.Domains;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Data;

@Entity
@Data
public class Assignee {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long assigneeId;

  private String name;
  private String email;

  @OneToMany(mappedBy = "assignee")
  private List<ToDo> toDos;

  public Assignee(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public Assignee() {
  }
}

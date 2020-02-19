package com.greenfox.todoapplication.Repositories;

import com.greenfox.todoapplication.Domains.Assignee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssigneeRepo extends CrudRepository<Assignee, Long> {
  Assignee findByName(String name);
}

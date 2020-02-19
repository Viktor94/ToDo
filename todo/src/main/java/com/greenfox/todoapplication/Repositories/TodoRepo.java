package com.greenfox.todoapplication.Repositories;

import com.greenfox.todoapplication.Domains.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepo extends CrudRepository<ToDo, Long> {
}

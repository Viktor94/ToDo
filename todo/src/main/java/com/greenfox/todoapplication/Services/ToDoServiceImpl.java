package com.greenfox.todoapplication.Services;

import com.greenfox.todoapplication.Domains.ToDo;
import com.greenfox.todoapplication.Repositories.TodoRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToDoServiceImpl implements ToDoService {

  TodoRepo todoRepo;

  @Autowired
  public ToDoServiceImpl(TodoRepo todoRepo) {
    this.todoRepo = todoRepo;
  }

  public List<ToDo> findAlL() {
    return (List<ToDo>) todoRepo.findAll();
  }

  public void saveToDo(ToDo toDo) {
    todoRepo.save(toDo);
  }
}

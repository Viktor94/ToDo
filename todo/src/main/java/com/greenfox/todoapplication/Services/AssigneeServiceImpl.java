package com.greenfox.todoapplication.Services;

import com.greenfox.todoapplication.Domains.Assignee;
import com.greenfox.todoapplication.Repositories.AssigneeRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssigneeServiceImpl implements AssigneeService {

  AssigneeRepo assigneeRepo;

  @Autowired
  public AssigneeServiceImpl(AssigneeRepo assigneeRepo) {
    this.assigneeRepo = assigneeRepo;
  }

  public List<Assignee> findAlL() {
    return (List<Assignee>) assigneeRepo.findAll();
  }

  public void saveAssignee(Assignee assignee) {
    assigneeRepo.save(assignee);
  }

  @Override
  public Assignee findByName(String name) {
    return assigneeRepo.findByName(name);
  }
}

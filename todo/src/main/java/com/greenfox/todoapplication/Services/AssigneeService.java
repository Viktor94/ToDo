package com.greenfox.todoapplication.Services;

import com.greenfox.todoapplication.Domains.Assignee;

public interface AssigneeService {
  Assignee findByName(String name);
}

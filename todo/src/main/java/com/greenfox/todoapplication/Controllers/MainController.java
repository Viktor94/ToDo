package com.greenfox.todoapplication.Controllers;

import com.greenfox.todoapplication.Domains.Assignee;
import com.greenfox.todoapplication.Domains.ToDo;
import com.greenfox.todoapplication.Repositories.AssigneeRepo;
import com.greenfox.todoapplication.Repositories.TodoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

  AssigneeRepo assigneeRepo;
  TodoRepo todoRepo;

  @Autowired
  public MainController(AssigneeRepo assigneeRepo,
      TodoRepo todoRepo) {
    this.assigneeRepo = assigneeRepo;
    this.todoRepo = todoRepo;
  }

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("listOfToDos", todoRepo.findAll());
    model.addAttribute("listOfAssignees", assigneeRepo.findAll());
    return "index";
  }

  @GetMapping("/assignee")
  public String assignees(Model model) {
    model.addAttribute("listOfAssignees", assigneeRepo.findAll());
    return "index";
  }

  @GetMapping("/save-todo")
  public String saveTodoGet(Model model, @ModelAttribute ToDo toDo) {
    model.addAttribute("toDo", toDo);
    return "saveToDo";
  }

  @PostMapping("/save-todo")
  public String saveTodoPost(@ModelAttribute ToDo toDo) {
    todoRepo.save(toDo);
    return "redirect:/";
  }

  @GetMapping("/save-assignee")
  public String saveAssigneeGet(Model model, @ModelAttribute Assignee assignee) {
    model.addAttribute("assignee", assignee);
    return "saveAssignee";
  }

  @PostMapping("/save-assignee")
  public String saveAssigneePost(@ModelAttribute Assignee assignee) {
    assigneeRepo.save(assignee);
    return "redirect:/";
  }

  @PostMapping("/{id}/deleteToDo")
  public String deleteToDoPost(@PathVariable Long id) {
    todoRepo.deleteById(id);
    return "redirect:/";
  }

  @PostMapping("/{id}/deleteAssignee")
  public String deleteAssignee(@PathVariable Long id) {
    assigneeRepo.deleteById(id);
    return "redirect:/";
  }

  @GetMapping("/{id}/editToDo")
  public String editToDoGet(Model model, @PathVariable Long id) {
    if (todoRepo.findById(id).isPresent()) {
      model.addAttribute("item", todoRepo.findById(id).get());
      model.addAttribute("assign", assigneeRepo.findAll());
      todoRepo.deleteById(id);
      return "edit";
    }
    return "redirect:/";
  }

  @PostMapping("/{id}/editToDo")
  public String editToDoPost(@ModelAttribute(name = "todo") ToDo todo, String assig) {
    Assignee assignee = assigneeRepo.findByName(assig);
    todo.setAssignee(assignee);
    todoRepo.save(todo);
    return "redirect:/";
  }
}

package com.ruanzz.controller;

import com.ruanzz.entity.User;
import com.ruanzz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Zhenzhuo.Ruan
 */
@RestController
@RequestMapping("/demos")
public class DemoController {

  @Autowired
  UserService userService;

  @GetMapping("/{id}")
  public String details(@PathVariable(value = "id") Long id) {
    userService.list().forEach(System.out::println);
    User user = new User();
    user.setAge(11);
    userService.save(user);
    System.out.println(userService.getById(6));
    return String.valueOf(id);
  }
}

package edu.ib.technologiesieciowe.controller;

import edu.ib.technologiesieciowe.model.User;
import edu.ib.technologiesieciowe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {this.userService = userService;}

    @GetMapping("/getAll")
    public @ResponseBody Iterable<User> getAll() {return userService.getAll();}

    @GetMapping("/{userId}")
    public User getOne(@PathVariable int userId) {
        return userService.getOne(userId);
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody User create(@RequestBody User user) {
        return userService.create(user);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int userId) {
        userService.delete(userId);
    }
}

package edu.ib.technologiesieciowe.controller;

import edu.ib.technologiesieciowe.entity.User;
import edu.ib.technologiesieciowe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {this.userRepository = userRepository;}

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody User addUser(@RequestBody User user) {return userRepository.save(user);}

    @GetMapping("/getAll")
    public @ResponseBody Iterable<User> getAllUsers() {return userRepository.findAll();}
}

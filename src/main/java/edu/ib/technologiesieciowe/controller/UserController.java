package edu.ib.technologiesieciowe.controller;

import edu.ib.technologiesieciowe.dto.UserDTOs.CreateUserDTO;
import edu.ib.technologiesieciowe.dto.UserDTOs.UserDTO;
import edu.ib.technologiesieciowe.model.User;
import edu.ib.technologiesieciowe.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/user")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {
    private final ModelMapper modelMapper;
    private final UserService userService;

    @Autowired
    public UserController(ModelMapper modelMapper, UserService userService) {
        this.modelMapper = modelMapper;
        this.userService = userService;}

    @GetMapping("/getAll")
    public @ResponseBody Iterable<UserDTO> getAll() {
        Iterable<User> users = userService.getAll();
        return mapUsersToDTOs(users);
    }

    @GetMapping("/{userId}")
    public UserDTO getOne(@PathVariable int userId) {
        User user = userService.getOne(userId);
        return modelMapper.map(user, UserDTO.class);
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody UserDTO create(@RequestBody CreateUserDTO createUserDTO) {
        User user = modelMapper.map(createUserDTO, User.class);
        User createdUser = userService.create(user);
        return modelMapper.map(createdUser, UserDTO.class);
    }

    @DeleteMapping("/{userId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int userId) {
        userService.delete(userId);
    }

    private Iterable<UserDTO> mapUsersToDTOs(Iterable<User> users) {
        return StreamSupport.stream(users.spliterator(), false)
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

}

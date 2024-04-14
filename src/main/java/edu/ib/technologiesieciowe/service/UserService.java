package edu.ib.technologiesieciowe.service;

import edu.ib.technologiesieciowe.dto.UserDTOs.UserDTO;
import edu.ib.technologiesieciowe.exception.EntityNotFoundException;
import edu.ib.technologiesieciowe.model.Auth;
import edu.ib.technologiesieciowe.model.User;
import edu.ib.technologiesieciowe.repository.AuthRepository;
import edu.ib.technologiesieciowe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final AuthRepository authRepository;

    @Autowired
    public UserService(UserRepository userRepository, AuthRepository authRepository) {
        this.userRepository = userRepository;
        this.authRepository = authRepository;
    }

    public UserDTO getUserByUsername(String username) {
        Auth auth = authRepository.findByUsername(username).orElseThrow(EntityNotFoundException::create);
        User user = auth.getUser();

        return new UserDTO(user.getUserId(), user.getName(), user.getAge(), user.getEmail());
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public User getOne(int userId) {
        return userRepository.findById(userId).orElseThrow(EntityNotFoundException::create);
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public void delete(int userId) {
        if (!userRepository.existsById(userId)) {
            throw EntityNotFoundException.create();
        }
        userRepository.deleteById(userId);
    }
}

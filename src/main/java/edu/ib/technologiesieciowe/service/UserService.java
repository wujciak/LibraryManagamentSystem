package edu.ib.technologiesieciowe.service;

import edu.ib.technologiesieciowe.model.User;
import edu.ib.technologiesieciowe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }

    public User getOne(int userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User create(User user) {
        return userRepository.save(user);
    }

    public void delete(int userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException();
        }
        userRepository.deleteById(userId);
    }
}

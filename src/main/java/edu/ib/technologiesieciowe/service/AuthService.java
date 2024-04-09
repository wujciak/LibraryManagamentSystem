package edu.ib.technologiesieciowe.service;

import edu.ib.technologiesieciowe.dto.UserDTOs.LoginResponseDTO;
import edu.ib.technologiesieciowe.dto.UserDTOs.LoginDTO;
import edu.ib.technologiesieciowe.dto.UserDTOs.RegisterDTO;
import edu.ib.technologiesieciowe.dto.UserDTOs.RegisterResponseDTO;
import edu.ib.technologiesieciowe.model.Auth;
import edu.ib.technologiesieciowe.model.User;
import edu.ib.technologiesieciowe.repository.AuthRepository;
import edu.ib.technologiesieciowe.repository.UserRepository;
import edu.ib.technologiesieciowe.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuthService {
    private final AuthRepository authRepository;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthService(AuthRepository authRepository, UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.authRepository = authRepository;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public RegisterResponseDTO register(RegisterDTO dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setEmail(dto.getEmail());
        userRepository.save(user);

        Auth auth = new Auth();
        auth.setPassword(passwordEncoder.encode(dto.getPassword()));
        auth.setUsername(dto.getUsername());
        auth.setRole(dto.getRole());
        auth.setUser(user);

        authRepository.save(auth);

        return new RegisterResponseDTO(user.getUserId(), auth.getUsername(), auth.getRole());
    }

    public LoginResponseDTO login(LoginDTO dto) {
        Auth auth = authRepository.findByUsername(dto.getUsername()).orElseThrow(RuntimeException::new);

        if(!passwordEncoder.matches(dto.getPassword(), auth.getPassword())) {
            throw new RuntimeException();
        }

        String token = jwtService.generateToken(auth);

        return new LoginResponseDTO(token);
    }
}

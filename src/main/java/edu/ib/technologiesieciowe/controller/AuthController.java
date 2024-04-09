package edu.ib.technologiesieciowe.controller;

import edu.ib.technologiesieciowe.dto.UserDTOs.LoginDTO;
import edu.ib.technologiesieciowe.dto.UserDTOs.LoginResponseDTO;
import edu.ib.technologiesieciowe.dto.UserDTOs.RegisterDTO;
import edu.ib.technologiesieciowe.dto.UserDTOs.RegisterResponseDTO;
import edu.ib.technologiesieciowe.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<RegisterResponseDTO> register(@RequestBody RegisterDTO requestBody) {
        RegisterResponseDTO dto = authService.register(requestBody);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    @PreAuthorize("permitAll()")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginDTO requestBody) {
        LoginResponseDTO dto = authService.login(requestBody);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}

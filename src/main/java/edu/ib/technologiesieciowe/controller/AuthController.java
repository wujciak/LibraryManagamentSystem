package edu.ib.technologiesieciowe.controller;

import edu.ib.technologiesieciowe.dto.UserDTOs.LoginDTO;
import edu.ib.technologiesieciowe.dto.UserDTOs.LoginResponseDTO;
import edu.ib.technologiesieciowe.dto.UserDTOs.RegisterDTO;
import edu.ib.technologiesieciowe.dto.UserDTOs.RegisterResponseDTO;
import edu.ib.technologiesieciowe.service.AuthService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
@Tag(name = "Authorization")
public class AuthController {
    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @ApiResponse(responseCode = "201")
    public ResponseEntity<RegisterResponseDTO> register(@Valid @RequestBody RegisterDTO requestBody) {
        RegisterResponseDTO dto = authService.register(requestBody);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    @PreAuthorize("permitAll()")
    @SecurityRequirements
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Login succeeded."),
            @ApiResponse(responseCode = "401", description = "Login failed.", content = @Content)
    })
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginDTO requestBody) {
        LoginResponseDTO dto = authService.login(requestBody);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}

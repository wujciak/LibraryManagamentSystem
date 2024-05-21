package edu.ib.technologiesieciowe.controller;

import edu.ib.technologiesieciowe.dto.LoanDTOs.CreateLoanDTO;
import edu.ib.technologiesieciowe.dto.LoanDTOs.LoanDTO;
import edu.ib.technologiesieciowe.enumType.UserRole;
import edu.ib.technologiesieciowe.model.Loan;
import edu.ib.technologiesieciowe.service.LoanService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/loan")
@PreAuthorize("hasRole('ROLE_ADMIN')")
@CrossOrigin
@Tag(name = "Loan")
public class LoanController {
    private final LoanService loanService;
    private final ModelMapper modelMapper;

    @Autowired
    public LoanController(LoanService loanService, ModelMapper modelMapper) {
        this.loanService = loanService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/getAll")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_READER')")
    public @ResponseBody Iterable<LoanDTO> getAll(Authentication authentication) {
        UserRole role = getRoleFromAuthentication(authentication);
        Iterable<Loan> loans = loanService.getAll(role, authentication.getName());
        return mapLoansToDTOs(loans);
    }

    private UserRole getRoleFromAuthentication(Authentication authentication) {
        for (GrantedAuthority authority : authentication.getAuthorities()) {
            if (authority.getAuthority().equals("ROLE_ADMIN")) {
                return UserRole.ROLE_ADMIN;
            } else if (authority.getAuthority().equals("ROLE_READER")) {
                return UserRole.ROLE_READER;
            }
        }
        throw new IllegalArgumentException("Invalid user role");
    }

    @GetMapping("/get/{loanId}")
    public LoanDTO getOne(@PathVariable int loanId) {
        Loan loan = loanService.getOne(loanId);
        return modelMapper.map(loan, LoanDTO.class);
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_READER')")
    public @ResponseBody LoanDTO create(@Valid @RequestBody CreateLoanDTO createLoanDTO, Authentication authentication) {
        UserRole role = getRoleFromAuthentication(authentication);
        Loan loan = modelMapper.map(createLoanDTO, Loan.class);
        Loan createdLoan = loanService.create(loan, role);
        return modelMapper.map(createdLoan, LoanDTO.class);
    }

    @DeleteMapping("/delete/{loanId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int loanId) {
        loanService.delete(loanId);
    }

    private Iterable<LoanDTO> mapLoansToDTOs(Iterable<Loan> loans) {
        return StreamSupport.stream(loans.spliterator(), false)
                .map(loan -> modelMapper.map(loan, LoanDTO.class))
                .collect(Collectors.toList());
    }
}

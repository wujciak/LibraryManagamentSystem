package edu.ib.technologiesieciowe.controller;

import edu.ib.technologiesieciowe.model.Loan;
import edu.ib.technologiesieciowe.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loan")
public class LoanController {
    private final LoanService loanService;

    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/getAll")
    public @ResponseBody Iterable<Loan> getAll() {
        return loanService.getAll();
    }

    @GetMapping("/{loanId}")
    public Loan getOne(@PathVariable int loanId) {
        return loanService.getOne(loanId);
    }

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public @ResponseBody Loan create(@RequestBody Loan loan) {
        return loanService.create(loan);
    }

    @DeleteMapping("/{loanId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int loanId) {
        loanService.delete(loanId);
    }
}

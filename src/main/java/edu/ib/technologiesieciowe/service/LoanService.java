package edu.ib.technologiesieciowe.service;

import edu.ib.technologiesieciowe.entity.Loan;
import edu.ib.technologiesieciowe.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    private final LoanRepository loanRepository;

    @Autowired
    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public Iterable<Loan> getAll() {
        return loanRepository.findAll();
    }

    public Loan getOne(int loanId) {
        return loanRepository.findById(loanId).orElseThrow(() -> new RuntimeException("Loan not found"));
    }

    public Loan create(Loan loan) {
        return loanRepository.save(loan);
    }

    public void delete(int loanId) {
        if (!loanRepository.existsById(loanId)) {
            throw new RuntimeException();
        }
        loanRepository.deleteById(loanId);
    }
}

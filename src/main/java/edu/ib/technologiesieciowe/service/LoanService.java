package edu.ib.technologiesieciowe.service;

import edu.ib.technologiesieciowe.enumType.UserRole;
import edu.ib.technologiesieciowe.exception.EntityNotFoundException;
import edu.ib.technologiesieciowe.model.Loan;
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

    public Iterable<Loan> getAll(UserRole role, String username) {
        if (role == UserRole.ROLE_ADMIN) {
            return loanRepository.findAll();
        } else if (role == UserRole.ROLE_READER) {
            return loanRepository.findByAuthUsername(username);
        }
        throw new IllegalArgumentException("Invalid user role");
    }

    public Loan getOne(int loanId) {
        return loanRepository.findById(loanId).orElseThrow(EntityNotFoundException::create);
    }

    public Loan create(Loan loan, UserRole role) {
        if (role == UserRole.ROLE_ADMIN) {
            loan.setDateOfReturn(loan.getDateOfReturn());
        } else {
            loan.setDateOfReturn(null); // Dla czytelnika, data zwrotu nie jest ustawiana
        }

        return loanRepository.save(loan);
    }

    public void delete(int loanId) {
        if (!loanRepository.existsById(loanId)) {
            throw EntityNotFoundException.create();
        }
        loanRepository.deleteById(loanId);
    }
}

package com.revature.ExpenseReport.Services;

import com.revature.ExpenseReport.Controllers.ExpenseDTO;

import com.revature.ExpenseReport.Controllers.ExpenseWOIDDTO;
import com.revature.ExpenseReport.Models.Expense;
import com.revature.ExpenseReport.Models.Report;
import com.revature.ExpenseReport.Repository.ExpenseRepository;
import com.revature.ExpenseReport.Repository.ReportRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    // Repo doesn't know what ExpenseDTO is only Expense type
    //Fields
    //Constructor
    //Methods

    private final ExpenseRepository repository;
    private final ReportRepository reportRepository;

    public ExpenseService(ExpenseRepository repository, ReportRepository reportRepository){
        this.repository = repository;
        this.reportRepository = reportRepository;
    }

    public List<ExpenseDTO> getAllExpenses(){
        // repo returns a list of expenses
        // convert every expense on the list to a DTO
        // keep/put back in a list to return
        // stream api
        return repository.findAll().stream().map(this::ExpenseToDTO).toList();
    }

    public List<ExpenseDTO> searchByExpenseMerchant(String merchant){
        return repository.findByExpenseMerchant(merchant).stream().map(this::ExpenseToDTO).toList();
    }

    public ExpenseDTO create(ExpenseWOIDDTO expenseDTO) {
        Expense entity = new Expense(expenseDTO.expenseDate(), expenseDTO.expenseValue(), expenseDTO.expenseMerchant());
        return ExpenseToDTO(repository.save(entity));
    }

    public ExpenseDTO update(String id, ExpenseDTO dto) {
        Expense expense = repository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));

        expense.setDate(dto.expenseDate());
        expense.setValue(dto.expenseValue());
        expense.setMerchant(dto.expenseMerchant());

        return ExpenseToDTO(repository.save(expense));
    }

    public void delete(String id) {
        repository.deleteById(id);
    }


    private ExpenseDTO ExpenseToDTO(Expense expense){
        return new ExpenseDTO(expense.getId(), expense.getDate(), expense.getValue(), expense.getMerchant());
    }

    public ExpenseDTO getById(String id) {
        Optional<Expense> res = repository.findById(id);
        return (res.isEmpty()) ? null: ExpenseToDTO(res.get());
    }

}

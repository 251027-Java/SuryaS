package com.revature.ExpenseReport.Repository;

import com.revature.ExpenseReport.Models.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, String> {
    // Expense findById(String id);
    //@Query("SELECT * FROM expenses WHERE expenseMerchant=merchant")
    List<Expense> findByExpenseMerchant(String merchant);

}
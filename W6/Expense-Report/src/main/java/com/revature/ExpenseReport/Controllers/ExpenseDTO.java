package com.revature.ExpenseReport.Controllers;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseDTO(String expenseId, LocalDate expenseDate, BigDecimal expenseValue, String expenseMerchant){

}



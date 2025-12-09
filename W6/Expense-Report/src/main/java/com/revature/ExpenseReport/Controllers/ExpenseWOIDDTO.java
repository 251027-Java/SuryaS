package com.revature.ExpenseReport.Controllers;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseWOIDDTO(LocalDate expenseDate, BigDecimal expenseValue, String expenseMerchant){

}

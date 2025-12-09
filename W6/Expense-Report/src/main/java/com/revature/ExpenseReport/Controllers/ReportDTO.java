package com.revature.ExpenseReport.Controllers;

import com.revature.ExpenseReport.Models.Expense;

import java.util.List;

public record ReportDTO(String reportId, String reportTitle, String reportStatus, List<ExpenseDTO> expenses){
}

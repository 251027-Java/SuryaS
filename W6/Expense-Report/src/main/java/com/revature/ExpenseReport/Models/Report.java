package com.revature.ExpenseReport.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reports")
@Data
@NoArgsConstructor
public class Report {
    // fields
    @Id
    @GeneratedValue
    private String reportId;
    private String reportTitle;
    private String reportStatus;

    @OneToMany(mappedBy = "report")
    private List<Expense> reportExpenses = new ArrayList<>();

    // constructor
    public Report(String title, String status) {
        this.reportTitle = title;
        this.reportStatus = status;
    }
}

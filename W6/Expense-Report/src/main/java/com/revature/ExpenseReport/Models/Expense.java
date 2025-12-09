package com.revature.ExpenseReport.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "expenses")
public class Expense {
    // Fields
    @Id @GeneratedValue private String expenseId;

    @Column(name="expenseMerchant")

    private String expenseMerchant;
    private LocalDate expenseDate;
    private BigDecimal expenseValue;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name= "reportId")
    @ToString.Exclude
    private Report report;

    // Constructor
    public Expense(){}

    public Expense(LocalDate date, BigDecimal value, String merchant){
        this.expenseDate = date;
        this.expenseValue = value;
        this.expenseMerchant = merchant;

    }

    // Methods
    public String getId() { return expenseId; }

    public LocalDate getDate(){
        return expenseDate;
    }

    public BigDecimal getValue(){
        return expenseValue;
    }

    public String getMerchant(){
        return expenseMerchant;
    }

    public void setId(String id) { this.expenseId = id; }
    public void setDate(LocalDate date) { this.expenseDate = date; }
    public void setValue(BigDecimal value) { this.expenseValue = value; }
    public void setMerchant(String merchant) { this.expenseMerchant = merchant; }


}

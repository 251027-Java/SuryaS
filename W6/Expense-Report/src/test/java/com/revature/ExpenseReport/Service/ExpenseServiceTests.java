package com.revature.ExpenseReport.Service;

import com.revature.ExpenseReport.Controllers.ExpenseDTO;
import com.revature.ExpenseReport.Models.Expense;
import com.revature.ExpenseReport.Repository.ExpenseRepository;
import com.revature.ExpenseReport.Repository.ReportRepository;
import com.revature.ExpenseReport.Services.ExpenseService;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExpenseServiceTests {
    @Mock
    private ExpenseRepository expenseRepository;

    @InjectMocks
    private ExpenseService expenseService;


    @Test
    public void testExpenseById(){
        // Arrange - preparing any resources/objects we need to run our test
        // Act - action of executing code we're testing
        // Assert - final check
        String id = "2";
        LocalDate date = LocalDate.now();
        Expense savedExpense = new Expense(date, new BigDecimal("332.11"), "Video Games");
        savedExpense.setId(id);

        ExpenseDTO expected = new ExpenseDTO(id, date, new BigDecimal("332.11"), "Video Games");

        when(expenseRepository.findById(id)).thenReturn(Optional.of(savedExpense));

        ExpenseDTO actual = expenseService.getById(id);

        assertThat(actual).isEqualTo(actual);
    }





}

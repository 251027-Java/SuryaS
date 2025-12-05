package com.revature.ExpenseReport;

import com.revature.ExpenseReport.Models.AppUser;
import com.revature.ExpenseReport.Models.Expense;
import com.revature.ExpenseReport.Models.Report;
import com.revature.ExpenseReport.Repository.AppUserRepository;
import com.revature.ExpenseReport.Repository.ExpenseRepository;
import com.revature.ExpenseReport.Repository.ReportRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class ExpenseReportApplication {

	public static void main(String[] args) {
        SpringApplication.run(ExpenseReportApplication.class, args);
	}
    //just before user is ready for application
    @Bean
    CommandLineRunner seedData (ExpenseRepository expenseRepository, ReportRepository reportRepository, AppUserRepository appUserRepository){
        return args -> {

            // expenses seed
            var r1 = new Report("Plano", "Draft");
            var r2 = new Report("Reston", "Submitted");
            reportRepository.save(r1);
            reportRepository.save(r2);

            var e1 = new Expense(LocalDate.now(), new BigDecimal(59.99), "Walmart");
            e1.setReport(r1);
            var e2 = new Expense(LocalDate.now().minusDays(1), new BigDecimal(14.75), "Starbucks");
            e2.setReport(r1);
            var e3 = new Expense(LocalDate.now().minusDays(2), new BigDecimal(99.88), "Buffalo Wild Wings");
            e3.setReport(r2);
            expenseRepository.saveAll(List.of(e1, e2, e3));

            // AppUser Seed

            appUserRepository.save(new AppUser("admin", "password123", "ADMIN"));
            appUserRepository.save(new AppUser("user", "secret", "USER"));
        };
    }




}

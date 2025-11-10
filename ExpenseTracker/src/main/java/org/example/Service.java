package org.example;

import org.example.Repository.IRepository;

import java.util.Date;
import java.util.List;

public class Service {
    private IRepository repo;

    public Service(IRepository repository) {
        this.repo = repository;
    }

    public Expense createNewExpense(int id, double value, String merchant) {
        if (repo.readExpense(id) != null) {
            return null;
        }
        Expense newExpense = new Expense(id, new Date(), value, merchant);
        repo.createExpense(newExpense);
        return newExpense;
    }

    public boolean deleteExpenses(int id) {
        if (repo.readExpense(id) == null) {
            return false;
        }
        repo.deleteExpense(id);
        return true;
    }

    public void printExpenses() {
        System.out.println(repo.loadExpenses());
    }

    public void sumExpenses() {
        List<Expense> expenses = repo.loadExpenses();
        double sum = 0;
        for (Expense e : expenses ){
            sum += e.getValue();
        }
        System.out.println(sum);
    }

}

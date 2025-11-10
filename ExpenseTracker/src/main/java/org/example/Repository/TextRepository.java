package org.example.Repository;

import org.example.Expense;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TextRepository implements IRepository {
    private String fileName = "ExpensesList.txt";

    public TextRepository() {
    }

    @Override
    public void createExpense(Expense expense) {
        List<Expense> expenses = loadExpenses();
        expenses.add(expense);
        saveExpenses(expenses);
    }

    @Override
    public Expense readExpense(int id) {
        return loadExpenses().stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void updateExpense(Expense expense) {
        List<Expense> expenses = loadExpenses();
        List<Expense> updatedExpenses = expenses.stream().map(e -> (e.getId() == expense.getId()) ? expense : e).collect(Collectors.toList());
        saveExpenses(updatedExpenses);
    }

    @Override
    public void deleteExpense(int id) {
        List<Expense> expenses = loadExpenses();
        expenses.removeIf(e -> e.getId() == id);
        saveExpenses(expenses);
    }

    @Override
    public List<Expense> loadExpenses() {
        List<Expense> expenses = new ArrayList<>();

        try {
            FileReader reader = new FileReader(fileName);
            String text = reader.readAllAsString();
            String[] lines = text.split("],");
            for (String line : lines) {
                line = line.replace("]]", "");
                String[] element = line.split(",|=");
                int id = Integer.parseInt(element[1]);
                Date date = new Date(element[3]);
                Double value = Double.parseDouble(element[5]);
                String merchant = element[7];

                expenses.add(new Expense(id, date, value, merchant));
            }
        } catch (IOException e) {
            IO.println("Error reading text file!");
        }
        return expenses;
    }

    public void saveExpenses(List<Expense> expenses) {
        try {
            FileWriter ExpensesDocument = new FileWriter(fileName, false);
            PrintWriter writer = new PrintWriter(ExpensesDocument, true);
            writer.println(expenses);
            IO.println("File written successfully");
        } catch (IOException e) {
            System.out.println("Error writing file");
        }
    }
}

package org.example.Repository;

import org.example.Expense;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class CSVRepository implements IRepository {
    private String fileName = "ExpensesList.csv";

    public CSVRepository() {
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
        String line = "";
        List<Expense> expenses = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            line = reader.readLine();
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                Date date = new Date(parts[1]);
                double value = Double.parseDouble(parts[2]);
                String merchant = parts[3];
                expenses.add(new Expense(id, date, value, merchant));
            }
        } catch (IOException e){
            System.out.println("Error reading from CSV file.");

        }
        return expenses;
    }



public void saveExpenses(List<Expense> expenses) {

    try {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write("id, date, value, merchant");
        writer.newLine();

        for (Expense e : expenses) {
            writer.write(e.toCSV());
            writer.newLine();
        }
        writer.close();
        System.out.println("File written successfully");
    } catch (IOException e) {
        System.out.println("Error writing file");
    }
}
}

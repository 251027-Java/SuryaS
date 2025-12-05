package org.example.Repository;

import org.example.Expense;
import org.example.Repository.IRepository;
import java.sql.*;

import java.util.List;
import java.util.ArrayList;

public class PostgreSQLRepository implements IRepository {
    // Fields
    private static final String Postgre_URL  = "jdbc:postgresql://localhost:5432/expensesdb";
    private static final String Postgre_Username = "postgres";
    private static final String Postgre_Password = "xaR501%=";
    private Connection connection;

    // Constructor
    public PostgreSQLRepository() {
        try {
            connection = DriverManager.getConnection(Postgre_URL, Postgre_Username, Postgre_Password);
            try (Statement stmt = connection.createStatement()) {
                String sql = "CREATE SCHEMA IF NOT EXISTS ExpenseReport;" +
                        "CREATE TABLE IF NOT EXISTS ExpenseReport.Expenses (" +
                        "id INT PRIMARY KEY," +
                        "date TIMESTAMP NOT NULL," +
                        "price FLOAT CHECK (price > 0)," +
                        "merchant VARCHAR(50) NOT NULL" +
                        ");";

                stmt.execute(sql);
                System.out.println("Successful creation of Postgre database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void createExpense(Expense expense) {
        String sql = "INSERT INTO ExpenseReport.Expenses (id , date, price, merchant) VALUES ( ?, ?, ?, ?);";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, expense.getId());
            stmt.setDate(2, new java.sql.Date(expense.getDate().getTime()));
            stmt.setDouble(3, expense.getValue());
            stmt.setString(4, expense.getMerchant());
            stmt.executeUpdate();
            System.out.println("Expense created successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Expense readExpense(int id) {
        return null;
    }

    @Override
    public void updateExpense(Expense expense)   {
        String sql = "UPDATE ExpenseReport.Expenses SET date=?, price=?, merchant=? WHERE id = ?;";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(expense.getDate().getTime()));
            stmt.setDouble(2, expense.getValue());
            stmt.setString(3, expense.getMerchant());
            stmt.setInt(4, expense.getId());
            stmt.executeUpdate();
            System.out.println("Expense updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteExpense(int id) {

    }

    @Override
    public List<Expense> loadExpenses() {
        return List.of();
    }

    @Override
    public void saveExpenses(List<Expense> expenses) {

    }

    // Methods

}





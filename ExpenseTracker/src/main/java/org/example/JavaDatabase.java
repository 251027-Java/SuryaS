package org.example;

import org.example.Repository.IRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class JavaDatabase implements IRepository {

    private Connection connection;
    private static final String H2_URL = "jdbc:h2:mem:expenses;DB_CLOSE_DELAY=-1";

    public JavaDatabase() {
        try {
            connection = DriverManager.getConnection(H2_URL);
            try (Statement stmt = connection.createStatement()) {
                String sql = "CREATE SCHEMA IF NOT EXISTS ExpenseReport;" +
                        "CREATE TABLE IF NOT EXISTS ExpenseReport.Expenses (" +
                        "id INT PRIMARY KEY," +
                        "date TIMESTAMP NOT NULL," +
                        "value FLOAT CHECK (value > 0)," +
                        "merchant VARCHAR(50) NOT NULL" +
                        ");";
                stmt.execute(sql);
                System.out.println("Successful creation of H2 database");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }


    }

    @Override
    public void createExpense(Expense expense) {

    }

    @Override
    public Expense readExpense(int id) {
        return null;
    }

    @Override
    public void updateExpense(Expense expense) {

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
}

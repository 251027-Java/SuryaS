package org.example.Repository;

import org.example.Expense;

import org.example.Repository.IRepository;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.List;

public class H2Repository implements IRepository {
    private static final String H2_URL = "jdbc:h2:mem:expenses;" +
            "DB_CLOSE_DELAY=-1";
    //final can be redefined in constructor
    private Connection connection;
    public H2Repository() throws SQLException {
        connection = DriverManager.getConnection(H2_URL);
        try(Statement statement = connection.createStatement()){
            String sql = "CREATE SCHEMA IF NOT EXISTS ExpenseReport;" +
                    "CREATE TABLE ExpenseReport.Expenses (" +
                    "id INTEGER PRIMARY KEY," +
                    "date TIMESTAMP NOT NULL," +
                    "value FLOAT CHECK (value > 0)," +
                    "merchant VARCHAR(50) NOT NULL" +
                    ");";
            statement.execute(sql);
            System.out.println("Successful creation of H2 database!");
        } catch (SQLException e) {
            e.printStackTrace();
            //detail where error occurred.
        }
        //statement automatically closed here
    }

    @Override
    public void createExpense(Expense expense) {
        String sql = String.format("INSERT INTO ExpenseReport.Expenses(id, date, price, merchant)"+
                "Values (%d , ? , ?, Walmart););", expense.getId());
        try(PreparedStatement stmt = connection.prepareStatement(sql)){
            stmt.setInt(1, expense.getId());
            stmt.setDate(2, expense.getDate());
            stmt.setDouble(3, expense.getValue());
            stmt.setString(4, expense.getMerchant());
        }
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

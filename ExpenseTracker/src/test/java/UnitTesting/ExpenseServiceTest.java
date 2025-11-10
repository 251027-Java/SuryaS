package UnitTesting;

import org.example.Expense;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import org.example.Repository.TextRepository;
import org.junit.Assert;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ExpenseServiceTest {
    public void main(String[] args) throws IOException {
        Expense expense = new Expense(1, new Date(), 3.2, "Walmart");
        testId(expense);
        testReadExpense(expense.getId());
        
    }


    void testId(Expense expense) {

        expense.setId(1);
        int possibleID = expense.getId();
        Assert.assertEquals(1, possibleID);
    }


    void testMerchant(Expense expense) {
        expense.setMerchant("Target");
        String possibleMerchant = expense.getMerchant();
        Assert.assertEquals("Target", possibleMerchant);
    }

    boolean testReadExpense(int id) {
        TextRepository repo = new TextRepository();
        Expense expense = repo.readExpense(id);
        return expense != null;
    }
}


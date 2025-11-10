package org.example;


import org.example.Repository.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Main {
    static void main(String[] args) {


        System.out.println("Expense Tracker Starting!");

        //List<Expense> expenses = new ArrayList<>();


        //System.out.println("Creating a test expense");
        //List<Expense> expenses = new ArrayList<>();
        //expenses.add(new Expense(1, new Date(), 2.0, "Bob"));

        //expenses.add(new Expense(2, new Date(), 3.0, "Bobby"));

        //expenses.add(new Expense(3, new Date(), 1.0, "Surya"));

        // this is where we switch our repository from one to another
        //IRepository repo = new TextRepository();
        //IRepository repo = new CSVRepository();
        //System.out.println(expenses);
        //repo.saveExpenses(expenses);
        IRepository repo = new JavaDatabase();
        //IRepository repo = new JSONRepository();
        Service service = new Service(repo);
        //service.sumExpenses();
        //service.printExpenses();
        //System.out.println("Loading saved expenses... ");
        // expenses = repo.loadExpenses();
        //System.out.println("Loading expenses");
        //System.out.println(repo.loadExpenses());

        System.out.println("Expense Tracker Closing");


    }
}

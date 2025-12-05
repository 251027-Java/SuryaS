package org.example;

import java.sql.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        // read integer to get size of ISBNs
        // go to Next Line
        // with size, list of ISBNs
        // next line --> Target ISBN

        int location = 0;
        Scanner myScanner = new Scanner(System.in);
        int numInput = myScanner.nextInt();
        myScanner.nextLine();

        int[] ISBNList = new int[numInput];
        for (int i = 0; i < ISBNList.length; i++) {
            ISBNList[i] = Integer.parseInt(myScanner.next());
        }

        int targetISBN = myScanner.nextInt();

        if(targetISBN > ISBNList[numInput-1]){
            System.out.println(numInput);
            return;
        }
        for (int i = 0; i < ISBNList.length; i++) {
            if (ISBNList[i] <= targetISBN) {
                location = i;
                break;
            }
        }
    }
}
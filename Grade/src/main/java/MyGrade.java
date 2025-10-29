import java.util.Scanner;

public class MyGrade {

    public static void main(String[] args) {
        System.out.println("Enter a grade.");
        Scanner userInput = new Scanner(System.in);
        double input;
        boolean validInput = true;
        while (validInput) {
            try {
                input = userInput.nextDouble();
                if (input > 100 || input < 0) validInput = false;
                char letterGrade = 'O';
                if (input >= 90) letterGrade = 'A';
                else if (input >= 80) letterGrade = 'B';
                else if (input >= 70) letterGrade = 'C';
                else if (input >= 60) letterGrade = 'D';
                else letterGrade = 'F';
                System.out.println("Your grade is " + letterGrade + ".");
                validInput = true;
            } catch (Exception e) {
                System.out.println("You were supposed to enter a number between 0 and 100. Enter a grade.");
                userInput.next();
            }
        }

    }
}

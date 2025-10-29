import java.util.Scanner;

public class MyGrade {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        double input;
        try {
            input = userInput.nextDouble();
            if (input > 100 || input < 0) System.out.println("Your grade is out of bounds.");
            else {
                char grade = '0';
                if (input >= 90) grade = 'A';
                else if (input >= 80) grade = 'B';
                else if (input >= 70) grade = 'C';
                else if (input >= 60) grade = 'D';
                else grade = 'F';
                System.out.println("Your grade is " + grade + ".");
            }
        } catch (Exception e) {
            System.out.println("You were supposed to enter a grade.");
        }
    }

}

    import java.util.Scanner;
    import java.util.Arrays;

    public class Hangman {
        public static void main(String [] args) {
            Scanner scanner = new Scanner(System.in);

            String word = "protected";
            String[] letters = word.split("");
            String[] dashes = new String[letters.length];
            String guessedLetter = "";
            boolean correctGuess = false;
            StringBuilder totalLettersGuessed = new StringBuilder();

            Arrays.fill(dashes, "_");
            boolean hangmanCompleted = false;
            int count = 0;
            boolean correctLetter = false;
            System.out.println("This is how many letters the word has: " + Arrays.toString(dashes));
            int guessNum = 7;
            System.out.println("You have a total of " + guessNum + " guesses left.");
            do {
                System.out.print("Enter your guess for the next letter: ");
                guessedLetter = scanner.next();
                while (!Character.isLetter(guessedLetter.charAt(0))) {
                    System.out.println("Enter a letter.");
                    guessedLetter = scanner.next();
                }

                if (!totalLettersGuessed.toString().contains(guessedLetter)) {
                    totalLettersGuessed.append(guessedLetter);

                } else {
                    System.out.println("You already guessed that letter. Guess again.");
                    guessedLetter = scanner.next();

                }

                for (int i = 0; i < letters.length; i++) {
                    if (letters[i].equals(guessedLetter)) {
                        dashes[i] = letters[i];
                        correctLetter = true;
                    }
                }
                if (correctLetter) {

                    System.out.println("That was a correct letter!");
                    System.out.println("You have a total of " + guessNum + " guesses left.");
                    System.out.println("This is your current status: " + Arrays.toString(dashes));
                    System.out.println("");
                }
                else {
                    System.out.println("That was incorrect!");
                    guessNum -= 1;
                    System.out.println("You have a total of " + guessNum + " guesses left.");
                    System.out.println("This is your current status: " + Arrays.toString(dashes));
                    System.out.println("");
                    count += 1;
                }
                correctLetter = false;

                if(guessNum<=3){
                    System.out.println("Do you know what the word is? (Y / N)");
                    String input = scanner.next();
                    if(input.equals("Y")){
                        System.out.println("Enter the word.");
                        input = scanner.next();
                        if(input.equals(word)){
                            System.out.println("You guessed the word correctly");
                            correctGuess=true;
                            guessNum=0;
                        }
                    }
                }

                if (Arrays.equals(letters, dashes)) {
                    System.out.println("You won!");
                    System.out.println("The correct word was: " + Arrays.toString(letters));
                    System.out.println("This was your guess: " + Arrays.toString(dashes));
                    break;
                }
            } while (guessNum > 0 || !correctGuess);
            if (guessNum == 0 && !correctGuess) {
                System.out.println("You lost!");
                System.out.println("The correct word was: " + Arrays.toString(letters));
                System.out.println("This was your guess: " + Arrays.toString(dashes));
            }

        }
    }
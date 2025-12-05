import java.util.Arrays;

public class GameBoard {

    public static void printGameBoard() {
        char[][] gameBoard = new char[4][4];
        for(int i = 0; i < 4; i++) {
            Arrays.fill(gameBoard[i], '_');
        }

        System.out.println(Arrays.deepToString(gameBoard));

    }


}

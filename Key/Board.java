package Key;
import java.util.Scanner;

public class Board {

    private static int dimension = 8;
    private static int mineNumber = 10;
    private static int[][] board = new int[dimension][dimension];
    private static int[][] clickerBoard = new int[dimension][dimension];
    private static Boolean continuePlaying = true;

    // Displays the minesweeper board
    public static String drawBoard() {
        String display = "";
        
        display += " ";
        for (int i = 0; i < dimension; i++) {
            display += "|" + (i+1);
        }
        display += "|\n";
        for (int i = 0; i <= dimension; i++) {
            display += "--";
        }
        display += "\n";

        for (int i = 0; i < dimension; i++) {
            display += i+1;
            for (int j = 0; j < dimension; j++) {
                display += "|";
                if (clickerBoard[i][j] == 2) {
                    display += "\u001B[31m" + "F" + "\u001B[0m";
                }
                else if (clickerBoard[i][j] == 1) {

                    if (board[i][j] == 9) {
                        display += "M";
                        System.out.println("\nYOU LOST");
                        continuePlaying = false;
                    }
                    else {
                        display += board[i][j];
                    }
                }
                else {
                    display += " ";
                }

                
            }
            display += "|\n";
        }
        for (int i = 0; i <= dimension; i++) {
            display += "--";
        }
        System.out.println(display);
        return display;
    }

    // Randomly populates mines across the board
    public static void randomMines() {
        System.out.println(board);
        for (int i = 0; i < mineNumber; i++) {
            while (true) {
                int xPosition = (int) (Math.random() * dimension);
                int yPosition = (int) (Math.random() * dimension);

                if (board[xPosition][yPosition] != 9) {
                    board[xPosition][yPosition] = 9;
                    break;
                }
            }
        }
    }

    // Calculates number of nearby mines for all squares
    public static void boardValues() {
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                for (int x = -1; x <= 1; x++)
                    for (int y = -1; y <= 1; y++) {
                        try {
                            if (board[i+x][j+y] == 9 && board[i][j]!=9) {
                                board[i][j]++;
                            }
                        }
                        catch (Exception e) {}
                    }
            }
        }
    }

    // Asks for input from the player
    public static void getInput() {
        boolean inputValidation = true;
        while (inputValidation) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Where would you like to place your mine? Please input the value as x, y. If you would like to place a flag type 'flag'.");
                String input = sc.nextLine();

                int newVal = 1;

                if (input.equals("flag")) {
                    System.out.println("Where would you like to place or remove your flag? Please input the value as x, y.");
                    input = sc.nextLine();
                    newVal = 2;
                }

                String[] inputVals = input.split(",");

                int x = Integer.parseInt(inputVals[0].replaceAll("\\D", ""));
                int y = Integer.parseInt(inputVals[1].replaceAll("\\D", ""));

                clickerBoard[y-1][x-1] = newVal;
                inputValidation = false;
            }
            catch (Exception e) {
                System.out.println("Please respond in the format shown above.");
            }
        }
        
    }

    // Runs game and checks win conditions
    public static void play() {
        while (continuePlaying) {
            Board.getInput();
            Board.drawBoard();

            boolean won = true;

            for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                    if (clickerBoard[i][j] == 0 || (clickerBoard[i][j] == 2 && board[i][j]!=9)) {
                        won = false;
                    }
                }

            }
            if (won) {
                continuePlaying = false;
                System.out.println("You won!");
            }
        }
    }
}
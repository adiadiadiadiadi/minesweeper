package Activity;
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
        // Change the bounds of the for loop such that it loops through the length of the board array
        for () {
            display += "|" + (i+1);
        }
        display += "|\n";
         // Change the bounds of the for loop such that it loops through the length of the board array
        for () {
            display += "--";
        }
        display += "\n";
        // Change the bounds of the for loop such that it loops through all the items in the board array
        for () {
            display += i+1;
            for () {
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
        // Change the bounds of the for loop such that it loops through the length of the board array
        for () {
            display += "--";
        }
        System.out.println(display);
        return display;
    }

    // Randomly populates mines across the board
    public static void randomMines() {
        System.out.println(board);
        // Write a for loop to create as many mines as the mineNumber variable
        for () {
        // Create a conditional for the while loop such that it runs until break to ensure that a full amount of mines is displayed
            while () {
                int xPosition = (int) (Math.random() * dimension);
                int yPosition = (int) (Math.random() * dimension);

                if (board[xPosition][yPosition] != 9) {
                    board[xPosition][yPosition] = 9;
                }
            }
        }
    }

    // Calculates number of nearby mines for all squares
    public static void boardValues() {
        // Change the bounds of the for loop such that it loops through all the items in the board array
        for () {
            for () {
                //Create conditions within the for loops to count the mines surrounding a square 
                for ()
                    for () {
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
            // Create a printed win message if won is true
            /*
             *  Your Code
             * 
             */
        }
    }
}
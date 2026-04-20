import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private char currentPlayerSymbol;
    private Scanner scanner;

    public TicTacToe() {
        board = new char[3][3];
        scanner = new Scanner(System.in);
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void performToss() {
        Random rand = new Random();
        int result = rand.nextInt(2); // 0 or 1
        
        if (result == 0) {
            currentPlayerSymbol = 'X';
            System.out.println("Toss Won: Player 1 starts with symbol X");
        } else {
            currentPlayerSymbol = 'O';
            System.out.println("Toss Won: Player 2 starts with symbol O");
        }
    }

    public int getPlayerInput() {
        System.out.print("Enter slot number (1-9): ");
        return scanner.nextInt();
    }

    public void displayBoard() {
        System.out.println("Current Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.performToss();
        game.displayBoard();
        
        int slot = game.getPlayerInput();
        System.out.println("You selected slot: " + slot);
    }
}

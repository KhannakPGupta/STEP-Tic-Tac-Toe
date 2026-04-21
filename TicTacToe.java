import java.util.Random;

public class TicTacToe {
    private char[][] board;
    private char currentPlayerSymbol;

    public TicTacToe() {
        board = new char[3][3];
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

    public void displayBoard() {
        System.out.println("Current Board:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean isValidMove(int row, int col) {
        if (row < 0 || row > 2 || col < 0 || col > 2) {
            return false;
        }
        if (board[row][col] != '-') {
            return false;
        }
        return true;
    }

    public boolean placeMove(int row, int col, char symbol) {
        if (isValidMove(row, col)) {
            board[row][col] = symbol;
            return true;
        }
        System.out.println("Invalid move. Try again.");
        return false;
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.performToss();
        game.displayBoard();
        
        // Testing UC5
        System.out.println("Testing UC5: Validate Move");
        System.out.println("Move (1, 1) valid? " + game.isValidMove(1, 1)); // Expected true
        System.out.println("Move (3, 3) valid? " + game.isValidMove(3, 3)); // Expected false (out of bounds)
        
        // Testing UC6
        System.out.println("\nTesting UC6: Place Move");
        boolean isPlaced = game.placeMove(1, 1, 'X');
        System.out.println("Moved placed at (1,1) with 'X': " + isPlaced);
        game.displayBoard();
    }
}

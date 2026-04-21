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

    public int[] convertSlotToIndices(int slot) {
        if (slot < 1 || slot > 9) {
            // Internally handled for computer move, but usually throw exception for invalid slot
            throw new IllegalArgumentException("Invalid slot. Slot must be between 1 and 9.");
        }
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    public void makeComputerMove(char symbol) {
        Random rand = new Random();
        boolean validMove = false;
        while (!validMove) {
            int slot = rand.nextInt(9) + 1; // 1 to 9
            int[] indices = convertSlotToIndices(slot);
            if (isValidMove(indices[0], indices[1])) {
                placeMove(indices[0], indices[1], symbol);
                System.out.println("Computer placed '" + symbol + "' at slot " + slot);
                validMove = true;
            }
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.performToss();
        game.displayBoard();
        // Testing UC4
        System.out.println("Testing UC4: Convert Slot 5");
        int[] indices = game.convertSlotToIndices(5);
        System.out.println("Slot 5 -> Row: " + indices[0] + ", Col: " + indices[1]);
        
        // Testing UC5
        System.out.println("\nTesting UC5: Validate Move");
        System.out.println("Move (1, 1) valid? " + game.isValidMove(1, 1)); // Expected true
        System.out.println("Move (3, 3) valid? " + game.isValidMove(3, 3)); // Expected false (out of bounds)
        
        // Testing UC6
        System.out.println("\nTesting UC6: Place Move");
        boolean isPlaced = game.placeMove(1, 1, 'X');
        System.out.println("Moved placed at (1,1) with 'X': " + isPlaced);
        game.displayBoard();
        
        // Testing UC7
        System.out.println("\nTesting UC7: Computer Move");
        game.makeComputerMove('O');
        game.displayBoard();
    }
}

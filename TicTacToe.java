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

    public int[] convertSlotToIndices(int slot) {
        if (slot < 1 || slot > 9) {
            throw new IllegalArgumentException("Invalid slot. Slot must be between 1 and 9.");
        }
        int row = (slot - 1) / 3;
        int col = (slot - 1) % 3;
        return new int[]{row, col};
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.performToss();
        game.displayBoard();

        // Testing UC4
        System.out.println("Testing UC4: Convert Slot 5");
        int[] indices = game.convertSlotToIndices(5);
        System.out.println("Slot 5 -> Row: " + indices[0] + ", Col: " + indices[1]);
    }
}

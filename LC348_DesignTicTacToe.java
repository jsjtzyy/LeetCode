import java.util.*;

public class LC348_DesignTicTacToe{
    int[] rows;
    int[] cols;
    int diag, antiDiag;
    int dim;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];    // record status of each row
        cols = new int[n];    // record status of each column
        diag = 0;             // record status of diagonal
        antiDiag = 0;         // record status of anti-diagonal
        dim = n;              // record the dimension of board
    }
    
    /** Player {player} makes a move at ({row}, {col}).
        @param row The row of the board.
        @param col The column of the board.
        @param player The player, can be either 1 or 2.
        @return The current winning condition, can be either:
                0: No one wins.
                1: Player 1 wins.
                2: Player 2 wins. */
    public int move(int row, int col, int player) {
        rows[row] += (player == 1)? 1:-1;
        if(rows[row] == dim) return 1;      // if one row's sum equals to dimesion, means it is fully filled by 1st player
        if(rows[row] == -dim) return 2;
        
        cols[col] += (player == 1)? 1:-1;
        if(cols[col] == dim) return 1;
        if(cols[col] == -dim) return 2;
        
        if(row == col){  // consider diagonal case
            diag += (player == 1)? 1:-1;
            if(diag == dim) return 1;
            if(diag == -dim) return 2;
        }
        
        if(row + col == dim - 1){ // consider anti-diagonal case
            antiDiag += (player == 1)? 1:-1;
            if(antiDiag == dim) return 1;
            if(antiDiag == -dim) return 2;
        }
        return 0;
    }
 /**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
}
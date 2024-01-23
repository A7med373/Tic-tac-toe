import java.util.InputMismatchException;
import java.util.Scanner;

public class tictactoe {
    private char[][] board;
    private char Player;

    public tictactoe() {
        Player = 'X';
        board = new char[3][3];
        board();
    }

    public void board(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }
    public void printBoard(){
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + board[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("-------------");
        }
    }
    public boolean playersMove(int row, int column){
        if (row >= 0 && row < 3 && column >= 0 && column < 3 && board[row][column] == '-'){
            board[row][column] = Player;
            return true;
        }
        return false;
    }
    public void switchPlayers(){
        if (Player == 'X'){
            Player = 'O';
        }
        else {
            Player = 'X';
        }
    }
    public boolean checkWin(){
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == Player && board[i][1] == Player && board[i][2] == Player){
                return true;
            }
            if (board[0][i] == Player && board[1][i] == Player && board[2][i] == Player){
                return true;
            }
        }
        return ((board[0][0] == Player && board[1][1] == Player && board[2][2] == Player) || (board[0][2] == Player && board[1][1] == Player
         && board[2][0] == Player));
    }
    public boolean fullBoard(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-'){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        tictactoe tic = new tictactoe();
        tic.printBoard();
        boolean GameOver = false;

        while (!GameOver){
            boolean valid = false;

            int row = 0;
            int column = 0;
            while (!valid) {
                try {
                    System.out.print("Row 0-2: ");
                    row = scanner.nextInt();
                    System.out.print("Column 0-2: ");
                    column = scanner.nextInt();
                    valid = true;
                } catch (InputMismatchException e) {
                    System.out.println("I SAID 0-2!");
                    scanner.nextLine();
                }
            }
            if (tic.playersMove(row, column)) {
                tic.printBoard();

                if (tic.checkWin()) {
                    System.out.println("THE PLAYER " + tic.Player + " WON");
                    System.out.println("ᕙ(▀̿̿ĺ̯̿̿▀̿ ̿) ᕗ");
                    GameOver = true;
                } else if (tic.fullBoard()) {
                    System.out.println("Draw. You guys are boring...");
                    GameOver = true;
                } else {
                    tic.switchPlayers();
                }
            }
            else {
                System.out.println("Incorrect move. Try Again\n");
            }



        }
    }

}
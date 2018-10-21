package models;

import myExceptions.VariableEnterException;

public class Chessboard {
    private int width;
    private int height;
    private String[] board;
    private String s1 = "*";
    private String s2 = " ";

    public Chessboard() {}

    public String[] getBoard() {
        return board;
    }

    public void setDimensions(int height, int width) throws VariableEnterException {
       if(width<=1 || height<=1){
           throw new VariableEnterException("Dimension must be > 1");
       }
           this.width = width;
           this.height = height;
    }


    public String[] getChessboard() {
        board = new String[height];
        for (int i = 1; i < width; i++) {
            for (int j = 0; j < (height - height % 2); j += 2) { // (height - height % 2) to fill in even number of rows
                //to fill in the first column
                if (board[j] == null) {
                    board[j] = s1;
                    board[j + 1] = s2;
                }
                //to fill in next columns
                if (board[j].endsWith("*")) {
                    board[j] = board[j].concat(s2);
                    board[j + 1] = board[j + 1].concat(s1);
                } else {
                    board[j] = board[j].concat(s1);
                    board[j + 1] = board[j + 1].concat(s2);
                }
            }
        }
        if (board[height - 1] == null) { //to fill in the last odd row
            board[height - 1] = board[0];
        }
        return board;
    }

    public void printChessboard() {
        this.getChessboard();
        for (int i = 0; i < height; i++) {
            System.out.println(board[i]);
        }
    }




}

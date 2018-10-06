package models;

import service.Scanned;

public class Stars {
    private int width;
    private int height;
    private String[] str;
    private String s1 = "*"; // Better in POOL or String object in the method???????
    private String s2 = " ";

    public Stars() {
        System.out.print("Enter the chessboard width: ");
        this.width=Scanned.scanToInteger();;

        System.out.print("Enter the chessboard height: ");
        this.height=Scanned.scanToInteger();

        str = new String[height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String[] getChessboard(int width, int height) {

        for (int i = 1; i < width; i++) {
            for (int j = 0; j < (height - height % 2); j += 2) { // (height - height % 2) to fill in even number of rows
                if (str[j] == null) {
                    str[j] = s1;
                    str[j + 1] = s2;
                }
                if (str[j].endsWith("*")) {
                    str[j] = str[j].concat(s2);
                    str[j + 1] = str[j + 1].concat(s1);
                } else {
                    str[j] = str[j].concat(s1);
                    str[j + 1] = str[j + 1].concat(s2);
                }
            }
        }
        if (str[height - 1] == null) { //to fill in the last odd row
            str[height - 1] = str[0];
        }
        return str;
    }

    public void printChessboard(int width, int height) {
        this.getChessboard(width, height);
        for (int i = 0; i < height; i++) {
            System.out.println(str[i]);
        }
    }




    public void printArrow(int height)  {
        for (int i = 1; i <= height; i++) {
            if (i <=  (height / 2 + 1)) {
                for (int j = 1; j <=  (height / 2 + 1) && j <= i; j++) {
                    System.out.print(s1);
                }
            }
            if (i > (int) (height / 2 + 1)) {
                for (int j =  (height / 2 + 1); j > i -  (height / 2 + 1); j--) {
                    System.out.print(s1);
                }
            }
            System.out.println();
        }

    }
}

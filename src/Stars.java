import java.util.Scanner;

public class Stars {
    private int width;
    private int height;
    private String[] str;

    public Stars() {
        System.out.print("Enter the chessboard width: ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        this.width=Integer.parseInt(str);

        System.out.print("Enter the chessboard height: ");
        str = sc.nextLine();
        this.height=Integer.parseInt(str);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String[] getChessboard(int width, int height) {
        str = new String[height];
        String s1 = new String("*");
        String s2 = new String(" ");
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < (height - height % 2); j += 2) {
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
        if (str[height - 1] == null) str[height - 1] = str[0];
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
                    System.out.print("*");
                }
            }
            if (i > (int) (height / 2 + 1)) {
                for (int j =  (height / 2 + 1); j > i -  (height / 2 + 1); j--) {
                    System.out.print("*");
                }
            }
            System.out.println();
        }

    }
}

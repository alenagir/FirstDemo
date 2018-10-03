import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number from 0 to 999 999: ");
        String enteredNumber = in.nextLine();

        NumberReader number = new NumberReader(enteredNumber);

        System.out.println(number.getNumberInWords());


    }
}

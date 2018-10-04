import java.io.BufferedReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // TASK 5: NUMBERS to WORDS

        System.out.print("Enter a number from 0 to 999 999 999: ");
        Scanner in = new Scanner(System.in);
        String enteredNumber = in.nextLine();


        try{
            try{
                NumberReader number = new NumberReader(enteredNumber);

                System.out.println(number.getNumberInWords());

            }catch (NullPointerException ex) {
                ex.getMessage();
            }
        }catch (NumberFormatException e) {
            e.getMessage();
        }





    }
}

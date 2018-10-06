import models.envelopes.Envelope;
import models.envelopes.Envelopes;
import models.NumberReader;
import models.Stars;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // TASK 5: NUMBERS to WORDS

        try{
               NumberReader number = new NumberReader();
              System.out.println(number.getNumberInWords());

        }catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }

    // Task1: CHESSBOARD

//        try {
//            Stars stars = new Stars();
//            stars.printChessboard(stars.getWidth(), stars.getHeight());
//            //stars.printArrow(stars.getHeight());
//        }catch (NumberFormatException e){
//            System.out.println(e.getMessage());
//        }

    // Task2: Contain ENVELOPES
        //First realization
//        Envelopes envelopes=new Envelopes();
//        System.out.println(envelopes.userDialog());
//
//        //Second realization
//        System.out.println(Envelope.userDialog());

    }
}

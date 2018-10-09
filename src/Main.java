import models.FileParser;
import models.envelopes.Envelope;

import models.NumberReader;
import models.Stars;
import service.PolygonService;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {

        //TASK 3. Triangles

        PolygonService polygons = new PolygonService(PolygonService.compareBySquare);
        polygons.userCreatePolygon();
        polygons.printPolygons();


        // TASK 4: File parser "C://Users//Alena//Desktop//text.txt"

//        FileParser.userStart();
//        FileParser fileParser=null;
//
//        try
//        {
//            fileParser = new FileParser(FileParser.getFilePATH());
//            fileParser.enterStrings();
//            System.out.println(fileParser.stringCounter(fileParser.getStringToFind()));
//            fileParser.stringOverWrite(fileParser.getStringToFind(),fileParser.getStringToOverWrite());
//            fileParser.close();
//        }
//        catch(IOException ex){
//            System.out.println(ex.getMessage());
//        }


        // TASK 5: NUMBERS to WORDS

//        try{
//               NumberReader number = new NumberReader();
//              System.out.println(number.getNumberInWords());
//
//        }catch (NumberFormatException e) {
//            System.out.println(e.getMessage());
//        }

    // Task1: CHESSBOARD

//        try {
//            Stars stars = new Stars();
//            stars.printChessboard(stars.getWidth(), stars.getHeight());
//
//        }catch (NumberFormatException e){
//            System.out.println(e.getMessage());
//        }

    // Task2: Contain ENVELOPES
        //First realization
//        try {
//        Envelope.userDialog();
//        }catch (NumberFormatException e){
//            System.out.println(e.getMessage());
//        }

//       //Second realization
//       Envelopes.userDialog();

    }
}


import models.*;
import service.EnvelopeCompare;
import service.PolygonService;
import service.Scanned;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        String userAnswer;
        System.out.printf("Enter the number from 1 to 8 to choose the task or any other key to exit:\t");
        userAnswer = Scanned.scanToString();
        switch (userAnswer){

            case "1":
                try {
                    Chessboard chessboard = new Chessboard();
                    do {
                        System.out.println("Enter the chessboard width:\t");
                        int width = Scanned.scanToInteger();
                        System.out.println("Enter the chessboard height:\t");
                        int height = Scanned.scanToInteger();

                        chessboard.setDimensions(width, height);
                        chessboard.printChessboard();

                        System.out.println("\nWould you like to continue? yes(y)/no(any other key)");
                        userAnswer=Scanned.scanToString();
                    }while (userAnswer.equals("yes") || userAnswer.equals("y"));

                }catch (NumberFormatException e){
                    System.out.println(e.getMessage());
                };
                break;
            case "2":
                try {
                    EnvelopeCompare envelopeCompare=new EnvelopeCompare();
                    do{
                        Double sides [] = new Double[4];

                        int countEnv=1;
                        int countSides=0;
                        do {
                            System.out.printf("Enter envelope %d side 1, mm: ", countEnv);
                            sides[countSides]=Scanned.scanToDouble();
                            countSides++;
                            System.out.printf("Enter envelope %d side 2, mm: ", countEnv);
                            sides[countSides]=Scanned.scanToDouble();
                            countSides++;
                            countEnv++;
                        }while (countSides<4);

                    envelopeCompare.setEnvelopesSides(sides);

                    System.out.println("\n"+envelopeCompare.comparingResult());

                        System.out.println("\nWould you like to continue? yes(y)/no(any other key)");
                        userAnswer=Scanned.scanToString();
                    }while (userAnswer.equals("yes") || userAnswer.equals("y"));

                }catch (NumberFormatException e){
                    System.out.println(e.getMessage());
                };
                break;
            case "3":
                PolygonService polygons = new PolygonService(PolygonService.compareBySquare);
                polygons.userCreatePolygon();
                polygons.printPolygons();
                break;
            case "4":
                FileParser.userStart();
                FileParser fileParser=null;
                try
                {
                    fileParser = new FileParser(FileParser.getFilePATH());
                    fileParser.enterStrings();
                    System.out.println(fileParser.stringCounter(fileParser.getStringToFind()));
                    fileParser.stringOverWrite(fileParser.getStringToFind(),fileParser.getStringToOverWrite());
                    fileParser.close();
                }
                catch(IOException ex){
                    System.out.println(ex.getMessage());
                };
                 break;
            case "5":
                try{
                    NumberReader number = new NumberReader();
                    System.out.println(number.getNumberInWords());

                }catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                };
                break;
            case "6":
                LuckyTickets tickets = new LuckyTickets();
                tickets.calcTickets();
                break;
            case "7":
                Sequence sequence=new Sequence();
                System.out.println(sequence.getSequence());
                sequence.print();
                break;
            case "8":
                Fibonacci fibonacci=new Fibonacci();
                fibonacci.userDialog2();
                break;
        }



    }


}

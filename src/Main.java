import models.*;
import models.envelopes.Envelope;


public class Main {
    public static void main(String[] args) {

        // Task1: CHESSBOARD

//        try {
//            Stars stars = new Stars();
//            stars.printChessboard(stars.getWidth(), stars.getHeight());
//
//        }catch (NumberFormatException e){
//            System.out.println(e.getMessage());
//        }

        // Task2: Contain ENVELOPES

//        try {
//        Envelope.userDialog();
//        }catch (NumberFormatException e){
//            System.out.println(e.getMessage());
//        }


        //TASK 3. Triangles

//        PolygonService polygons = new PolygonService(PolygonService.compareBySquare);
//        polygons.userCreatePolygon();
//        polygons.printPolygons();


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


        // TASK 5: NUMERALS to WORDS

//        try{
//               NumberReader number = new NumberReader();
//              System.out.println(number.getNumberInWords());
//
//        }catch (NumberFormatException e) {
//            System.out.println(e.getMessage());
//        }
        // TASK 6: LUCKY TICKETS

//        LuckyTickets tickets = new LuckyTickets();
//        tickets.calcTickets();

        // TASK 7: NUMERALS Sequence

//        Sequence sequence=new Sequence();
//        System.out.println(sequence.getSequence());
//        sequence.print();

        // TASK 8: FIBONACCI
        //First realization
         Fibonacci.userDialog();

        //Second realization
//        Fibonacci fibonacci=new Fibonacci();
//        fibonacci.userDialog2();


    }
}

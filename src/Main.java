
import models.*;
import myExceptions.*;
import service.*;
import java.io.IOException;
import static service.TriangleSet.compareBySquare;


public class Main {
    public static void main(String[] args) {
        String userAnswer;
        System.out.printf("Enter the number from 1 to 8 to choose the task or any other key to exit:\t");
        userAnswer = Scanned.scanToString();
        switch (userAnswer){

            case "1":
               Chessboard chessboard = new Chessboard();
                do {
                    try {
                        System.out.println("Enter the chessboard width:\t");
                        int width = Scanned.scanToInteger();
                        System.out.println("Enter the chessboard height:\t");
                        int height = Scanned.scanToInteger();

                        chessboard.setDimensions(width, height);
                        chessboard.printChessboard();

                    }catch (NumberFormatException e){
                        System.out.println(e.getMessage());
                    }catch (VariableEnterException ex){
                        System.out.println(ex.getMessage());
                    }

                        System.out.println("\nWould you like to continue? yes(y)/no(any other key)");
                        userAnswer=Scanned.scanToString();
                    }while (userAnswer.equals("yes") || userAnswer.equals("y"));
                break;
            case "2":
                Envelope envelope1 =new Envelope();
                Envelope envelope2 =new Envelope();
                EnvelopeCompare envelopeCompare=new EnvelopeCompare();
                do{
                    Double sides [] = new Double[4];
                    try {
                        int countEnv=1;
                        int countSides=0;
                        do {
                            System.out.printf("Enter envelope %d side 1, mm: ", countEnv);
                            sides[countSides]=Scanned.scanToDouble();

                            System.out.printf("Enter envelope %d side 2, mm: ", countEnv);
                            sides[countSides+1]=Scanned.scanToDouble();
                            countSides +=2;
                            countEnv++;
                        }while (countSides<4);

                         envelopeCompare.setEnvelopesSides(envelope1, envelope2, sides);

                        System.out.println("\n"+envelopeCompare.comparingResult(envelope1, envelope2, sides));

                   }catch (NumberFormatException e){
                        System.out.println(e.getMessage());
                   }catch (VariableEnterException ex){
                        System.out.println(ex.getMessage());
                    }
                        System.out.println("\nWould you like to continue? yes(y)/no(any other key)");
                        userAnswer=Scanned.scanToString();
                    }while (userAnswer.equals("yes") || userAnswer.equals("y"));
                break;
            case "3":
                Triangle triangle=new Triangle();
                TriangleSet triangleSet = new TriangleSet(compareBySquare);

                System.out.println("\nEnter triangle parameters in the format: <Name><,><side 1><,><side 2><,><side 3>" );
                do{

                String userEnter = Scanned.scanToString();

                try {
                    triangleSet.addTriangle(userEnter);
                }catch (TriangleException te){
                    System.out.println(te.getMessage());
                }catch (NumberFormatException ne){
                    System.out.println(ne.getMessage());
                }
                    System.out.println("\nPress Enter to add or any other key to exit");
                    userAnswer=Scanned.scanToString();
                }while (userAnswer.equals(""));
                triangleSet.printTriangles();
                break;
            case "4":
                //"C://Users//Alena//Desktop//text.txt"
                System.out.println("Enter the file path: ");
                String filePATH=Scanned.scanToString();
                FileParser fileParser=null;
                try
                {
                    fileParser = new FileParser(filePATH);
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
                NumberReader number = new NumberReader();
                System.out.print("Enter a number from 0 to 999 999 999:\n");
                do{
                    Integer enteredNumber = Scanned.scanToInteger();
                    try{
                        number.setEnteredNumber(enteredNumber);
                        System.out.println(number.getNumberInWords());
                    }catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    }catch (VariableEnterException ex){
                        System.out.println(ex.getMessage());
                    }
                    System.out.println("\nPress Enter to add or any other key to exit");
                    userAnswer=Scanned.scanToString();
                }while (userAnswer.equals(""));
                break;
            case "6":
                TicketsPack ticketsPack=new TicketsPack();
                LuckyTickets luckyTickets = new LuckyTickets();
                do {
                    try {
                        System.out.println("Enter MIN ticket number:");
                        ticketsPack.setMinNumber(Scanned.scanToInteger());

                        System.out.println("Enter MAX ticket number:");
                        ticketsPack.setMaxNumber(Scanned.scanToInteger());

                        System.out.printf("Ticket numbers range: " + "%06d - %06d" + "\n",
                                ticketsPack.getMinNumber(), ticketsPack.getMaxNumber());

                        System.out.println(luckyTickets.countTickets(ticketsPack));

                    } catch (NumberFormatException e) {
                        System.out.println(e.getMessage());
                    } catch (VariableEnterException ex) {
                        System.out.println(ex.getMessage());
                    }
                    System.out.println("\nPress Enter to add or any other key to exit");
                    userAnswer=Scanned.scanToString();
                }while (userAnswer.equals(""));
                 break;
            case "7":
                Sequence sequence=new Sequence();
                do{
                    try {
                        System.out.println("Enter a sequence length: ");
                        sequence.setSequencelength(Scanned.scanToInteger());
                        System.out.println("Enter a minimal square: ");
                        sequence.setMinSquare(Scanned.scanToInteger());
                        sequence.getSequence();
                        sequence.print();
                    }catch (NumberFormatException e){
                        System.out.println(e.getMessage());
                    }catch (VariableEnterException ex){
                        System.out.println(ex.getMessage());
                    }
                    System.out.println("\nPress Enter to add or any other key to exit");
                    userAnswer=Scanned.scanToString();
                }while (userAnswer.equals(""));
                break;
            case "8":
                FibonacciMap fibonacci=new FibonacciMap();
                System.out.println("Enter a range in format <number><-><number> or number of digits: ");
                do{
                    try {
                       String userEnter = Scanned.scanToString();
                        fibonacci.printFibonacci(userEnter);

                    }catch (NumberFormatException e){
                        System.out.println(e.getMessage());
                    }catch (VariableEnterException ex){
                        System.out.println(ex.getMessage());
                    }
                    System.out.println("\nPress Enter to add or any other key to exit");
                    userAnswer=Scanned.scanToString();
                }while (userAnswer.equals(""));
                break;
        }



    }


}

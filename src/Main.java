
import models.*;
import myExceptions.*;
import service.*;
import java.io.IOException;
import java.util.Scanner;

import static service.TriangleSet.comparedBySquare;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String userAnswer;
        System.out.printf("Enter the number from 1 to 8 to choose the task or any other key to exit:\t");
        userAnswer = Scanned.scanToString(scanner);
        switch (userAnswer){

            case "1":
               Chessboard chessboard = new Chessboard();
                do {
                    try {
                        System.out.println("Enter the chessboard height:\t");
                        int height = Scanned.scanToInteger(scanner);
                        System.out.println("Enter the chessboard width:\t");
                        int width = Scanned.scanToInteger(scanner);

                        chessboard.setDimensions(height, width);
                        chessboard.printChessboard();

                    }catch (VariableEnterException ex){
                        System.out.print(ex.getString());
                        System.out.println(ex.getMessage());
                    }

                    System.out.println("\nPress Enter to continue or any other key to exit");
                    userAnswer=Scanned.scanToString(scanner);
                }while (userAnswer.equals(""));
                break;
            case "2":
                Envelope envelope1 =new Envelope();
                Envelope envelope2 =new Envelope();
                EnvelopeCompare envelopeCompare=new EnvelopeCompare();
                Double sides [] = new Double[4];
                do{
                    try {
                        int countEnv=1;
                        int countSides=0;
                        do {
                            System.out.printf("Enter envelope %d side 1, mm: ", countEnv);
                            sides[countSides]=Scanned.scanToDouble(scanner);

                            System.out.printf("Enter envelope %d side 2, mm: ", countEnv);
                            sides[countSides+1]=Scanned.scanToDouble(scanner);
                            countSides +=2;
                            countEnv++;
                        }while (countSides<4);

                        System.out.println("\n"+envelopeCompare.comparingResult(envelope1, envelope2, sides));

                    }catch (VariableEnterException ex){
                        System.out.print(ex.getString());
                        System.out.println(ex.getMessage());
                    }

                    System.out.println("\nPress Enter to continue or any other key to exit");
                    userAnswer=Scanned.scanToString(scanner);
                }while (userAnswer.equals(""));
                break;
            case "3":

                TriangleSet triangleSet = new TriangleSet(comparedBySquare);

                System.out.println("\nEnter triangle parameters in the format: <Name><,><side 1><,><side 2><,><side 3>" );
                do{
                String userEnter = Scanned.scanToString(scanner);
                try {

                    triangleSet.addTriangle(userEnter);

                }catch (VariableEnterException ex){
                    System.out.print(ex.getString());
                    System.out.println(ex.getMessage());
                }
                    System.out.println("\nPress Enter to add or any other key to exit");
                    userAnswer=Scanned.scanToString(scanner);
                }while (userAnswer.equals(""));
                triangleSet.printTriangles();
                break;
            case "4":
                // D://JavaTasks//First_Demo//FileSource//text.txt
                System.out.println("Enter the file path: ");
                String filePATH=Scanned.scanToString(scanner);
                FileParser fileParser=null;
                try
                {
                    fileParser = new FileParser(filePATH);

                    System.out.println("Enter the substring to be counted: ");
                    String stringToFind=Scanned.scanToString(scanner);
                    System.out.println("Enter the substring to overwrite: ");
                    String stringToOverWrite=Scanned.scanToString(scanner);
                    fileParser.setParameters(stringToFind, stringToOverWrite);

                    System.out.println(fileParser.stringCounter(stringToFind));
                    fileParser.stringOverWrite(stringToFind,stringToOverWrite);
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
                    try{
                        int enteredNumber = Scanned.scanToInteger(scanner);
                        number.setEnteredNumber(Math.abs(enteredNumber));
                    }catch (VariableEnterException ex){
                        System.out.print(ex.getString());
                        System.out.println(ex.getMessage());
                    }
                    System.out.println(number.getNumberInWords());

                    System.out.println("\nPress Enter to continue or any other key to exit");
                    userAnswer=Scanned.scanToString(scanner);
                }while (userAnswer.equals(""));
                break;
            case "6":
                TicketsPack ticketsPack=new TicketsPack();
                LuckyTickets luckyTickets = new LuckyTickets();
                do {
                    try {
                        System.out.println("Enter MIN ticket number:");
                        ticketsPack.setMinNumber(Scanned.scanToInteger(scanner));

                        System.out.println("Enter MAX ticket number:");
                        ticketsPack.setMaxNumber(Scanned.scanToInteger(scanner));

                        System.out.printf("Ticket numbers range: " + "%06d - %06d" + "\n",
                                ticketsPack.getMinNumber(), ticketsPack.getMaxNumber());

                        System.out.println(luckyTickets.countTickets(ticketsPack));

                    }catch (VariableEnterException ex){
                        System.out.print(ex.getString());
                        System.out.println(ex.getMessage());
                    }
                    System.out.println("\nPress Enter to add or any other key to exit");
                    userAnswer=Scanned.scanToString(scanner);
                }while (userAnswer.equals(""));
                 break;
            case "7":
                Sequence sequence=new Sequence();
                do{
                    try {
                        System.out.println("Enter a sequence length: ");
                        sequence.setSequencelength(Scanned.scanToInteger(scanner));
                        System.out.println("Enter a minimal square: ");
                        sequence.setMinSquare(Scanned.scanToInteger(scanner));
                        sequence.getSequence();
                        sequence.print();
                    }catch (VariableEnterException ex){
                        System.out.print(ex.getString());
                        System.out.println(ex.getMessage());
                    }
                    System.out.println("\nPress Enter to add or any other key to exit");
                    userAnswer=Scanned.scanToString(scanner);
                }while (userAnswer.equals(""));
                break;
            case "8":
                FibonacciMap fibonacci=new FibonacciMap();
                System.out.println("Enter a range in format <number><-><number> or number of digits: ");
                do{
                    try {
                       String userEnter = Scanned.scanToString(scanner);
                        fibonacci.printFibonacci(userEnter);

                    }catch (NumberFormatException e){
                        System.out.println(e.getMessage());
                    }catch (VariableEnterException ex){
                        System.out.println(ex.getMessage());
                    }
                    System.out.println("\nPress Enter to add or any other key to exit");
                    userAnswer=Scanned.scanToString(scanner);
                }while (userAnswer.equals(""));
                break;
        }



    }


}

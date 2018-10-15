package service;


import java.util.Scanner;

public interface Scanned {


    static String scanToString (){
        Scanner in = new Scanner(System.in);
        String string = in.nextLine().trim();
        return string;
    }

    static Integer scanToInteger (){
        Scanner in = new Scanner(System.in);
        String string = in.nextLine().trim();
        try {
            Integer integer = Integer.parseInt(string);
            return integer;
        }catch (NumberFormatException e){
            throw new NumberFormatException("It is not an integer number!");
        }
    }
    static Double scanToDouble () throws NumberFormatException{
        Scanner in = new Scanner(System.in);
        String string = in.nextLine().trim();
        try {
            Double aDouble = Double.parseDouble(string);
            return aDouble;
        }catch (NumberFormatException e){
            throw new NumberFormatException("It is not a double number!");
        }
    }
    static Long scanToLong (){
       Scanner in = new Scanner(System.in);
        String string = in.nextLine().trim();
        try {
            Long ln = Long.parseLong(string);
            return ln;
        }catch (NumberFormatException e){
            throw new NumberFormatException("It is not a long number!");
        }
    }
}

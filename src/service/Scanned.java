package service;


import myExceptions.VariableEnterException;

import java.util.Scanner;

public interface Scanned {

    static String scanToString (Scanner in){
        String string = in.nextLine().trim();
        return string;
    }

    static Integer scanToInteger (Scanner in) throws VariableEnterException{
        String string = in.nextLine();
        try {
            Integer integer = Integer.parseInt(string);
            return integer;
        }catch (NumberFormatException e){
            throw new VariableEnterException (" is not an integer number!",string);
        }

    }
    static Double scanToDouble (Scanner in) throws VariableEnterException{
        String string = in.nextLine();
        try {
            Double aDouble = Double.parseDouble(string);
            return aDouble;
        }catch (NumberFormatException e){
            throw new VariableEnterException (" is not a double number!",string);
        }
    }
    static Long scanToLong (Scanner in) throws VariableEnterException{
        String string = in.nextLine();
        try {
            Long ln = Long.parseLong(string);
            return ln;
        }catch (NumberFormatException e){
            throw new VariableEnterException (" is not a long number!",string);
        }
    }
}

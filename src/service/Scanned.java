package service;


public interface Scanned {


    static String scanToString (){
        java.util.Scanner in = new java.util.Scanner(System.in);
        String string = in.nextLine().trim();
        return string;
    }

    static Integer scanToInteger (){
        java.util.Scanner in = new java.util.Scanner(System.in);
        String string = in.nextLine().trim().replace("-", "");
        try {
            Integer integer = Integer.parseInt(string);
            return integer;
        }catch (NumberFormatException e){
            throw new NumberFormatException("It is not a correct number! Please try again.");
        }
    }
    static Double scanToDouble (){
        java.util.Scanner in = new java.util.Scanner(System.in);
        String string = in.nextLine().trim().replace("-", "");
        try {
            Double aDouble = Double.parseDouble(string);
            return aDouble;
        }catch (NumberFormatException e){
            throw new NumberFormatException("It is not a number! Please try again.");
        }
    }
    static Long scanToLong (){
        java.util.Scanner in = new java.util.Scanner(System.in);
        String string = in.nextLine().trim().replace("-", "");
        try {
            Long ln = Long.parseLong(string);
            return ln;
        }catch (NumberFormatException e){
            throw new NumberFormatException("It is not a number or out of long range! Please try again.");
        }
    }
}

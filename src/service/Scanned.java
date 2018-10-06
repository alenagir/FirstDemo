package service;


public interface Scanned {

    static void scan(){

    }

    static String scanToString (){
        java.util.Scanner in = new java.util.Scanner(System.in);
        String string = in.nextLine();
        return string;
    }

    static Integer scanToInteger (){
        java.util.Scanner in = new java.util.Scanner(System.in);
        String string = in.nextLine().replace("-", "");
        try {
            Integer integer = Integer.parseInt(string);
            return integer;
        }catch (NumberFormatException e){
            throw new NumberFormatException("It is not an integer number! Please enter again.");
        }
    }
    static Double scanToDouble (){
        java.util.Scanner in = new java.util.Scanner(System.in);
        String string = in.nextLine();
        try {
            Double aDouble = Double.parseDouble(string);
            return aDouble;
        }catch (NumberFormatException e){
            throw new NumberFormatException("It is not a number! Please enter again.");
        }
    }
}

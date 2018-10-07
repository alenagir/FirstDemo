package service;


public interface Scanned {


    static String scanToString (){
        java.util.Scanner in = new java.util.Scanner(System.in);
        String string = in.nextLine().trim();
        return string;
    }

    static Integer scanToInteger (){
        java.util.Scanner in = new java.util.Scanner(System.in);
        String string = in.nextLine().replace("-", "");
        try {
            Integer integer = Integer.parseInt(string);
            return integer;
        }catch (NumberFormatException e){
            throw new NumberFormatException("It is not a correct number! Please enter again.");
        }
    }
    static Double scanToDouble (){
        java.util.Scanner in = new java.util.Scanner(System.in);
        String string = in.nextLine().replace("-", "");
        try {
            Double aDouble = Double.parseDouble(string);
            return aDouble;
        }catch (NumberFormatException e){
            throw new NumberFormatException("It is not a number! Please enter again.");
        }
    }
}

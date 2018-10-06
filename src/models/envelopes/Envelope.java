package models.envelopes;

import java.util.Scanner;

public class Envelope {
    double width_1;
    double height_1;
    double width_2;
    double height_2;
    static String message=new String("One of the envelopes cannot contain the other.");
    static String userAnswer;
    static String systemAnswer;


    private Envelope (){
        System.out.print("Enter the first envelope width 1, mm : ");
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        this.width_1=Double.parseDouble(str);

        System.out.print("Enter the first envelope height 1, mm: ");
        str = sc.nextLine();
        this.height_1=Double.parseDouble(str);

        System.out.print("Enter the second envelope width 2, mm: ");
        str = sc.nextLine();
        this.width_2=Double.parseDouble(str);

        System.out.print("Enter the second envelope height 2, mm: ");
        str = sc.nextLine();
        this.height_2=Double.parseDouble(str);
    }

    public boolean compareEnvelope(){
        if (width_1<=0 || width_2<=0 || height_1<=0 || height_2<=0) return false;
        if (((width_1 - width_2)<1 && (height_1 - height_2)<1 ) && ( (width_2 - width_1)<1 && (height_2 - height_1)<1))
            return false;
        return true;
    }
    public String putEnvelope(){
        if (this.compareEnvelope()==false) return message;
        if (width_1>width_2) return message="The first envelope can contain the other.";
        if (width_2>width_1) return message="The second envelope can contain the other.";
        return message;
    }
    public static String userDialog(){
        System.out.println("Would you like to put one envelope into another? Y(yes)/N(no)");
        Scanner scn = new Scanner(System.in);
        userAnswer = scn.nextLine().toLowerCase();

        if (userAnswer.equals("y") || userAnswer.equals("yes") ) {
            Envelope envelope = new Envelope();
            systemAnswer= envelope.putEnvelope();
            return systemAnswer;
        }

        if (userAnswer.equals("n") || userAnswer.equals("no") ) {
            systemAnswer = "The program is terminated by the user";
            return systemAnswer;
        }
        return systemAnswer;
    }

}
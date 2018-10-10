package models.envelopes;

import service.Printable;
import service.Scanned;

import java.util.Comparator;

public class Envelope implements Comparator, Printable {
    private double width;
    private double height;
    private static String userAnswer;
    public static int TOLERANCE = 1;
    public static int envelopeCounter=1;


    public Envelope() {}


    public static void userDialog() {
        do {
            Printable.startQuestion();
            userAnswer = Scanned.scanToString().toLowerCase();

            if (userAnswer.equals("no") || userAnswer.equals("n")) {
                Printable.userTerminated();
                return;
            }
        } while (!userAnswer.equals("yes") && !userAnswer.equals("y"));

        if (userAnswer.equals("yes") || userAnswer.equals("y") ) {
            Envelope envelope1 = new Envelope();
            Envelope envelope2 = new Envelope();

            do {
                ++envelopeCounter;
                envelope1.setEnvelopeParam();
                ++envelopeCounter;
                envelope2.setEnvelopeParam();
                int compare = envelope1.compare(envelope1, envelope2);
                envelope1.print(compare);
                Printable.continueQuestion();
                userAnswer = Scanned.scanToString().toLowerCase();
                if (userAnswer.equals("no") || userAnswer.equals("n")) break;

            } while ((userAnswer.equals("yes") || userAnswer.equals("y")));
        }
        Printable.userTerminated();
    }

    private void setEnvelopeParam() {

        this.print("w", (envelopeCounter%2)+1);
        this.width = Scanned.scanToDouble();

        this.print("h", envelopeCounter%2+1);
        this.height = Scanned.scanToDouble();
    }


    @Override
    public int compare(Object o1, Object o2) {
        if (((Envelope) o1).getWidth() - ((Envelope) o2).getWidth() < -TOLERANCE
                && ((Envelope) o1).getHeight() - ((Envelope) o2).getHeight() < -TOLERANCE) {// First is smaller
            return -1;
        }
        if (((Envelope) o1).getWidth() - ((Envelope) o2).getWidth() > TOLERANCE
                && ((Envelope) o1).getHeight() - ((Envelope) o2).getHeight() > TOLERANCE) {// First is larger
            return 1;
        } else return 0;
    }

    @Override
    public void print(String s, int counter){
        if (s=="w") System.out.println("width "+counter +" = ");
        if (s=="h") System.out.println("height "+counter +" = ");

    }

    @Override
    public void print(int i){
        if (i==1) System.out.println("The first is larger.");
        if (i==-1) System.out.println("The second is larger.");
        if (i==0) System.out.println("Might be equal within the tolerance in at least one of the parameters.");
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public int getEnvelopeCounter() {
        return envelopeCounter;
    }

    public static int getTOLERANCE() {
        return TOLERANCE;
    }

    public static void setTOLERANCE(int TOLERANCE) {
        Envelope.TOLERANCE = TOLERANCE;
    }


}

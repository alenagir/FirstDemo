package service;

import models.Envelope;
import myExceptions.VariableEnterException;


public class EnvelopeCompare  {
    Envelope envelope1;
    Envelope envelope2;
    Double sides [] = new Double[4];
    private String comparingResult;
    public static double TOLERANCE = 1;

    public EnvelopeCompare (){}

    public static double getTOLERANCE() {
        return TOLERANCE;
    }
    public static void setTOLERANCE(int TOLERANCE) {
        EnvelopeCompare.TOLERANCE = TOLERANCE;
    }

    public String comparingResult(Envelope envelope1, Envelope envelope2, Double sides[]) throws VariableEnterException {
        setEnvelopesSides (envelope1, envelope2, sides);
        int result=compare(envelope1, envelope2);
        if (result==1) comparingResult="The first is larger.";
        if (result==-1) comparingResult="The second is larger.";
        if (result==0) comparingResult="Might be equal within the tolerance in at least one of the parameters.";
        return comparingResult;
    }

    public void setEnvelopesSides (Envelope envelope1, Envelope envelope2, Double sides[]) throws VariableEnterException {
       for (int i=0; i<sides.length;i++) {
           if (sides[i]<=0)throw new VariableEnterException("A side must be > 0");
       }
            envelope1.setEnvelopeSides(sides[0], sides[1]);
            envelope2.setEnvelopeSides(sides[2], sides[3]);
    }


    public int compare(Envelope envelope1, Envelope envelope2 ) {
        if ( (envelope1.getSide_1() - envelope2.getSide_1()  > TOLERANCE
                && envelope1.getSide_2() - envelope2.getSide_2()  > TOLERANCE ) // compare as entered
                || ( envelope1.getSide_1() - envelope2.getSide_2()  > TOLERANCE
                && envelope1.getSide_2() - envelope2.getSide_1()  > TOLERANCE)) // compare as reversed
        {
            return 1;// First is larger
        }

        if ( (envelope1.getSide_1() - envelope2.getSide_1()  < -TOLERANCE
                && envelope1.getSide_2() - envelope2.getSide_2()  < -TOLERANCE ) // compare as entered
                || ( envelope1.getSide_1() - envelope2.getSide_2()  < -TOLERANCE
                && envelope1.getSide_2() - envelope2.getSide_1()  < -TOLERANCE)) // compare as reversed
        {
            return -1; // First is smaller
        } else return 0; // Equal
    }





}

package models;

import myExceptions.VariableEnterException;

public class Envelope {
    private double side_1;
    private double side_2;



    public Envelope() {}


    public double getSide_1() {
        return side_1;
    }

    public double getSide_2() {
        return side_2;
    }

    public void setEnvelopeSides(double side_1, double side_2) throws VariableEnterException {
        if (side_1<=0 || side_2<=0) {
            throw new VariableEnterException("Sides must be > 0");
        }
        this.side_1=side_1;
        this.side_2=side_2;
    }


}

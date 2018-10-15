package models;

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

    public void setEnvelopeSides(double side_1, double side_2) {
        this.side_1=side_1;
        this.side_2=side_2;
    }


}

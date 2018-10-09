package models.figures;

public class Triangle extends Polygon {

    public Triangle (){}

    @Override
    public void setSquare (){
        double p = (double) (this.length_1 + this.length_2 + this.length_3)/2;
        this.square=(double) Math.sqrt(p*(p-length_1)*(p-length_2)*(p-length_3));
    }

    @Override
    public String toString() {
        return name + ": " + "length 1 = "+ length_1+" " +"length 2 = " + length_2+" " +"length 3 = " + length_3+" "+ "square = " + square;

    }
}

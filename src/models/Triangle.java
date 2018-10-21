package models;

import myExceptions.VariableEnterException;

import java.util.Objects;

public class Triangle {
    private String name;
    private double side_1;
    private double side_2;
    private double side_3;
    private double square;

    public Triangle (){}

    public Triangle (String name, double side_1, double side_2, double side_3, double square){
        this.name=name;
        this.side_1=side_1;
        this.side_2=side_2;
        this.side_3=side_3;
        this.square=square;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setSides (double side_1, double side_2, double side_3) throws VariableEnterException {
        if (side_1<=0 || side_2<=0 || side_3<=0) {
            throw new VariableEnterException("Side length must be > 0");
        }
        if ((side_1+side_2 <= side_3) || (side_1+side_3 <= side_2) || (side_3+side_2 <= side_1)){
            throw new VariableEnterException("Triangle with two sides sum less or equal the third side does not exist");

        }
        else {
            this.side_1=side_1;
            this.side_2=side_2;
            this.side_3=side_3;
        }
    }

    public void setSquare (){
        double p = (side_1+side_2+side_3)/2;
        this.square=Math.sqrt(p*(p-side_1)*(p-side_2)*(p-side_3));
    }

    public String getName(){
        return this.name;
    }

    public double getSquare(){
        return this.square;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Triangle triangle = (Triangle) o;
        return Double.compare(triangle.side_1, side_1) == 0 &&
                Double.compare(triangle.side_2, side_2) == 0 &&
                Double.compare(triangle.side_3, side_3) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(side_1, side_2, side_3);
    }

    @Override
    public String toString() {
        return name + ": " + square ;
    }
}

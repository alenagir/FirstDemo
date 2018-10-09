package models.figures;

import java.util.Objects;

public abstract class Polygon {
    protected double length_1;
    protected double length_2;
    protected double length_3;
    protected double square;
    protected String name;

    public Polygon() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Polygon polygon = (Polygon) o;
        return Double.compare(polygon.length_1, length_1) == 0 &&
                Double.compare(polygon.length_2, length_2) == 0 &&
                Double.compare(polygon.length_3, length_3) == 0 &&
                Double.compare(polygon.square, square) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length_1, length_2, length_3, square);
    }

    @Override
    public String toString() {
        return name + "length 1 = " + length_1 +"length 2 = " + length_2 +"length 3 = " + length_3;

    }

    public abstract void setSquare ();


    public double getSquare() {
        return square;
    }

    public double getLength_1() {
        return length_1;
    }

    public void setLength_1(double length_1) {
        this.length_1 = length_1;
    }

    public double getLength_2() {
        return length_2;
    }

    public void setLength_2(double length_2) {
        this.length_2 = length_2;
    }

    public double getLength_3() {
        return length_3;
    }

    public void setLength_3(double length_3) {
        this.length_3 = length_3;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

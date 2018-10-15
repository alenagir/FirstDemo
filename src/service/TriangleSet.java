package service;

import models.Triangle;
import myExceptions.TriangleException;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TriangleSet {
    private Set<Triangle> triangleSet;
    private Triangle triangle;

    public String DEFAULT_NAME="Triangle";



    public TriangleSet(Comparator comparator){
        triangleSet = new TreeSet<>(comparator.reversed());
    }

    public void addTriangle(String userEnter) throws TriangleException {
        createTriangle(userEnter);
        triangleSet.add(triangle);
    }

    public Triangle createTriangle (String userEnter) throws TriangleException {
        triangle=new Triangle();
        String enteredParam[]=userEnter.split(",");
        //enteredParam[] must be 4(name + 3 sides divided by three commas):
        if(enteredParam.length<4){
            throw new TriangleException("Should be set triangle name and three sides");
        }

        Double sides []= new Double[3];
        try {
            for (int i = 0; i <= 2; i++) {
                sides[i] = Double.parseDouble(enteredParam[i+1]);
            }
        }catch (NumberFormatException e){
            throw new NumberFormatException("All sides must be double numbers");
        }

        //Set parameters to a triangle
        if(enteredParam[0].equals("") || enteredParam[0].equals(" ")){
            triangle.setName(DEFAULT_NAME);
        }else  triangle.setName(enteredParam[0]);

        triangle.setSides(sides[0], sides[1], sides[2]);
        triangle.setSquare();
        return triangle;
    }

    public void printTriangles(){
        for(Triangle triangle : triangleSet){
            System.out.printf("\n[%s]: %.2f cm^2",triangle.getName(), triangle.getSquare());
        }
    }

    // Inner class to build TreeSet
    public static class SquareComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return Double.compare(((Triangle) o1).getSquare(), ((Triangle) o2).getSquare());
        }
    }
    public static Comparator compareBySquare  = new SquareComparator();







}

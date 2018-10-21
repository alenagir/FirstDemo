package service;

import models.Triangle;
import myExceptions.VariableEnterException;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TriangleSet {
    public Set<Triangle> triangleTreeSet;
    private Triangle triangle;

    public String DEFAULT_NAME="Triangle";



    public TriangleSet(Comparator comparator){
        triangleTreeSet = new TreeSet<>(comparator.reversed());
    }

    //Method invoked from Main
    public Set addTriangle(String userEnter) throws VariableEnterException {
        createTriangle(userEnter);
        triangleTreeSet.add(triangle);
        return triangleTreeSet;
    }


    public Triangle createTriangle (String userEnter) throws VariableEnterException {
        triangle=new Triangle();
        String enteredParam[]=userEnter.split(",");
        //enteredParam[] must be 4(name + 3 sides divided by three commas):
        if(enteredParam.length<4){
            throw new VariableEnterException("Should be set triangle name and three sides:", userEnter);
        }

        // Parses to double and check for exception
        Double sides []= new Double[3];
        for (int i = 0; i <= 2; i++) {
            try {
                sides[i] = Double.parseDouble(enteredParam[i+1]);
            }catch (NumberFormatException e){
                throw new VariableEnterException("All sides must be set as double numbers",enteredParam[i+1]);
            }
        }

        //Sets parameters to a triangle
        if(enteredParam[0].equals("") || enteredParam[0].equals(" ")){
            triangle.setName(DEFAULT_NAME);
        }else  triangle.setName(enteredParam[0]);

        triangle.setSides(sides[0], sides[1], sides[2]);
        triangle.setSquare();
        return triangle;
    }

    public void printTriangles(){
        for(Triangle triangle : triangleTreeSet){
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
    public static Comparator comparedBySquare  = new SquareComparator();







}

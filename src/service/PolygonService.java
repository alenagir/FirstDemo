package service;

import models.figures.Polygon;
import models.figures.Triangle;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class PolygonService<T extends Polygon>  {
    private Set<Polygon> polygons;
    private Polygon polygon;
    private int countParameters;
    private int triangleParameters=4; // Name + 3 lengths
    private int MAX_PARAMETERS=4; // Currently only triangles exist.
    public double DEFAULT_LENGTH=1.0;
    public String DEFAULT_NAME="Polygon";
    private String userAnswer="yes";


    public PolygonService(Comparator comparator){
        polygons = new TreeSet<>(comparator);
    }

    // Main method to create polygons and fill in TreeSet automatically
    public void userCreatePolygon () {
        try {
            do {

                countParameters = 0; // Clear after previous cycle
                Printable.createPolygon();
                String[] userEnter = Scanned.scanToString().toLowerCase().split(",");

                for (String string : userEnter) {
                    countParameters++;
                }
                if (countParameters > MAX_PARAMETERS) {
                    return;
                }
                polygon = this.createPolygon(countParameters);

                this.setParameters(userEnter);

                this.addPolygon(polygon);

                Printable.continueQuestion();
                userAnswer = Scanned.scanToString().toLowerCase();
                if (userAnswer.equals("no") || userAnswer.equals("n")){
                    Printable.userTerminated();
                    break;
                }
            } while ((userAnswer.equals("yes") || userAnswer.equals("y")));
        }catch (NullPointerException e){
            System.out.println("You must enter a number after the last comma!");
        }catch (NumberFormatException ex){
            System.out.println(ex.getMessage()+" is not a number.");
        }
    }


    public void addPolygon(Polygon polygon){
        polygons.add(polygon);
    }

    public void printPolygons(){
        for(Polygon polygon : polygons){
            System.out.println(polygon);
        }
    }

    public static class SquareComparator implements Comparator {
        @Override
        public int compare(Object o1, Object o2) {
            return Double.compare(((Polygon) o1).getSquare(), ((Polygon) o2).getSquare());
        }
    }

    public static Comparator compareBySquare  = new SquareComparator();


    public double getDEFAULT_LENGTH() {
        return DEFAULT_LENGTH;
    }

    public void setDEFAULT_LENGTH(double DEFAULT_LENGTH) {
        this.DEFAULT_LENGTH = DEFAULT_LENGTH;
    }

    public String getDEFAULT_NAME() {
        return DEFAULT_NAME;
    }

    public void setDEFAULT_NAME(String DEFAULT_NAME) {
        this.DEFAULT_NAME = DEFAULT_NAME;
    }

    //Creates polygon depending on the number of entered sides (currently only triangle)
    private Polygon createPolygon(int countParameters){
        if (countParameters==triangleParameters){
            polygon = new Triangle();
        }
        else {Printable.doesNotExist();}
        return polygon;
    }

    // Set parameters to polygon
    private void setParameters(String[] userEnter) {

        if (userEnter[0].equals("")) {
            polygon.setName(DEFAULT_NAME);
        } else polygon.setName(userEnter[0]);

        if (userEnter[1].equals("")) {
            polygon.setLength_1(DEFAULT_LENGTH);
        } else polygon.setLength_1(Double.parseDouble(userEnter[1]));

        if (userEnter[2].equals("")) {
            polygon.setLength_2(DEFAULT_LENGTH);
        } else polygon.setLength_2(Double.parseDouble(userEnter[2]));

        if (userEnter[3].equals("")) {
            polygon.setLength_3(DEFAULT_LENGTH);
        } else polygon.setLength_3(Double.parseDouble(userEnter[3]));

        polygon.setSquare();
    }
}

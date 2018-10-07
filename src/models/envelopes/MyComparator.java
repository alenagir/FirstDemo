package models.envelopes;

import java.util.Comparator;

public interface MyComparator {

   public int TOLERANCE = 1; // Difference in size to physically contain another object

    public static int compare(double x, double y) {

        return (x - y < -TOLERANCE) ? -1 : ((x - y>TOLERANCE) ? 1 : 0);
    }


}

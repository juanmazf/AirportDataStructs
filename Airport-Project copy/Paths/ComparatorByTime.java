
package Paths;

import java.util.Comparator;

public class ComparatorByTime implements Comparator<PathVertex> {
    // Method
    // Sorting in ascending order of roll number
    public int compare(PathVertex v, PathVertex w)
    {
        return v.distance - w.distance;
    }
}
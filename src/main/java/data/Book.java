package data;

import file.Storage;

import java.util.ArrayList;

/**
 * Visu pazymiu saraso saugojimas
 */
public class Book {
    private ArrayList<Point> list;

    public Book() {
        list = new ArrayList<>();
    }

    public void addPoint(Point point) {
        list.add(point);
    }

    public ArrayList<Point> getPoints() {
        return list;
    }

    /**
     * Suskaiciuoti pazymiu vidurki
     * @return pazymiu vidurki
     */
    public double getAveragePoint() {
        if (list.size() == 0)
            return 0;
        int sum = 0;
        for (Point point : list)
            sum += point.getPoint();
        return (double)sum / list.size();
    }
}

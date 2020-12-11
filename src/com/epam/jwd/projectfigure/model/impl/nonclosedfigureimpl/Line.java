package com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl;

import com.epam.jwd.projectfigure.model.impl.NonClosedFigure;
import java.util.Arrays;

public class Line extends NonClosedFigure {

    private final Point[] points;

    Line(Point...points) {
        this.points = points;
    }

    @Override
    public Point[] getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Arrays.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(points);
    }

    @Override
    public String toString() {
        return "Line{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}

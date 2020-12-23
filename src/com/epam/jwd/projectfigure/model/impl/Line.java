package com.epam.jwd.projectfigure.model.impl;

import com.epam.jwd.projectfigure.model.Color;

import java.util.Arrays;

public class Line extends NonClosedFigure {

    private static Long idUnique = 0L;

    private final Point[] points;

    Line(Color color, Point...points) {
        super(idUnique++, color);
        this.points = points;
    }

    @Override
    public Point[] getPoints() {
        return points;
    }

    @Override
    public boolean isFigureExist() {
        if (points.length != 2) {
            return false;
        }
        return !points[0].equals(points[1]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Line line = (Line) o;
        return Arrays.equals(points, line.points);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

    @Override
    public String toString() {
        return "Line{" +
                "id=" + getId() +
                ", color=" + getColor().name() +
                ", points=" + Arrays.toString(points) +
                '}';
    }
}

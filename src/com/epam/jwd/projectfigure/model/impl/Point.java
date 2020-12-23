package com.epam.jwd.projectfigure.model.impl;

import java.util.Objects;

public class Point extends NonClosedFigure {

    private final double x;
    private final double y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double distanceBetweenPoints(Point otherPoint) {
        double deltaX = x - otherPoint.x;
        double deltaY = y - otherPoint.y;
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    @Override
    public boolean isFigureExist() {
        return true;
    }

    @Override
    public Point[] getPoints() {
        return new Point[] {this};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

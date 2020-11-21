package com.epam.jwd.model.children;

import com.epam.jwd.model.Figure;
import java.util.Objects;

public class Line extends Figure {

    private Point pointA;
    private Point pointB;

    public Line(Point pointA, Point pointB) {
        this.pointA = pointA;
        this.pointB = pointB;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(pointA, line.pointA) &&
                Objects.equals(pointB, line.pointB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointA, pointB);
    }

    @Override
    public String toString() {
        return "Line{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                '}';
    }
}

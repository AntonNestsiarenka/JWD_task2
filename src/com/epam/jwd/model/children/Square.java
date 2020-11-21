package com.epam.jwd.model.children;

import com.epam.jwd.model.Figure;
import java.util.Objects;

public class Square extends Figure {

    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

    public Square(Point pointA, Point pointB, Point pointC, Point pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
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

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public Point getPointD() {
        return pointD;
    }

    public void setPointD(Point pointD) {
        this.pointD = pointD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return Objects.equals(pointA, square.pointA) &&
                Objects.equals(pointB, square.pointB) &&
                Objects.equals(pointC, square.pointC) &&
                Objects.equals(pointD, square.pointD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointA, pointB, pointC, pointD);
    }

    @Override
    public String toString() {
        return "Square{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                ", pointD=" + pointD +
                '}';
    }
}

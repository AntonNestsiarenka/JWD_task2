package com.epam.jwd.projectfigure.model.impl;

import com.epam.jwd.projectfigure.strategy.ClosedFigureStrategy;
import com.epam.jwd.projectfigure.strategy.impl.MultiAngleStrategy;
import com.epam.jwd.projectfigure.strategy.impl.multianglestrategyimpl.MainMultiAngleStrategy;
import java.util.Arrays;

public class MultiAngle extends MultiAngleAbstraction {

    private final Point[] points;

    MultiAngle(Point...points) {
        super(MainMultiAngleStrategy.createInstance());
        this.points = points;
    }

    @Override
    public void setClosedFigurePropertiesStrategy(ClosedFigureStrategy closedFigurePropertiesStrategy) {
        if (closedFigurePropertiesStrategy instanceof MultiAngleStrategy) {
            super.setClosedFigurePropertiesStrategy(closedFigurePropertiesStrategy);
        }
    }

    @Override
    public Point[] getPoints() {
        return points;
    }

    @Override
    public boolean isFigureExist() {
        if (points.length < 3) {
            return false;
        }
        if (points.length == 3) {
            Triangle triangle = new Triangle(points);
            return triangle.isFigureExist();
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 2, count = 0; count < points.length - 3; count++, j++) {
                if (isIntersect(points[i], points[(i + 1) % points.length],
                        points[j % points.length], points[(j + 1) % points.length])) {
                    return false;
                }
            }
        }
        return true;
    }

    private double polygonArea(Point point1, Point point2, Point point3) {
        return (point2.getX() - point1.getX()) * (point3.getY() - point1.getY()) - (point2.getY() - point1.getY()) * (point3.getX() - point1.getX());
    }

    private boolean intersectPreCheck(double coordinateOfPoint1, double coordinateOfPoint2, double coordinateOfPoint3, double coordinateOfPoint4) {
        if (coordinateOfPoint1 > coordinateOfPoint2) {
            double temp = coordinateOfPoint1;
            coordinateOfPoint1 = coordinateOfPoint2;
            coordinateOfPoint2 = temp;
        }
        if (coordinateOfPoint3 > coordinateOfPoint4) {
            double temp = coordinateOfPoint3;
            coordinateOfPoint3 = coordinateOfPoint4;
            coordinateOfPoint4 = temp;
        }
        return Math.max(coordinateOfPoint1, coordinateOfPoint3) <= Math.min(coordinateOfPoint2, coordinateOfPoint4);
    }

    private boolean isIntersect(Point point1, Point point2, Point point3, Point point4) {
        return intersectPreCheck(point1.getX(), point2.getX(), point3.getX(), point4.getX())
                && intersectPreCheck(point1.getY(), point2.getY(), point3.getY(), point4.getY())
                && polygonArea(point1, point2, point3) * polygonArea(point1, point2, point4) <= 0
                && polygonArea(point3, point4, point1) * polygonArea(point3, point4, point2) <= 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MultiAngle that = (MultiAngle) o;
        return Arrays.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

    @Override
    public String toString() {
        return "MultiAngle{" +
                "points=" + Arrays.toString(points) +
                ", closedFigurePropertiesStrategy=" + getClosedFigurePropertiesStrategy() +
                '}';
    }
}

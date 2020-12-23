package com.epam.jwd.projectfigure.model.impl;

import com.epam.jwd.projectfigure.strategy.ClosedFigureStrategy;
import com.epam.jwd.projectfigure.strategy.impl.TriangleStrategy;
import com.epam.jwd.projectfigure.strategy.impl.trianglestrategyimpl.MainTriangleStrategy;
import java.util.Arrays;

public class Triangle extends MultiAngleAbstraction {

    private final Point[] points;

    Triangle(Point...points) {
        super(MainTriangleStrategy.createInstance());
        this.points = points;
    }

    @Override
    public Point[] getPoints() {
        return points;
    }

    @Override
    public void setClosedFigurePropertiesStrategy(ClosedFigureStrategy closedFigurePropertiesStrategy) {
        if (closedFigurePropertiesStrategy instanceof TriangleStrategy) {
            super.setClosedFigurePropertiesStrategy(closedFigurePropertiesStrategy);
        }
    }

    @Override
    public boolean isFigureExist() {
        if (points.length != 3) {
            return false;
        }
        double lengthAB = points[0].distanceBetweenPoints(points[1]);
        double lengthBC = points[1].distanceBetweenPoints(points[2]);
        double lengthCA = points[2].distanceBetweenPoints(points[0]);
        return lengthAB + lengthBC > lengthCA && lengthBC + lengthCA > lengthAB && lengthAB + lengthCA > lengthBC;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return Arrays.equals(points, triangle.points);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}

package com.epam.jwd.projectfigure.strategy.impl.trianglestrategyimpl;

import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;
import com.epam.jwd.projectfigure.strategy.impl.TriangleStrategy;

public enum AlterTriangleStrategy implements TriangleStrategy {

    INSTANCE;

    @Override
    public double figureArea(Point[] points) {
        Point pointA = points[0];
        Point pointB = points[1];
        Point pointC = points[2];
        double distanceAB = pointLogic.distanceBetweenPoints(pointA, pointB);
        double distanceBC = pointLogic.distanceBetweenPoints(pointB, pointC);
        double distanceCA = pointLogic.distanceBetweenPoints(pointC, pointA);
        double angle = Math.acos(Math.toRadians((Math.pow(distanceAB, 2) + Math.pow(distanceCA, 2) - Math.pow(distanceBC, 2))
                        / (2 * distanceAB * distanceCA)));
        return 0.5 * distanceAB * distanceCA * Math.sin(angle);
    }

    @Override
    public double figurePerimeter(Point[] points) {
        Point pointA = points[0];
        Point pointB = points[1];
        Point pointC = points[2];
        double distanceAB = pointLogic.distanceBetweenPoints(pointA, pointB);
        double distanceBC = pointLogic.distanceBetweenPoints(pointB, pointC);
        double distanceCA = pointLogic.distanceBetweenPoints(pointC, pointA);
        return distanceAB + distanceBC + distanceCA;
    }

    @Override
    public String toString() {
        return "AlterTriangleStrategy";
    }
}

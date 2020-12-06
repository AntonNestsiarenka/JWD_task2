package com.epam.jwd.projectfigure.strategy.impl.trianglestrategyimpl;

import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;
import com.epam.jwd.projectfigure.strategy.impl.TriangleStrategy;

public final class MainTriangleStrategy implements TriangleStrategy {

    private static MainTriangleStrategy instance;

    private MainTriangleStrategy() {

    }

    public static MainTriangleStrategy createInstance() {
        if (instance == null) {
            instance = new MainTriangleStrategy();
        }
        return instance;
    }

    @Override
    public double figureArea(Point[] points) {
        Point pointA = points[0];
        Point pointB = points[1];
        Point pointC = points[2];
        double distanceAB = pointLogic.distanceBetweenPoints(pointA, pointB);
        double distanceBC = pointLogic.distanceBetweenPoints(pointB, pointC);
        double distanceCA = pointLogic.distanceBetweenPoints(pointC, pointA);
        double halfPerimeter = (distanceAB + distanceBC + distanceCA) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - distanceAB) * (halfPerimeter - distanceBC) * (halfPerimeter - distanceCA));
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
        return "MainTriangleStrategy";
    }
}

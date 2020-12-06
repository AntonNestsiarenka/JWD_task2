package com.epam.jwd.projectfigure.strategy.impl.squarestrategyimpl;

import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;
import com.epam.jwd.projectfigure.strategy.impl.SquareStrategy;

public final class AlterSquareStrategy implements SquareStrategy {

    private static AlterSquareStrategy instance;

    private AlterSquareStrategy() {

    }

    public static AlterSquareStrategy createInstance() {
        if (instance == null) {
            instance = new AlterSquareStrategy();
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
        return distanceAB * distanceBC;
    }

    @Override
    public double figurePerimeter(Point[] points) {
        Point pointA = points[0];
        Point pointB = points[1];
        Point pointC = points[2];
        Point pointD = points[3];
        double distanceAB = pointLogic.distanceBetweenPoints(pointA, pointB);
        double distanceBC = pointLogic.distanceBetweenPoints(pointB, pointC);
        double distanceCD = pointLogic.distanceBetweenPoints(pointC, pointD);
        double distanceDA = pointLogic.distanceBetweenPoints(pointD, pointA);
        return distanceAB + distanceBC + distanceCD + distanceDA;
    }

    @Override
    public String toString() {
        return "AlterSquareStrategy";
    }
}

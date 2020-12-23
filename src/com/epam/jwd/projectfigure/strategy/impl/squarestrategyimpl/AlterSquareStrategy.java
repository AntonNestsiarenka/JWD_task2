package com.epam.jwd.projectfigure.strategy.impl.squarestrategyimpl;

import com.epam.jwd.projectfigure.model.impl.Point;
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
        double distanceAB = points[0].distanceBetweenPoints(points[1]);
        double distanceBC = points[1].distanceBetweenPoints(points[2]);
        return distanceAB * distanceBC;
    }

    @Override
    public double figurePerimeter(Point[] points) {
        double distanceAB = points[0].distanceBetweenPoints(points[1]);
        double distanceBC = points[1].distanceBetweenPoints(points[2]);
        double distanceCD = points[2].distanceBetweenPoints(points[3]);
        double distanceDA = points[3].distanceBetweenPoints(points[0]);
        return distanceAB + distanceBC + distanceCD + distanceDA;
    }

    @Override
    public String toString() {
        return "AlterSquareStrategy";
    }
}

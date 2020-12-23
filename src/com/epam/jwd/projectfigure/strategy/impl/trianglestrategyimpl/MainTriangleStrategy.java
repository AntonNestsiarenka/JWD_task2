package com.epam.jwd.projectfigure.strategy.impl.trianglestrategyimpl;

import com.epam.jwd.projectfigure.model.impl.Point;
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
        double distanceAB = points[0].distanceBetweenPoints(points[1]);
        double distanceBC = points[1].distanceBetweenPoints(points[2]);
        double distanceCA = points[2].distanceBetweenPoints(points[0]);
        double halfPerimeter = (distanceAB + distanceBC + distanceCA) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - distanceAB) * (halfPerimeter - distanceBC) * (halfPerimeter - distanceCA));
    }

    @Override
    public double figurePerimeter(Point[] points) {
        double distanceAB = points[0].distanceBetweenPoints(points[1]);
        double distanceBC = points[1].distanceBetweenPoints(points[2]);
        double distanceCA = points[2].distanceBetweenPoints(points[0]);
        return distanceAB + distanceBC + distanceCA;
    }

    @Override
    public String toString() {
        return "MainTriangleStrategy";
    }
}

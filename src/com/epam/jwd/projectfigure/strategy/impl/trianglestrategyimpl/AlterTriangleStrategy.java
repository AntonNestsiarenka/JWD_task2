package com.epam.jwd.projectfigure.strategy.impl.trianglestrategyimpl;

import com.epam.jwd.projectfigure.model.impl.Point;
import com.epam.jwd.projectfigure.strategy.impl.TriangleStrategy;

public enum AlterTriangleStrategy implements TriangleStrategy {

    INSTANCE;

    @Override
    public double figureArea(Point[] points) {
        double distanceAB = points[0].distanceBetweenPoints(points[1]);
        double distanceBC = points[1].distanceBetweenPoints(points[2]);
        double distanceCA = points[2].distanceBetweenPoints(points[0]);
        double angle = Math.acos(Math.toRadians((Math.pow(distanceAB, 2) + Math.pow(distanceCA, 2) - Math.pow(distanceBC, 2))
                        / (2 * distanceAB * distanceCA)));
        return 0.5 * distanceAB * distanceCA * Math.sin(angle);
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
        return "AlterTriangleStrategy";
    }
}

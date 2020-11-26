package com.epam.jwd.projectfigure.strategy.impl.trianglestrategyimpl;

import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.Triangle;
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
    public double figureArea(Triangle triangle) {
        double distanceAB = distanceBetweenPoints(triangle.getPointA(), triangle.getPointB());
        double distanceBC = distanceBetweenPoints(triangle.getPointB(), triangle.getPointC());
        double distanceCA = distanceBetweenPoints(triangle.getPointC(), triangle.getPointA());
        double halfPerimeter = (distanceAB + distanceBC + distanceCA) / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - distanceAB) * (halfPerimeter - distanceBC) * (halfPerimeter - distanceCA));
    }

    @Override
    public double figurePerimeter(Triangle triangle) {
        double distanceAB = distanceBetweenPoints(triangle.getPointA(), triangle.getPointB());
        double distanceBC = distanceBetweenPoints(triangle.getPointB(), triangle.getPointC());
        double distanceCA = distanceBetweenPoints(triangle.getPointC(), triangle.getPointA());
        return distanceAB + distanceBC + distanceCA;
    }

    @Override
    public String toString() {
        return "MainTriangleStrategy";
    }
}

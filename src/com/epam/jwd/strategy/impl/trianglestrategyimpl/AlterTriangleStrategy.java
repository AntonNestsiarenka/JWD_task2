package com.epam.jwd.strategy.impl.trianglestrategyimpl;

import com.epam.jwd.model.impl.closedfigureimpl.Triangle;
import com.epam.jwd.strategy.impl.TriangleStrategy;

public enum AlterTriangleStrategy implements TriangleStrategy {

    INSTANCE;

    @Override
    public double figureArea(Triangle figure) {
        double distanceAB = distanceBetweenPoints(figure.getPointA(), figure.getPointB());
        double distanceBC = distanceBetweenPoints(figure.getPointB(), figure.getPointC());
        double distanceCA = distanceBetweenPoints(figure.getPointC(), figure.getPointA());
        double angle = Math.acos(Math.toRadians((Math.pow(distanceAB, 2) + Math.pow(distanceCA, 2) - Math.pow(distanceBC, 2))
                        / (2 * distanceAB * distanceCA)));
        return 0.5 * distanceAB * distanceCA * Math.sin(angle);
    }

    @Override
    public double figurePerimeter(Triangle figure) {
        double distanceAB = distanceBetweenPoints(figure.getPointA(), figure.getPointB());
        double distanceBC = distanceBetweenPoints(figure.getPointB(), figure.getPointC());
        double distanceCA = distanceBetweenPoints(figure.getPointC(), figure.getPointA());
        return distanceAB + distanceBC + distanceCA;
    }
}

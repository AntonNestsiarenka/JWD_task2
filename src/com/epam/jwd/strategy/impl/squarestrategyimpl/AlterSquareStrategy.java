package com.epam.jwd.strategy.impl.squarestrategyimpl;

import com.epam.jwd.model.impl.closedfigureimpl.Square;
import com.epam.jwd.strategy.impl.SquareStrategy;

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
    public double figureArea(Square figure) {
        double distanceAB = distanceBetweenPoints(figure.getPointA(), figure.getPointB());
        double distanceBC = distanceBetweenPoints(figure.getPointB(), figure.getPointC());
        return distanceAB * distanceBC;
    }

    @Override
    public double figurePerimeter(Square figure) {
        double distanceAB = distanceBetweenPoints(figure.getPointA(), figure.getPointB());
        double distanceBC = distanceBetweenPoints(figure.getPointB(), figure.getPointC());
        double distanceCD = distanceBetweenPoints(figure.getPointC(), figure.getPointD());
        double distanceDA = distanceBetweenPoints(figure.getPointD(), figure.getPointA());
        return distanceAB + distanceBC + distanceCD + distanceDA;
    }
}

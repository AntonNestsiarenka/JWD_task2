package com.epam.jwd.strategy.impl.squarestrategyimpl;

import com.epam.jwd.model.impl.closedfigureimpl.Square;
import com.epam.jwd.strategy.impl.SquareStrategy;

public class MainSquareStrategy implements SquareStrategy {

    private static MainSquareStrategy instance;

    private MainSquareStrategy() {

    }

    public static MainSquareStrategy createInstance() {
        if (instance == null) {
            instance = new MainSquareStrategy();
        }
        return instance;
    }

    @Override
    public double figureArea(Square figure) {
        return Math.pow(distanceBetweenPoints(figure.getPointA(), figure.getPointB()), 2);
    }

    @Override
    public double figurePerimeter(Square figure) {
        return distanceBetweenPoints(figure.getPointA(), figure.getPointB()) * 4;
    }
}

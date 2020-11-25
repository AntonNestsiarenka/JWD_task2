package com.epam.jwd.strategy.impl.squarestrategyimpl;

import com.epam.jwd.model.impl.closedfigureimpl.Square;
import com.epam.jwd.strategy.impl.SquareStrategy;

public final class MainSquareStrategy implements SquareStrategy {

    private MainSquareStrategy() {

    }

    private static class MainSquareStrategySingleton {
        private static final MainSquareStrategy instance = new MainSquareStrategy();
    }

    public static MainSquareStrategy createInstance() {
        return MainSquareStrategySingleton.instance;
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

package com.epam.jwd.projectfigure.strategy.impl.squarestrategyimpl;

import com.epam.jwd.projectfigure.model.impl.Point;
import com.epam.jwd.projectfigure.strategy.impl.SquareStrategy;

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
    public double figureArea(Point[] points) {
        return Math.pow(points[0].distanceBetweenPoints(points[1]), 2);
    }

    @Override
    public double figurePerimeter(Point[] points) {
        return points[0].distanceBetweenPoints(points[1]) * 4;
    }

    @Override
    public String toString() {
        return "MainSquareStrategy";
    }
}

package com.epam.jwd.projectfigure.strategy.impl.squarestrategyimpl;

import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;
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
        Point pointA = points[0];
        Point pointB = points[1];
        return Math.pow(pointLogic.distanceBetweenPoints(pointA, pointB), 2);
    }

    @Override
    public double figurePerimeter(Point[] points) {
        Point pointA = points[0];
        Point pointB = points[1];
        return pointLogic.distanceBetweenPoints(pointA, pointB) * 4;
    }

    @Override
    public String toString() {
        return "MainSquareStrategy";
    }
}

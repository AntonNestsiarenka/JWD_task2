package com.epam.jwd.projectfigure.strategy.impl.multianglestrategyimpl;

import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.MultiAngle;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;
import com.epam.jwd.projectfigure.strategy.impl.MultiAngleStrategy;

public final class MainMultiAngleStrategy implements MultiAngleStrategy {

    private static MainMultiAngleStrategy instance;

    private MainMultiAngleStrategy() {

    }

    public static MainMultiAngleStrategy createInstance() {
        if (instance == null) {
            instance = new MainMultiAngleStrategy();
        }
        return instance;
    }

    @Override
    public double figureArea(MultiAngle figure) {
        double area = 0;
        Point[] points = figure.getPoints();
        for (int i = 0; i < points.length; i++) {
            area = area + (points[i].getX() + points[(i + 1) % points.length].getX()) * (points[(i + 1) % points.length].getY() - points[i].getY());
        }
        return Math.abs(area * 0.5);
    }

    @Override
    public double figurePerimeter(MultiAngle figure) {
        double perimeter = 0;
        Point[] points = figure.getPoints();
        for (int i = 0; i < points.length; i++) {
            perimeter = perimeter + distanceBetweenPoints(points[i], points[(i + 1) % points.length]);
        }
        return perimeter;
    }

    @Override
    public String toString() {
        return "MainMultiAngleStrategy";
    }
}

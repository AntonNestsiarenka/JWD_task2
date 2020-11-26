package com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl;

import com.epam.jwd.projectfigure.model.impl.factory.NonClosedFigureFactory;
import com.epam.jwd.projectfigure.model.impl.NonClosedFigure;
import java.util.HashSet;
import java.util.Set;

public final class NonClosedFigureFactoryImpl implements NonClosedFigureFactory {

    private final static Set<NonClosedFigure> CACHE = new HashSet<>();
    private static NonClosedFigureFactoryImpl instance;

    private NonClosedFigureFactoryImpl() {

    }

    public static NonClosedFigureFactoryImpl createInstance() {
        if (instance == null) {
            instance = new NonClosedFigureFactoryImpl();
        }
        return instance;
    }

    @Override
    public Point createPoint(double x, double y) {
        for (NonClosedFigure figure : CACHE) {
            if (figure instanceof Point) {
                Point pointFromCache = (Point) figure;
                if (pointFromCache.getX() == x && pointFromCache.getY() == y) {
                    return pointFromCache;
                }
            }
        }
        return createNewPoint(x, y);
    }

    @Override
    public Point createNewPoint(double x, double y) {
        Point newPoint = new Point(x, y);
        CACHE.add(newPoint);
        return newPoint;
    }

    @Override
    public Line createLine(Point pointA, Point pointB) {
        for (NonClosedFigure figure : CACHE) {
            if (figure instanceof Line) {
                Line lineFromCache = (Line) figure;
                if (lineFromCache.getPointA().equals(pointA) && lineFromCache.getPointB().equals(pointB)) {
                    return lineFromCache;
                }
            }
        }
        return createNewLine(pointA, pointB);
    }

    @Override
    public Line createNewLine(Point pointA, Point pointB) {
        Line newLine = new Line(pointA, pointB);
        CACHE.add(newLine);
        return newLine;
    }
}
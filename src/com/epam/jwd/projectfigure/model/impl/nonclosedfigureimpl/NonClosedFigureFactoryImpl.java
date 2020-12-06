package com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.model.impl.factory.NonClosedFigureFactory;
import com.epam.jwd.projectfigure.model.impl.NonClosedFigure;
import com.epam.jwd.projectfigure.service.NonClosedFigurePostProcessor;
import com.epam.jwd.projectfigure.service.nonclosedfigurepostprocessorimpl.NonClosedFigureExistencePostProcessor;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class NonClosedFigureFactoryImpl implements NonClosedFigureFactory {

    private final static Set<NonClosedFigure> CACHE = new HashSet<>();
    private final static NonClosedFigurePostProcessor NON_CLOSED_FIGURE_POST_PROCESSOR = new NonClosedFigureExistencePostProcessor();
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
    public NonClosedFigure createLine(Point pointA, Point pointB) throws FigureException {
        Point[] inputData = new Point[] {pointA, pointB};
        for (NonClosedFigure figure : CACHE) {
            if (figure instanceof Line) {
                Line lineFromCache = (Line) figure;
                if (Arrays.equals(lineFromCache.getPoints(), inputData)) {
                    return lineFromCache;
                }
            }
        }
        return createNewLine(pointA, pointB);
    }

    @Override
    public NonClosedFigure createNewLine(Point pointA, Point pointB) throws FigureException {
        NonClosedFigure newLine = NON_CLOSED_FIGURE_POST_PROCESSOR.process(new Line(pointA, pointB));
        CACHE.add(newLine);
        return newLine;
    }
}

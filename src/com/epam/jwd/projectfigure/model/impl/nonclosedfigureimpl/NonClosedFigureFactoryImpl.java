package com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.model.impl.factory.NonClosedFigureFactory;
import com.epam.jwd.projectfigure.model.impl.NonClosedFigure;
import com.epam.jwd.projectfigure.service.NonClosedFigurePostProcessor;
import com.epam.jwd.projectfigure.service.nonclosedfigurepostprocessorimpl.NonClosedFigureExistencePostProcessor;
import java.util.Arrays;

public final class NonClosedFigureFactoryImpl implements NonClosedFigureFactory {

    private static NonClosedFigure[] cache = new NonClosedFigure[10];
    private static int size = 0;
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
        for (NonClosedFigure figure : cache) {
            if (figure instanceof Point) {
                Point pointFromCache = (Point) figure;
                if (pointFromCache.getX() == x && pointFromCache.getY() == y) {
                    return pointFromCache;
                }
            }
        }
        Point newPoint = new Point(x, y);
        add(newPoint);
        return newPoint;
    }

    @Override
    public NonClosedFigure createLine(Point...points) throws FigureException {
        for (NonClosedFigure figure : cache) {
            if (figure instanceof Line) {
                Line lineFromCache = (Line) figure;
                if (Arrays.equals(lineFromCache.getPoints(), points)) {
                    return lineFromCache;
                }
            }
        }
        NonClosedFigure newLine = NON_CLOSED_FIGURE_POST_PROCESSOR.process(new Line(points));
        add(newLine);
        return newLine;
    }

    private void add(NonClosedFigure object) {
        if (size < cache.length) {
            cache[size++] = object;
        }
        else {
            resize();
        }
    }

    private void resize() {
        cache = Arrays.copyOf(cache, cache.length + (cache.length >> 1));
    }
}

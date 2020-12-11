package com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.factory.ClosedFigureFactory;
import com.epam.jwd.projectfigure.model.impl.ClosedFigure;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;
import java.util.Arrays;

public final class ClosedFigureFactoryImpl implements ClosedFigureFactory {

    private static ClosedFigure[] cache = new ClosedFigure[10];
    private static int size = 0;
    private static ClosedFigureFactoryImpl instance;

    private ClosedFigureFactoryImpl() {

    }

    public static ClosedFigureFactoryImpl createInstance() {
        if (instance == null) {
            instance = new ClosedFigureFactoryImpl();
        }
        return instance;
    }

    @Override
    public ClosedFigure createClosedFigure(String figureName, Point...points) throws FigureException{
        switch (figureName) {
            case ("Triangle"): {
                return createTriangle(points);
            }
            case ("Square"): {
                return createSquare(points);
            }
            case ("MultiAngle"): {
                return createMultiAngle(points);
            }
            default:{
                throw new IllegalArgumentException("Invalid figure name.");
            }
        }
    }

    private ClosedFigure createTriangle(Point...points) throws FigureException {
        for (ClosedFigure figure : cache) {
            if (figure instanceof Triangle) {
                Triangle triangleFromCache = (Triangle) figure;
                if (Arrays.equals(triangleFromCache.getPoints(), points)) {
                    return triangleFromCache;
                }
            }
        }
        ClosedFigure newTriangle = new Triangle(points);
        add(newTriangle);
        return newTriangle;
    }

    private ClosedFigure createSquare(Point...points) throws FigureException {
        for (ClosedFigure figure : cache) {
            if (figure instanceof Square) {
                Square squareFromCache = (Square) figure;
                if (Arrays.equals(squareFromCache.getPoints(), points)) {
                    return squareFromCache;
                }
            }
        }
        ClosedFigure newSquare = new Square(points);
        add(newSquare);
        return newSquare;
    }

    private ClosedFigure createMultiAngle(Point...points) throws FigureException {
        for (ClosedFigure figure : cache) {
            if (figure instanceof MultiAngle) {
                MultiAngle multiAngleFromCache = (MultiAngle) figure;
                Point[] multiAnglePointsFromCache = multiAngleFromCache.getPoints();
                if (Arrays.equals(multiAnglePointsFromCache, points)) {
                    return multiAngleFromCache;
                }
            }
        }
        ClosedFigure newMultiAngle = new MultiAngle(points);
        add(newMultiAngle);
        return newMultiAngle;
    }

    private void add(ClosedFigure object) {
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

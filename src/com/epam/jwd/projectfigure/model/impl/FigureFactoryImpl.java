package com.epam.jwd.projectfigure.model.impl;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.factory.FigureFactory;
import com.epam.jwd.projectfigure.model.Figure;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class FigureFactoryImpl implements FigureFactory {

    private static final Set<Figure> CACHE = new HashSet<>();
    private static FigureFactoryImpl instance;

    private FigureFactoryImpl() {

    }

    public static FigureFactoryImpl createInstance() {
        if (instance == null) {
            instance = new FigureFactoryImpl();
        }
        return instance;
    }

    @Override
    public Figure createFigure(String figureName, Point... points) throws FigureException {
        switch (figureName) {
            case ("Line"): {
                return createLine(points);
            }
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
        for (Figure figure : CACHE) {
            if (figure instanceof Triangle) {
                Triangle triangleFromCache = (Triangle) figure;
                if (Arrays.equals(triangleFromCache.getPoints(), points)) {
                    return triangleFromCache;
                }
            }
        }
        ClosedFigure newTriangle = new Triangle(points);
        CACHE.add(newTriangle);
        return newTriangle;
    }

    private ClosedFigure createSquare(Point...points) throws FigureException {
        for (Figure figure : CACHE) {
            if (figure instanceof Square) {
                Square squareFromCache = (Square) figure;
                if (Arrays.equals(squareFromCache.getPoints(), points)) {
                    return squareFromCache;
                }
            }
        }
        ClosedFigure newSquare = new Square(points);
        CACHE.add(newSquare);
        return newSquare;
    }

    private ClosedFigure createMultiAngle(Point...points) throws FigureException {
        for (Figure figure : CACHE) {
            if (figure instanceof MultiAngle) {
                MultiAngle multiAngleFromCache = (MultiAngle) figure;
                Point[] multiAnglePointsFromCache = multiAngleFromCache.getPoints();
                if (Arrays.equals(multiAnglePointsFromCache, points)) {
                    return multiAngleFromCache;
                }
            }
        }
        ClosedFigure newMultiAngle = new MultiAngle(points);
        CACHE.add(newMultiAngle);
        return newMultiAngle;
    }

    private NonClosedFigure createLine(Point...points) throws FigureException {
        for (Figure figure : CACHE) {
            if (figure instanceof Line) {
                Line lineFromCache = (Line) figure;
                if (Arrays.equals(lineFromCache.getPoints(), points)) {
                    return lineFromCache;
                }
            }
        }
        NonClosedFigure newLine = new Line(points);
        CACHE.add(newLine);
        return newLine;
    }
}
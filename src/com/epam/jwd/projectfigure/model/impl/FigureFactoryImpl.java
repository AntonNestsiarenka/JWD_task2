package com.epam.jwd.projectfigure.model.impl;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.factory.FigureFactory;
import com.epam.jwd.projectfigure.model.Color;
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
    public Figure createFigure(String figureName, Color color, Point... points) {
        switch (figureName) {
            case ("Line"): {
                return createLine(color, points);
            }
            case ("Triangle"): {
                return createTriangle(color, points);
            }
            case ("Square"): {
                return createSquare(color, points);
            }
            case ("MultiAngle"): {
                return createMultiAngle(color, points);
            }
            default:{
                throw new IllegalArgumentException("Invalid figure name.");
            }
        }
    }

    private ClosedFigure createTriangle(Color color, Point...points) {
        for (Figure figure : CACHE) {
            if (figure instanceof Triangle) {
                Triangle triangleFromCache = (Triangle) figure;
                if (Arrays.equals(triangleFromCache.getPoints(), points)) {
                    return triangleFromCache;
                }
            }
        }
        ClosedFigure newTriangle = new Triangle(color, points);
        CACHE.add(newTriangle);
        return newTriangle;
    }

    private ClosedFigure createSquare(Color color, Point...points) {
        for (Figure figure : CACHE) {
            if (figure instanceof Square) {
                Square squareFromCache = (Square) figure;
                if (Arrays.equals(squareFromCache.getPoints(), points)) {
                    return squareFromCache;
                }
            }
        }
        ClosedFigure newSquare = new Square(color, points);
        CACHE.add(newSquare);
        return newSquare;
    }

    private ClosedFigure createMultiAngle(Color color, Point...points) {
        for (Figure figure : CACHE) {
            if (figure instanceof MultiAngle) {
                MultiAngle multiAngleFromCache = (MultiAngle) figure;
                Point[] multiAnglePointsFromCache = multiAngleFromCache.getPoints();
                if (Arrays.equals(multiAnglePointsFromCache, points)) {
                    return multiAngleFromCache;
                }
            }
        }
        ClosedFigure newMultiAngle = new MultiAngle(color, points);
        CACHE.add(newMultiAngle);
        return newMultiAngle;
    }

    private NonClosedFigure createLine(Color color, Point...points) {
        for (Figure figure : CACHE) {
            if (figure instanceof Line) {
                Line lineFromCache = (Line) figure;
                if (Arrays.equals(lineFromCache.getPoints(), points)) {
                    return lineFromCache;
                }
            }
        }
        NonClosedFigure newLine = new Line(color, points);
        CACHE.add(newLine);
        return newLine;
    }
}
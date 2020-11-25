package com.epam.jwd.model.impl.closedfigureimpl;

import com.epam.jwd.model.impl.factory.ClosedFigureFactory;
import com.epam.jwd.model.impl.ClosedFigure;
import com.epam.jwd.model.impl.nonclosedfigureimpl.Point;
import com.epam.jwd.strategy.impl.SquareStrategy;
import com.epam.jwd.strategy.impl.TriangleStrategy;
import java.util.HashSet;
import java.util.Set;

public class ClosedFigureFactoryImpl implements ClosedFigureFactory {

    private final static Set<ClosedFigure> CACHE = new HashSet<>();
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
    public Triangle createTriangle(Point pointA, Point pointB, Point pointC, TriangleStrategy closedFigurePropertiesStrategy) {
        for (ClosedFigure figure : CACHE) {
            if (figure instanceof Triangle) {
                Triangle triangleFromCache = (Triangle) figure;
                if (triangleFromCache.getPointA().equals(pointA) && triangleFromCache.getPointB().equals(pointB)
                        && triangleFromCache.getPointC().equals(pointC)
                        && triangleFromCache.getClosedFigurePropertiesStrategy().equals(closedFigurePropertiesStrategy)) {
                    return triangleFromCache;
                }
            }
        }
        Triangle newTriangle = new Triangle(pointA, pointB, pointC, closedFigurePropertiesStrategy);
        CACHE.add(newTriangle);
        return newTriangle;
    }

    @Override
    public Square createSquare(Point pointA, Point pointB, Point pointC, Point pointD, SquareStrategy closedFigurePropertiesStrategy) {
        for (ClosedFigure figure : CACHE) {
            if (figure instanceof Square) {
                Square squareFromCache = (Square) figure;
                if (squareFromCache.getPointA().equals(pointA) && squareFromCache.getPointB().equals(pointB)
                        && squareFromCache.getPointC().equals(pointC) && squareFromCache.getPointD().equals(pointD)
                        && squareFromCache.getClosedFigurePropertiesStrategy().equals(closedFigurePropertiesStrategy)) {
                    return squareFromCache;
                }
            }
        }
        Square newSquare = new Square(pointA, pointB, pointC, pointD, closedFigurePropertiesStrategy);
        CACHE.add(newSquare);
        return newSquare;
    }
}

package com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.model.impl.factory.ClosedFigureFactory;
import com.epam.jwd.projectfigure.model.impl.ClosedFigure;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;
import com.epam.jwd.projectfigure.service.ClosedFigurePostProcessor;
import com.epam.jwd.projectfigure.service.closedfigurepostprocessorimpl.ClosedFigureExistencePostProcessor;
import com.epam.jwd.projectfigure.strategy.impl.MultiAngleStrategy;
import com.epam.jwd.projectfigure.strategy.impl.SquareStrategy;
import com.epam.jwd.projectfigure.strategy.impl.TriangleStrategy;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public final class ClosedFigureFactoryImpl implements ClosedFigureFactory {

    private final static Set<ClosedFigure> CACHE = new HashSet<>();
    private final static ClosedFigurePostProcessor CLOSED_FIGURE_POST_PROCESSOR = new ClosedFigureExistencePostProcessor();
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
    public ClosedFigure createTriangle(Point pointA, Point pointB, Point pointC, TriangleStrategy closedFigurePropertiesStrategy) throws FigureException {
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
        return createNewTriangle(pointA, pointB, pointC, closedFigurePropertiesStrategy);
    }

    @Override
    public ClosedFigure createNewTriangle(Point pointA, Point pointB, Point pointC, TriangleStrategy closedFigurePropertiesStrategy) throws FigureException {
        ClosedFigure newTriangle = CLOSED_FIGURE_POST_PROCESSOR.process(new Triangle(pointA, pointB, pointC, closedFigurePropertiesStrategy));
        CACHE.add(newTriangle);
        return newTriangle;
    }

    @Override
    public ClosedFigure createSquare(Point pointA, Point pointB, Point pointC, Point pointD, SquareStrategy closedFigurePropertiesStrategy) throws FigureException {
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
        return createNewSquare(pointA, pointB, pointC, pointD, closedFigurePropertiesStrategy);
    }

    @Override
    public ClosedFigure createNewSquare(Point pointA, Point pointB, Point pointC, Point pointD, SquareStrategy closedFigurePropertiesStrategy) throws FigureException {
        ClosedFigure newSquare = CLOSED_FIGURE_POST_PROCESSOR.process(new Square(pointA, pointB, pointC, pointD, closedFigurePropertiesStrategy));
        CACHE.add(newSquare);
        return newSquare;
    }

    @Override
    public ClosedFigure createMultiAngle(MultiAngleStrategy closedFigurePropertiesStrategy, Point...points) throws FigureException {
        for (ClosedFigure figure : CACHE) {
            if (figure instanceof MultiAngle) {
                MultiAngle multiAngleFromCache = (MultiAngle) figure;
                Point[] multiAnglePointsFromCache = multiAngleFromCache.getPoints();
                if (Arrays.equals(multiAnglePointsFromCache, points) && closedFigurePropertiesStrategy.equals(multiAngleFromCache.getClosedFigurePropertiesStrategy())) {
                    return multiAngleFromCache;
                }
            }
        }
        return createNewMultiAngle(closedFigurePropertiesStrategy, points);
    }

    @Override
    public ClosedFigure createNewMultiAngle(MultiAngleStrategy closedFigurePropertiesStrategy, Point...points) throws FigureException {
        ClosedFigure newMultiAngle = CLOSED_FIGURE_POST_PROCESSOR.process(new MultiAngle(closedFigurePropertiesStrategy, points));
        CACHE.add(newMultiAngle);
        return newMultiAngle;
    }
}

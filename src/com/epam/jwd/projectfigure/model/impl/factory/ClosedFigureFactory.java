package com.epam.jwd.projectfigure.model.impl.factory;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.model.impl.ClosedFigure;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;
import com.epam.jwd.projectfigure.strategy.impl.MultiAngleStrategy;
import com.epam.jwd.projectfigure.strategy.impl.SquareStrategy;
import com.epam.jwd.projectfigure.strategy.impl.TriangleStrategy;

public interface ClosedFigureFactory {

    ClosedFigure createTriangle(Point pointA, Point pointB, Point pointC, TriangleStrategy closedFigurePropertiesStrategy) throws FigureException;
    ClosedFigure createNewTriangle(Point pointA, Point pointB, Point pointC, TriangleStrategy closedFigurePropertiesStrategy) throws FigureException;
    ClosedFigure createSquare(Point pointA, Point pointB, Point pointC, Point pointD, SquareStrategy closedFigurePropertiesStrategy) throws FigureException;
    ClosedFigure createNewSquare(Point pointA, Point pointB, Point pointC, Point pointD, SquareStrategy closedFigurePropertiesStrategy) throws FigureException;
    ClosedFigure createMultiAngle(MultiAngleStrategy closedFigurePropertiesStrategy, Point...points) throws FigureException;
    ClosedFigure createNewMultiAngle(MultiAngleStrategy closedFigurePropertiesStrategy, Point...points) throws FigureException;
}

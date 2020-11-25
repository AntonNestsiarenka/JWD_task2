package com.epam.jwd.model.impl.factory;

import com.epam.jwd.model.impl.closedfigureimpl.Square;
import com.epam.jwd.model.impl.closedfigureimpl.Triangle;
import com.epam.jwd.model.impl.nonclosedfigureimpl.Point;
import com.epam.jwd.strategy.impl.SquareStrategy;
import com.epam.jwd.strategy.impl.TriangleStrategy;

public interface ClosedFigureFactory {

    Triangle createTriangle(Point pointA, Point pointB, Point pointC, TriangleStrategy closedFigurePropertiesStrategy);
    Triangle createNewTriangle(Point pointA, Point pointB, Point pointC, TriangleStrategy closedFigurePropertiesStrategy);
    Square createSquare(Point pointA, Point pointB, Point pointC, Point pointD, SquareStrategy closedFigurePropertiesStrategy);
    Square createNewSquare(Point pointA, Point pointB, Point pointC, Point pointD, SquareStrategy closedFigurePropertiesStrategy);
}

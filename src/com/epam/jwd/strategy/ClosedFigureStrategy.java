package com.epam.jwd.strategy;

import com.epam.jwd.model.impl.ClosedFigure;
import com.epam.jwd.model.impl.nonclosedfigureimpl.Point;

public interface ClosedFigureStrategy<T extends ClosedFigure> {

    default double distanceBetweenPoints(Point point1, Point point2)
    {
        double deltaX = point1.getX() - point2.getX();
        double deltaY = point1.getY() - point2.getY();
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    double figureArea(T figure);
    double figurePerimeter(T figure);

}

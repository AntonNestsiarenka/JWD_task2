package com.epam.jwd.projectfigure.strategy;

import com.epam.jwd.projectfigure.model.impl.Point;

public interface ClosedFigureStrategy {

    double figureArea(Point[] points);
    double figurePerimeter(Point[] points);
}

package com.epam.jwd.projectfigure.model.impl.factory;

import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Line;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;

public interface NonClosedFigureFactory {

    Point createPoint(double x, double y);
    Point createNewPoint(double x, double y);
    Line createLine(Point pointA, Point pointB);
    Line createNewLine(Point pointA, Point pointB);
}

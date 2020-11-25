package com.epam.jwd.model.impl.factory;

import com.epam.jwd.model.impl.nonclosedfigureimpl.Line;
import com.epam.jwd.model.impl.nonclosedfigureimpl.Point;

public interface NonClosedFigureFactory {

    Point createPoint(double x, double y);
    Line createLine(Point pointA, Point pointB);
}

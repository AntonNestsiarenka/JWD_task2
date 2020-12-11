package com.epam.jwd.projectfigure.model.impl.factory;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.model.impl.NonClosedFigure;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;

public interface NonClosedFigureFactory {

    Point createPoint(double x, double y);
    NonClosedFigure createLine(Point...points) throws FigureException;
}

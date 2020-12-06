package com.epam.jwd.projectfigure.strategy;

import com.epam.jwd.projectfigure.logic.PointLogic;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;

public interface ClosedFigureStrategy {

    PointLogic pointLogic = PointLogic.createInstance();

    double figureArea(Point[] points);
    double figurePerimeter(Point[] points);
}

package com.epam.jwd.projectfigure.factory;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.model.impl.ClosedFigure;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;

public interface ClosedFigureFactory {

    ClosedFigure createClosedFigure(String figureName, Point...points) throws FigureException;
}

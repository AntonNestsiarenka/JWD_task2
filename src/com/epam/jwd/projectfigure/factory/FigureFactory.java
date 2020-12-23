package com.epam.jwd.projectfigure.factory;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.model.Figure;
import com.epam.jwd.projectfigure.model.impl.Point;

public interface FigureFactory {

    Figure createFigure(String figureName, Point...points) throws FigureException;
}

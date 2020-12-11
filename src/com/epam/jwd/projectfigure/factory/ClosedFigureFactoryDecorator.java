package com.epam.jwd.projectfigure.factory;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.model.impl.ClosedFigure;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;

public abstract class ClosedFigureFactoryDecorator implements ClosedFigureFactory {

    private final ClosedFigureFactory closedFigureFactory;

    public ClosedFigureFactoryDecorator(ClosedFigureFactory closedFigureFactory) {
        this.closedFigureFactory = closedFigureFactory;
    }

    @Override
    public ClosedFigure createClosedFigure(String figureName, Point... points) throws FigureException {
        return closedFigureFactory.createClosedFigure(figureName, points);
    }
}

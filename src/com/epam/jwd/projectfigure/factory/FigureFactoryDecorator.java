package com.epam.jwd.projectfigure.factory;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.model.Figure;
import com.epam.jwd.projectfigure.model.impl.Point;

public abstract class FigureFactoryDecorator implements FigureFactory {

    private final FigureFactory figureFactory;

    public FigureFactoryDecorator(FigureFactory figureFactory) {
        this.figureFactory = figureFactory;
    }

    @Override
    public Figure createFigure(String figureName, Point... points) throws FigureException {
        return figureFactory.createFigure(figureName, points);
    }
}

package com.epam.jwd.projectfigure.service.impl;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.exception.FigureNotExistException;
import com.epam.jwd.projectfigure.model.Figure;
import com.epam.jwd.projectfigure.service.FigurePostProcessor;

public class FigurePostProcessorImpl implements FigurePostProcessor {

    @Override
    public Figure process(Figure figure) throws FigureException {
        if (figure.isNotCorrectFigure() || !figure.isFigureExist()) {
            throw new FigureNotExistException(String.format("Figure %s cannot exist", figure));
        }
        return figure;
    }
}

package com.epam.jwd.projectfigure.service;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.model.Figure;

public interface FigurePostProcessor {

    Figure process(Figure figure) throws FigureException;
}

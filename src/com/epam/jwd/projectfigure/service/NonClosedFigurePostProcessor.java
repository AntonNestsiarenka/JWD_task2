package com.epam.jwd.projectfigure.service;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.model.impl.NonClosedFigure;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Line;

public interface NonClosedFigurePostProcessor {

    NonClosedFigure process(Line nonClosedFigure) throws FigureException;
}

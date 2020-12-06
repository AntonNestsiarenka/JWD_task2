package com.epam.jwd.projectfigure.service;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.model.impl.ClosedFigure;
import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.MultiAngle;
import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.Square;
import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.Triangle;

public interface ClosedFigurePostProcessor {

    ClosedFigure process(Triangle closedFigure) throws FigureException;
    ClosedFigure process(Square closedFigure) throws FigureException;
    ClosedFigure process(MultiAngle closedFigure) throws FigureException;
}

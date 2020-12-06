package com.epam.jwd.projectfigure.service.closedfigurepostprocessorimpl;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.exception.FigureNotExistException;
import com.epam.jwd.projectfigure.logic.ClosedFigureLogic;
import com.epam.jwd.projectfigure.model.impl.ClosedFigure;
import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.MultiAngle;
import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.Square;
import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.Triangle;
import com.epam.jwd.projectfigure.service.ClosedFigurePostProcessor;

public class ClosedFigureExistencePostProcessor implements ClosedFigurePostProcessor {

    private static final ClosedFigureLogic CLOSED_FIGURE_LOGIC = ClosedFigureLogic.createInstance();

    @Override
    public ClosedFigure process(Triangle closedFigure) throws FigureException {
        if (CLOSED_FIGURE_LOGIC.isNotCorrectFigure(closedFigure) || !CLOSED_FIGURE_LOGIC.isFigureExist(closedFigure)) {
            throw new FigureNotExistException(String.format("Triangle %s cannot exist.", closedFigure));
        }
        return closedFigure;
    }

    @Override
    public ClosedFigure process(Square closedFigure) throws FigureException {
        if (CLOSED_FIGURE_LOGIC.isNotCorrectFigure(closedFigure) || !CLOSED_FIGURE_LOGIC.isFigureExist(closedFigure)) {
            throw new FigureNotExistException(String.format("Square %s cannot exist.", closedFigure));
        }
        return closedFigure;
    }

    @Override
    public ClosedFigure process(MultiAngle closedFigure) throws FigureException {
        if (CLOSED_FIGURE_LOGIC.isNotCorrectFigure(closedFigure) || !CLOSED_FIGURE_LOGIC.isFigureExist(closedFigure)) {
            throw new FigureNotExistException(String.format("Multi angle %s cannot exist.", closedFigure));
        }
        return closedFigure;
    }
}

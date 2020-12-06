package com.epam.jwd.projectfigure.service.nonclosedfigurepostprocessorimpl;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.exception.FigureNotExistException;
import com.epam.jwd.projectfigure.logic.NonClosedFigureLogic;
import com.epam.jwd.projectfigure.model.impl.NonClosedFigure;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Line;
import com.epam.jwd.projectfigure.service.NonClosedFigurePostProcessor;

public class NonClosedFigureExistencePostProcessor implements NonClosedFigurePostProcessor {

    private static final NonClosedFigureLogic NON_CLOSED_FIGURE_LOGIC = NonClosedFigureLogic.createInstance();

    @Override
    public NonClosedFigure process(Line nonClosedFigure) throws FigureException {
        if (NON_CLOSED_FIGURE_LOGIC.isFigureNotExist(nonClosedFigure)) {
            throw new FigureNotExistException(String.format("Line %s cannot exist", nonClosedFigure));
        }
        return nonClosedFigure;
    }
}

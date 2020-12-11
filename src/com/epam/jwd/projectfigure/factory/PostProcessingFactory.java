package com.epam.jwd.projectfigure.factory;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.model.impl.ClosedFigure;
import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.MultiAngle;
import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.Square;
import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.Triangle;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;
import com.epam.jwd.projectfigure.service.ClosedFigurePostProcessor;
import com.epam.jwd.projectfigure.service.closedfigurepostprocessorimpl.ClosedFigureExistencePostProcessor;

public class PostProcessingFactory extends ClosedFigureFactoryDecorator {

    private final ClosedFigurePostProcessor[] closedFigurePostProcessors = {new ClosedFigureExistencePostProcessor()};

    public PostProcessingFactory(ClosedFigureFactory closedFigureFactory) {
        super(closedFigureFactory);
    }

    @Override
    public ClosedFigure createClosedFigure(String figureName, Point... points) throws FigureException {
        ClosedFigure closedFigure = super.createClosedFigure(figureName, points);
        for (ClosedFigurePostProcessor closedFigurePostProcessor : closedFigurePostProcessors) {
            if (closedFigure instanceof Triangle) {
                Triangle triangle = (Triangle) closedFigure;
                closedFigure = closedFigurePostProcessor.process(triangle);
            }
            else if (closedFigure instanceof Square) {
                Square square = (Square) closedFigure;
                closedFigure = closedFigurePostProcessor.process(square);
            }
            else if (closedFigure instanceof MultiAngle) {
                MultiAngle multiAngle = (MultiAngle) closedFigure;
                closedFigure = closedFigurePostProcessor.process(multiAngle);
            }
        }
        return closedFigure;
    }
}

package com.epam.jwd.model.impl.closedfigureimpl;

import com.epam.jwd.model.impl.ClosedFigure;
import com.epam.jwd.strategy.ClosedFigureStrategy;

public abstract class MultiAngleAbstraction extends ClosedFigure {

    public MultiAngleAbstraction(ClosedFigureStrategy<? extends ClosedFigure> closedFigurePropertiesStrategy) {
        super(closedFigurePropertiesStrategy);
    }
}

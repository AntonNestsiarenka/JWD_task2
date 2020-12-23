package com.epam.jwd.projectfigure.model.impl;

import com.epam.jwd.projectfigure.model.impl.ClosedFigure;
import com.epam.jwd.projectfigure.strategy.ClosedFigureStrategy;

public abstract class MultiAngleAbstraction extends ClosedFigure {

    public MultiAngleAbstraction(ClosedFigureStrategy closedFigurePropertiesStrategy) {
        super(closedFigurePropertiesStrategy);
    }
}

package com.epam.jwd.projectfigure.model.impl;

import com.epam.jwd.projectfigure.model.Color;
import com.epam.jwd.projectfigure.strategy.ClosedFigureStrategy;

public abstract class MultiAngleAbstraction extends ClosedFigure {

    public MultiAngleAbstraction(Long id, Color color, ClosedFigureStrategy closedFigurePropertiesStrategy) {
        super(id, color, closedFigurePropertiesStrategy);
    }
}

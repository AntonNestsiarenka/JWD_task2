package com.epam.jwd.projectfigure.model.impl;

import com.epam.jwd.projectfigure.model.Figure;
import com.epam.jwd.projectfigure.strategy.ClosedFigureStrategy;
import java.util.Objects;

public abstract class ClosedFigure extends Figure {

    private ClosedFigureStrategy<? extends ClosedFigure> closedFigurePropertiesStrategy;

    public ClosedFigure(ClosedFigureStrategy<? extends ClosedFigure> closedFigurePropertiesStrategy) {
        this.closedFigurePropertiesStrategy = closedFigurePropertiesStrategy;
    }

    public ClosedFigureStrategy<? extends ClosedFigure> getClosedFigurePropertiesStrategy() {
        return closedFigurePropertiesStrategy;
    }

    public void setClosedFigurePropertiesStrategy(ClosedFigureStrategy<? extends ClosedFigure> closedFigurePropertiesStrategy) {
        this.closedFigurePropertiesStrategy = closedFigurePropertiesStrategy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClosedFigure that = (ClosedFigure) o;
        return Objects.equals(closedFigurePropertiesStrategy, that.closedFigurePropertiesStrategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(closedFigurePropertiesStrategy);
    }
}
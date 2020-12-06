package com.epam.jwd.projectfigure.model.impl;

import com.epam.jwd.projectfigure.model.Figure;
import com.epam.jwd.projectfigure.strategy.ClosedFigureStrategy;
import java.util.Objects;

public abstract class ClosedFigure extends Figure {

    private ClosedFigureStrategy closedFigurePropertiesStrategy;

    public ClosedFigure(ClosedFigureStrategy closedFigurePropertiesStrategy) {
        this.closedFigurePropertiesStrategy = closedFigurePropertiesStrategy;
    }

    public ClosedFigureStrategy getClosedFigurePropertiesStrategy() {
        return closedFigurePropertiesStrategy;
    }

    /*
       I don’t know how to keep the setter for polymorphism to work, or leave the setter in the implementation,
       but polymorphism will not work.
     */
//    protected void setClosedFigurePropertiesStrategy(ClosedFigureStrategy closedFigurePropertiesStrategy) {
//        this.closedFigurePropertiesStrategy = closedFigurePropertiesStrategy;
//    }

    public void setClosedFigurePropertiesStrategy(ClosedFigureStrategy closedFigurePropertiesStrategy) {
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

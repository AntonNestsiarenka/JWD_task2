package com.epam.jwd.projectfigure.model.impl;

import com.epam.jwd.projectfigure.model.Color;
import com.epam.jwd.projectfigure.model.Figure;
import com.epam.jwd.projectfigure.strategy.ClosedFigureStrategy;
import java.util.Objects;

public abstract class ClosedFigure extends Figure {

    private ClosedFigureStrategy closedFigurePropertiesStrategy;

    public ClosedFigure(Long id, Color color, ClosedFigureStrategy closedFigurePropertiesStrategy) {
        super(id, color);
        this.closedFigurePropertiesStrategy = closedFigurePropertiesStrategy;
    }

    public ClosedFigureStrategy getClosedFigurePropertiesStrategy() {
        return closedFigurePropertiesStrategy;
    }

    public void setClosedFigurePropertiesStrategy(ClosedFigureStrategy closedFigurePropertiesStrategy) {
        this.closedFigurePropertiesStrategy = closedFigurePropertiesStrategy;
    }

    public double figureArea() {
        return closedFigurePropertiesStrategy.figureArea(getPoints());
    }

    public double figurePerimeter() {
        return closedFigurePropertiesStrategy.figurePerimeter(getPoints());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ClosedFigure that = (ClosedFigure) o;
        return Objects.equals(closedFigurePropertiesStrategy, that.closedFigurePropertiesStrategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), closedFigurePropertiesStrategy);
    }
}

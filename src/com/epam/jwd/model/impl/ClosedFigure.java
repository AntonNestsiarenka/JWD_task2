package com.epam.jwd.model.impl;

import com.epam.jwd.model.Figure;
import com.epam.jwd.model.impl.nonclosedfigureimpl.Point;
import com.epam.jwd.strategy.ClosedFigureStrategy;
import java.util.Objects;

public abstract class ClosedFigure extends Figure {

    private Point pointA;
    private Point pointB;
    private Point pointC;
    private ClosedFigureStrategy<? extends ClosedFigure> closedFigurePropertiesStrategy;

    public ClosedFigure(Point pointA, Point pointB, Point pointC, ClosedFigureStrategy<? extends ClosedFigure> closedFigurePropertiesStrategy) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.closedFigurePropertiesStrategy = closedFigurePropertiesStrategy;
    }

    public Point getPointA() {
        return pointA;
    }

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public void setPointB(Point pointB) {
        this.pointB = pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
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
        return Objects.equals(pointA, that.pointA) &&
                Objects.equals(pointB, that.pointB) &&
                Objects.equals(pointC, that.pointC) &&
                Objects.equals(closedFigurePropertiesStrategy, that.closedFigurePropertiesStrategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointA, pointB, pointC, closedFigurePropertiesStrategy);
    }
}

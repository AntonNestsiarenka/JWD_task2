package com.epam.jwd.model.impl.closedfigureimpl;

import com.epam.jwd.model.impl.nonclosedfigureimpl.Point;
import com.epam.jwd.model.impl.ClosedFigure;
import com.epam.jwd.strategy.ClosedFigureStrategy;
import com.epam.jwd.strategy.impl.TriangleStrategy;

public class Triangle extends ClosedFigure {

    Triangle(Point pointA, Point pointB, Point pointC, TriangleStrategy closedFigurePropertiesStrategy) {
        super(pointA, pointB, pointC, closedFigurePropertiesStrategy);
    }

    @Override
    public ClosedFigureStrategy<Triangle> getClosedFigurePropertiesStrategy() {
        return (ClosedFigureStrategy<Triangle>) super.getClosedFigurePropertiesStrategy();
    }

    @Override
    public void setClosedFigurePropertiesStrategy(ClosedFigureStrategy<? extends ClosedFigure> closedFigurePropertiesStrategy) {
        if (closedFigurePropertiesStrategy instanceof TriangleStrategy) {
            super.setClosedFigurePropertiesStrategy(closedFigurePropertiesStrategy);
        }
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "pointA=" + getPointA() +
                ", pointB=" + getPointB() +
                ", pointC=" + getPointC() +
                ", closedFigurePropertiesStrategy=" + getClosedFigurePropertiesStrategy() +
                '}';
    }
}

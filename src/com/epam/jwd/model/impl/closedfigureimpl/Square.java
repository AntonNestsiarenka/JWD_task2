package com.epam.jwd.model.impl.closedfigureimpl;

import com.epam.jwd.model.impl.nonclosedfigureimpl.Point;
import com.epam.jwd.model.impl.ClosedFigure;
import com.epam.jwd.strategy.ClosedFigureStrategy;
import com.epam.jwd.strategy.impl.SquareStrategy;
import java.util.Objects;

public class Square extends ClosedFigure {

    private Point pointD;

    Square(Point pointA, Point pointB, Point pointC, Point pointD, SquareStrategy closedFigurePropertiesStrategy) {
        super(pointA, pointB, pointC, closedFigurePropertiesStrategy);
        this.pointD = pointD;
    }

    public Point getPointD() {
        return pointD;
    }

    public void setPointD(Point pointD) {
        this.pointD = pointD;
    }

    @Override
    public ClosedFigureStrategy<Square> getClosedFigurePropertiesStrategy() {
        return (ClosedFigureStrategy<Square>) super.getClosedFigurePropertiesStrategy();
    }

    @Override
    public void setClosedFigurePropertiesStrategy(ClosedFigureStrategy<? extends ClosedFigure> closedFigurePropertiesStrategy) {
        if (closedFigurePropertiesStrategy instanceof SquareStrategy) {
            super.setClosedFigurePropertiesStrategy(closedFigurePropertiesStrategy);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Square square = (Square) o;
        return Objects.equals(pointD, square.pointD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pointD);
    }

    @Override
    public String toString() {
        return "Square{" +
                "pointA=" + getPointA() +
                ", pointB=" + getPointB() +
                ", pointC=" + getPointC() +
                ", pointD=" + pointD +
                ", closedFigurePropertiesStrategy=" + getClosedFigurePropertiesStrategy() +
                '}';
    }
}

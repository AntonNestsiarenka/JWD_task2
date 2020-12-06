package com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl;

import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.MultiAngleAbstraction;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;
import com.epam.jwd.projectfigure.strategy.ClosedFigureStrategy;
import com.epam.jwd.projectfigure.strategy.impl.SquareStrategy;
import java.util.Objects;

public class Square extends MultiAngleAbstraction {

    private final Point pointA;
    private final Point pointB;
    private final Point pointC;
    private final Point pointD;

    Square(Point pointA, Point pointB, Point pointC, Point pointD, SquareStrategy closedFigurePropertiesStrategy) {
        super(closedFigurePropertiesStrategy);
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public Point getPointD() {
        return pointD;
    }

//    public void setClosedFigurePropertiesStrategy(SquareStrategy closedFigurePropertiesStrategy) {
//        super.setClosedFigurePropertiesStrategy(closedFigurePropertiesStrategy);
//    }

    @Override
    public void setClosedFigurePropertiesStrategy(ClosedFigureStrategy closedFigurePropertiesStrategy) {
        if (closedFigurePropertiesStrategy instanceof SquareStrategy) {
            super.setClosedFigurePropertiesStrategy(closedFigurePropertiesStrategy);
        }
    }

    @Override
    public Point[] getPoints() {
        return new Point[] {pointA, pointB, pointC, pointD};
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Square square = (Square) o;
        return Objects.equals(pointA, square.pointA) &&
                Objects.equals(pointB, square.pointB) &&
                Objects.equals(pointC, square.pointC) &&
                Objects.equals(pointD, square.pointD);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pointA, pointB, pointC, pointD);
    }

    @Override
    public String toString() {
        return "Square{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                ", pointD=" + pointD +
                ", closedFigurePropertiesStrategy=" + getClosedFigurePropertiesStrategy() +
                '}';
    }
}

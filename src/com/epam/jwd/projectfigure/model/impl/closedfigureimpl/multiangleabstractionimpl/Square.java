package com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl;

import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.MultiAngleAbstraction;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;
import com.epam.jwd.projectfigure.model.impl.ClosedFigure;
import com.epam.jwd.projectfigure.strategy.ClosedFigureStrategy;
import com.epam.jwd.projectfigure.strategy.impl.SquareStrategy;
import java.util.Objects;

public class Square extends MultiAngleAbstraction {

    private Point pointA;
    private Point pointB;
    private Point pointC;
    private Point pointD;

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

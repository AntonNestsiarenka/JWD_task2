package com.epam.jwd.model.impl.closedfigureimpl.multiangleabstractionimpl;

import com.epam.jwd.model.impl.closedfigureimpl.MultiAngleAbstraction;
import com.epam.jwd.model.impl.nonclosedfigureimpl.Point;
import com.epam.jwd.model.impl.ClosedFigure;
import com.epam.jwd.strategy.ClosedFigureStrategy;
import com.epam.jwd.strategy.impl.TriangleStrategy;
import java.util.Objects;

public class Triangle extends MultiAngleAbstraction {

    private Point pointA;
    private Point pointB;
    private Point pointC;

    Triangle(Point pointA, Point pointB, Point pointC, TriangleStrategy closedFigurePropertiesStrategy) {
        super(closedFigurePropertiesStrategy);
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(pointA, triangle.pointA) &&
                Objects.equals(pointB, triangle.pointB) &&
                Objects.equals(pointC, triangle.pointC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), pointA, pointB, pointC);
    }

    @Override
    public String toString() {
        return "Triangle{" +
                "pointA=" + pointA +
                ", pointB=" + pointB +
                ", pointC=" + pointC +
                ", closedFigurePropertiesStrategy=" + getClosedFigurePropertiesStrategy() +
                '}';
    }
}

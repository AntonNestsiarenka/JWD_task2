package com.epam.jwd.projectfigure.model.impl;

import com.epam.jwd.projectfigure.strategy.ClosedFigureStrategy;
import com.epam.jwd.projectfigure.strategy.impl.SquareStrategy;
import com.epam.jwd.projectfigure.strategy.impl.squarestrategyimpl.MainSquareStrategy;
import java.util.Arrays;

public class Square extends MultiAngleAbstraction {

    private final Point[] points;

    Square(Point...points) {
        super(MainSquareStrategy.createInstance());
        this.points = points;
    }

    @Override
    public void setClosedFigurePropertiesStrategy(ClosedFigureStrategy closedFigurePropertiesStrategy) {
        if (closedFigurePropertiesStrategy instanceof SquareStrategy) {
            super.setClosedFigurePropertiesStrategy(closedFigurePropertiesStrategy);
        }
    }

    @Override
    public Point[] getPoints() {
        return points;
    }

    @Override
    public boolean isFigureExist() {
        if (points.length != 4) {
            return false;
        }
        double lengthAB = points[0].distanceBetweenPoints(points[1]);
        double lengthBC = points[1].distanceBetweenPoints(points[2]);
        double lengthCD = points[2].distanceBetweenPoints(points[3]);
        double lengthDA = points[3].distanceBetweenPoints(points[0]);
        double diagonalAC = points[0].distanceBetweenPoints(points[2]);
        double diagonalBD = points[1].distanceBetweenPoints(points[3]);
        return lengthAB == lengthBC && lengthAB == lengthCD && lengthAB == lengthDA && diagonalAC == diagonalBD;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Square square = (Square) o;
        return Arrays.equals(points, square.points);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

    @Override
    public String toString() {
        return "Square{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}

package com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl;

import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.MultiAngleAbstraction;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;
import com.epam.jwd.projectfigure.strategy.ClosedFigureStrategy;
import com.epam.jwd.projectfigure.strategy.impl.MultiAngleStrategy;
import java.util.Arrays;

public class MultiAngle extends MultiAngleAbstraction {

    private final Point[] points;

    MultiAngle(MultiAngleStrategy closedFigurePropertiesStrategy, Point...points) {
        super(closedFigurePropertiesStrategy);
        this.points = points;
    }

//    public void setClosedFigurePropertiesStrategy(MultiAngleStrategy closedFigurePropertiesStrategy) {
//        super.setClosedFigurePropertiesStrategy(closedFigurePropertiesStrategy);
//    }

    @Override
    public void setClosedFigurePropertiesStrategy(ClosedFigureStrategy closedFigurePropertiesStrategy) {
        if (closedFigurePropertiesStrategy instanceof MultiAngleStrategy) {
            super.setClosedFigurePropertiesStrategy(closedFigurePropertiesStrategy);
        }
    }

    @Override
    public Point[] getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MultiAngle that = (MultiAngle) o;
        return Arrays.equals(points, that.points);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Arrays.hashCode(points);
        return result;
    }

    @Override
    public String toString() {
        return "MultiAngle{" +
                "points=" + Arrays.toString(points) +
                ", closedFigurePropertiesStrategy=" + getClosedFigurePropertiesStrategy() +
                '}';
    }
}

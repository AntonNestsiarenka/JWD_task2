package com.epam.jwd.logic;

import com.epam.jwd.exception.InvalidFigureData;
import com.epam.jwd.model.impl.closedfigureimpl.multiangleabstractionimpl.MultiAngle;
import com.epam.jwd.model.impl.nonclosedfigureimpl.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MultiAngleLogic extends ClosedFigureLogic<MultiAngle> {

    private final static Logger LOGGER = LogManager.getLogger(MultiAngleLogic.class);

    public MultiAngleLogic(PointLogic pointLogic) {
        super(pointLogic);
    }

    @Override
    public boolean isCorrectFigure(MultiAngle closedFigure) {
        Point[] pointsFromMultiAngle = closedFigure.getPoints();
        if (pointsFromMultiAngle.length < 3) {
            return false;
        }
        for (int i = 0; i < pointsFromMultiAngle.length - 1; i++) {
            for (int j = i + 1; j < pointsFromMultiAngle.length; j++) {
                if (pointsFromMultiAngle[i].equals(pointsFromMultiAngle[j])) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isFigureExist(MultiAngle closedFigure) {
        return false;
    }

    @Override
    public double figureArea(MultiAngle closedFigure) throws InvalidFigureData {
        return 0;
    }

    @Override
    public double figurePerimeter(MultiAngle closedFigure) {
        return 0;
    }

    @Override
    public void printInfo(MultiAngle[] closedFigures) {

    }
}

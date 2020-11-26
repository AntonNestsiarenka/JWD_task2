package com.epam.jwd.logic;

import com.epam.jwd.exception.InvalidFigureData;
import com.epam.jwd.model.impl.closedfigureimpl.multiangleabstractionimpl.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleLogic extends ClosedFigureLogic<Triangle> {

    private final static Logger LOGGER = LogManager.getLogger(TriangleLogic.class);

    public TriangleLogic(PointLogic pointLogic) {
        super(pointLogic);
    }

    @Override
    public boolean isCorrectFigure(Triangle triangle) {
        return !(triangle.getPointA().equals(triangle.getPointB()) ||
                triangle.getPointA().equals(triangle.getPointC()) ||
                triangle.getPointB().equals(triangle.getPointC()));
    }

    @Override
    public boolean isFigureExist(Triangle triangle) {
        double lengthAB = getPointLogic().distanceBetweenPoints(triangle.getPointA(), triangle.getPointB());
        double lengthBC = getPointLogic().distanceBetweenPoints(triangle.getPointB(), triangle.getPointC());
        double lengthCA = getPointLogic().distanceBetweenPoints(triangle.getPointC(), triangle.getPointA());
        return lengthAB + lengthBC > lengthCA && lengthBC + lengthCA > lengthAB && lengthAB + lengthCA > lengthBC;
    }

    @Override
    public double figureArea(Triangle closedFigure) throws InvalidFigureData {
        if (!isCorrectFigure(closedFigure)) {
            throw new InvalidFigureData("Invalid data of figure. All points must be different.");
        }
        if (!isFigureExist(closedFigure)) {
            throw new InvalidFigureData(String.format("Invalid data of figure. Figure has not a %s.", closedFigure.getClass().getSimpleName()));
        }
        return closedFigure.getClosedFigurePropertiesStrategy().figureArea(closedFigure);
    }

    @Override
    public double figurePerimeter(Triangle closedFigure) {
        return closedFigure.getClosedFigurePropertiesStrategy().figurePerimeter(closedFigure);
    }

    @Override
    public void printInfo(Triangle[] triangles) {
        for (Triangle triangle : triangles) {
            if (isCorrectFigure(triangle)) {
                if (isFigureExist(triangle)) {
                    LOGGER.info(triangle);
                }
                else {
                    LOGGER.error(String.format("Triangle %s cannot exist", triangle));
                }
            }
            else {
                LOGGER.error(String.format("Object %s has not a %s", triangle, "triangle"));
            }
        }
    }
}
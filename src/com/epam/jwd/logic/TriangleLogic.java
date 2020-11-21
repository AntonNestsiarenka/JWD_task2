package com.epam.jwd.logic;

import com.epam.jwd.model.children.Triangle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleLogic {

    private final static Logger LOGGER = LogManager.getLogger(TriangleLogic.class);

    private PointLogic pointLogic;

    public TriangleLogic(PointLogic pointLogic) {
        this.pointLogic = pointLogic;
    }

    public boolean isCorrectFigure(Triangle triangle)
    {
        return !(triangle.getPointA().equals(triangle.getPointB()) ||
                triangle.getPointA().equals(triangle.getPointC()) ||
                triangle.getPointB().equals(triangle.getPointC()));
    }

    public boolean isTriangleExist(Triangle triangle)
    {
        double lengthAB = pointLogic.distanceBetweenPoints(triangle.getPointA(), triangle.getPointB());
        double lengthBC = pointLogic.distanceBetweenPoints(triangle.getPointB(), triangle.getPointC());
        double lengthCA = pointLogic.distanceBetweenPoints(triangle.getPointC(), triangle.getPointA());
        return lengthAB + lengthBC > lengthCA && lengthBC + lengthCA > lengthAB && lengthAB + lengthCA > lengthBC;
    }

    public void printInfo(Triangle[] triangles)
    {
        for (Triangle triangle : triangles)
        {
            if (isCorrectFigure(triangle)) {
                if (isTriangleExist(triangle)) {
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

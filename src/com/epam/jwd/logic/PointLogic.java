package com.epam.jwd.logic;

import com.epam.jwd.model.children.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PointLogic {

    private final static Logger LOGGER = LogManager.getLogger(PointLogic.class);

    public double distanceBetweenPoints(Point point1, Point point2)
    {
        double deltaX = Math.abs(point1.getX() - point2.getX());
        double deltaY = Math.abs(point1.getY() - point2.getY());
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

    public void printInfo(Point[] points)
    {
        if (points.length != 0) {
            int i = 0;
            do {
                LOGGER.info(String.format("Element %d of points array %s", i, points[i++]));
            } while (i < points.length);
        }
        else {
            LOGGER.warn("Array of points is empty");
        }
    }
}

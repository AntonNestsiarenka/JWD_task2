package com.epam.jwd.projectfigure.logic;

import com.epam.jwd.projectfigure.exception.InvalidFigureData;
import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.MultiAngle;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;
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
        Point[] pointsFromMultiAngle = closedFigure.getPoints();
        if (pointsFromMultiAngle.length < 3) {
            return false;
        }
        for (int i = 0; i < pointsFromMultiAngle.length; i++) {
            for (int j = i + 2, count = 0; count < pointsFromMultiAngle.length - 3; count++, j++) {
                if (isIntersect(pointsFromMultiAngle[i], pointsFromMultiAngle[(i + 1) % pointsFromMultiAngle.length],
                        pointsFromMultiAngle[j % pointsFromMultiAngle.length],
                        pointsFromMultiAngle[(j + 1) % pointsFromMultiAngle.length])) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public double figureArea(MultiAngle closedFigure) throws InvalidFigureData {
        if (!isCorrectFigure(closedFigure)) {
            throw new InvalidFigureData("Invalid data of figure. All points must be different and amount of points must be >= 3.");
        }
        if (!isFigureExist(closedFigure)) {
            throw new InvalidFigureData(String.format("Invalid data of figure. Figure is not a simple %s.", closedFigure.getClass().getSimpleName()));
        }
        return closedFigure.getClosedFigurePropertiesStrategy().figureArea(closedFigure);
    }

    @Override
    public double figurePerimeter(MultiAngle closedFigure) throws InvalidFigureData {
        if (!isCorrectFigure(closedFigure)) {
            throw new InvalidFigureData("Invalid data of figure. All points must be different and amount of points must be >= 3.");
        }
        if (!isFigureExist(closedFigure)) {
            throw new InvalidFigureData(String.format("Invalid data of figure. Figure is not a simple %s.", closedFigure.getClass().getSimpleName()));
        }
        return closedFigure.getClosedFigurePropertiesStrategy().figurePerimeter(closedFigure);
    }

    @Override
    public void printInfo(MultiAngle[] closedFigures) {
        for (MultiAngle multiAngle : closedFigures) {
            if (isCorrectFigure(multiAngle)) {
                if (isFigureExist(multiAngle)) {
                    LOGGER.info(multiAngle);
                }
                else {
                    LOGGER.error(String.format("Simple %s cannot exist", multiAngle));
                }
            }
            else {
                LOGGER.error(String.format("Object %s is not a simple %s", multiAngle, "multi angle"));
            }
        }
    }

    private double polygonArea(Point point1, Point point2, Point point3) {
        return (point2.getX() - point1.getX()) * (point3.getY() - point1.getY()) - (point2.getY() - point1.getY()) * (point3.getX() - point1.getX());
    }

    private boolean intersectPreCheck(double coordinateOfPoint1, double coordinateOfPoint2, double coordinateOfPoint3, double coordinateOfPoint4) {
        if (coordinateOfPoint1 > coordinateOfPoint2) {
            double temp = coordinateOfPoint1;
            coordinateOfPoint1 = coordinateOfPoint2;
            coordinateOfPoint2 = temp;
        }
        if (coordinateOfPoint3 > coordinateOfPoint4) {
            double temp = coordinateOfPoint3;
            coordinateOfPoint3 = coordinateOfPoint4;
            coordinateOfPoint4 = temp;
        }
        return Math.max(coordinateOfPoint1, coordinateOfPoint3) <= Math.min(coordinateOfPoint2, coordinateOfPoint4);
    }

    private boolean isIntersect(Point point1, Point point2, Point point3, Point point4) {
        return intersectPreCheck(point1.getX(), point2.getX(), point3.getX(), point4.getX())
                && intersectPreCheck(point1.getY(), point2.getY(), point3.getY(), point4.getY())
                && polygonArea(point1, point2, point3) * polygonArea(point1, point2, point4) <= 0
                && polygonArea(point3, point4, point1) * polygonArea(point3, point4, point2) <= 0;
    }
}

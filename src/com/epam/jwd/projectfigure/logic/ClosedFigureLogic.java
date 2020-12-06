package com.epam.jwd.projectfigure.logic;

import com.epam.jwd.projectfigure.model.impl.ClosedFigure;
import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.MultiAngle;
import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.Square;
import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.Triangle;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClosedFigureLogic {

    private final static Logger LOGGER = LogManager.getLogger(ClosedFigureLogic.class);
    private final static PointLogic POINT_LOGIC = PointLogic.createInstance();
    private static ClosedFigureLogic instance;

    private ClosedFigureLogic() {

    }

    public static ClosedFigureLogic createInstance() {
        if (instance == null) {
            instance = new ClosedFigureLogic();
        }
        return instance;
    }

    public boolean isNotCorrectFigure(ClosedFigure closedFigure) {
        Point[] points = closedFigure.getPoints();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].equals(points[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isFigureExist(Triangle closedFigure) {
        double lengthAB = POINT_LOGIC.distanceBetweenPoints(closedFigure.getPointA(), closedFigure.getPointB());
        double lengthBC = POINT_LOGIC.distanceBetweenPoints(closedFigure.getPointB(), closedFigure.getPointC());
        double lengthCA = POINT_LOGIC.distanceBetweenPoints(closedFigure.getPointC(), closedFigure.getPointA());
        return lengthAB + lengthBC > lengthCA && lengthBC + lengthCA > lengthAB && lengthAB + lengthCA > lengthBC;
    }

    public boolean isFigureExist(Square closedFigure) {
        double lengthAB = POINT_LOGIC.distanceBetweenPoints(closedFigure.getPointA(), closedFigure.getPointB());
        double lengthBC = POINT_LOGIC.distanceBetweenPoints(closedFigure.getPointB(), closedFigure.getPointC());
        double lengthCD = POINT_LOGIC.distanceBetweenPoints(closedFigure.getPointC(), closedFigure.getPointD());
        double lengthDA = POINT_LOGIC.distanceBetweenPoints(closedFigure.getPointD(), closedFigure.getPointA());
        double diagonalAC = POINT_LOGIC.distanceBetweenPoints(closedFigure.getPointA(), closedFigure.getPointC());
        double diagonalBD = POINT_LOGIC.distanceBetweenPoints(closedFigure.getPointB(), closedFigure.getPointD());
        return lengthAB == lengthBC && lengthAB == lengthCD && lengthAB == lengthDA && diagonalAC == diagonalBD;
    }

    public boolean isFigureExist(MultiAngle closedFigure) {
        Point[] points = closedFigure.getPoints();
        if (points.length < 3) {
            return false;
        }
        if (points.length == 3) {
            return isTriangleExist(points[0], points[1], points[2]);
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 2, count = 0; count < points.length - 3; count++, j++) {
                if (isIntersect(points[i], points[(i + 1) % points.length],
                                points[j % points.length], points[(j + 1) % points.length])) {
                    return false;
                }
            }
        }
        return true;
    }

    public double figureArea(ClosedFigure closedFigure) {
        Point[] points = closedFigure.getPoints();
        return closedFigure.getClosedFigurePropertiesStrategy().figureArea(points);

    }

    public double figurePerimeter(ClosedFigure closedFigure) {
        Point[] points = closedFigure.getPoints();
        return closedFigure.getClosedFigurePropertiesStrategy().figurePerimeter(points);
    }

    public void printInfo(ClosedFigure[] closedFigures) {
        for (ClosedFigure closedFigure : closedFigures) {
            LOGGER.info(closedFigure);
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

    private boolean isTriangleExist(Point pointA, Point pointB, Point pointC) {
        double lengthAB = POINT_LOGIC.distanceBetweenPoints(pointA, pointB);
        double lengthBC = POINT_LOGIC.distanceBetweenPoints(pointB, pointC);
        double lengthCA = POINT_LOGIC.distanceBetweenPoints(pointC, pointA);
        return lengthAB + lengthBC > lengthCA && lengthBC + lengthCA > lengthAB && lengthAB + lengthCA > lengthBC;
    }
}

package com.epam.jwd.projectfigure.logic;

import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;

public class PointLogic {

    private static PointLogic instance;

    private PointLogic() {

    }

    public static PointLogic createInstance() {
        if (instance == null) {
            instance = new PointLogic();
        }
        return instance;
    }

    public double distanceBetweenPoints(Point point1, Point point2) {
        double deltaX = point1.getX() - point2.getX();
        double deltaY = point1.getY() - point2.getY();
        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }
}

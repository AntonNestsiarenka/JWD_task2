package com.epam.jwd.projectfigure.model;

import com.epam.jwd.projectfigure.model.impl.Point;

public abstract class Figure {

    public abstract Point[] getPoints();
    public abstract boolean isFigureExist();

    public boolean isNotCorrectFigure() {
        Point[] points = getPoints();
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].equals(points[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}

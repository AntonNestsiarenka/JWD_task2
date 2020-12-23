package com.epam.jwd.projectfigure.model;

import com.epam.jwd.projectfigure.model.impl.Point;

import java.util.Objects;

public abstract class Figure {

    private final Long id;
    private Color color;

    public Figure(Long id, Color color) {
        this.id = id;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Figure figure = (Figure) o;
        return Objects.equals(id, figure.id) &&
                color == figure.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, color);
    }
}

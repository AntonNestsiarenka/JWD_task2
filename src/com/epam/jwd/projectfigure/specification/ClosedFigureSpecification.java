package com.epam.jwd.projectfigure.specification;

import com.epam.jwd.projectfigure.model.Color;

public class ClosedFigureSpecification {

    private final Color color;
    private final Integer greaterPointsQuantity;
    private final Integer lesserPointsQuantity;
    private final Double greaterArea;
    private final Double lesserArea;
    private final Double greaterPerimeter;
    private final Double lesserPerimeter;

    private ClosedFigureSpecification(Color color, Integer greaterPointsQuantity, Integer lesserPointsQuantity,
                                      Double greaterArea, Double lesserArea, Double greaterPerimeter,
                                      Double lesserPerimeter) {
        this.color = color;
        this.greaterPointsQuantity = greaterPointsQuantity;
        this.lesserPointsQuantity = lesserPointsQuantity;
        this.greaterArea = greaterArea;
        this.lesserArea = lesserArea;
        this.greaterPerimeter = greaterPerimeter;
        this.lesserPerimeter = lesserPerimeter;
    }

    public Color getColor() {
        return color;
    }

    public Integer getGreaterPointsQuantity() {
        return greaterPointsQuantity;
    }

    public Integer getLesserPointsQuantity() {
        return lesserPointsQuantity;
    }

    public Double getGreaterArea() {
        return greaterArea;
    }

    public Double getLesserArea() {
        return lesserArea;
    }

    public Double getGreaterPerimeter() {
        return greaterPerimeter;
    }

    public Double getLesserPerimeter() {
        return lesserPerimeter;
    }

    public static class Builder {

        private Color color;
        private Integer greaterPointsQuantity;
        private Integer lesserPointsQuantity;
        private Double greaterArea;
        private Double lesserArea;
        private Double greaterPerimeter;
        private Double lesserPerimeter;

        public ClosedFigureSpecification.Builder whereColor(Color color) {
            this.color = color;
            return this;
        }

        public ClosedFigureSpecification.Builder wherePointsQuantityGreaterThan(Integer greaterPointsQuantity) {
            this.greaterPointsQuantity = greaterPointsQuantity;
            return this;
        }

        public ClosedFigureSpecification.Builder wherePointsQuantityLesserThan(Integer lesserPointsQuantity) {
            this.lesserPointsQuantity = lesserPointsQuantity;
            return this;
        }

        public ClosedFigureSpecification.Builder whereAreaGreaterThan(Double greaterArea) {
            this.greaterArea = greaterArea;
            return this;
        }

        public ClosedFigureSpecification.Builder whereAreaLesserThan(Double lesserArea) {
            this.lesserArea = lesserArea;
            return this;
        }

        public ClosedFigureSpecification.Builder wherePerimeterGreaterThan(Double greaterPerimeter) {
            this.greaterPerimeter = greaterPerimeter;
            return this;
        }

        public ClosedFigureSpecification.Builder wherePerimeterLesserThan(Double lesserPerimeter) {
            this.lesserPerimeter = lesserPerimeter;
            return this;
        }

        public ClosedFigureSpecification build() {
            return new ClosedFigureSpecification(color, greaterPointsQuantity, lesserPointsQuantity, greaterArea,
                    lesserArea, greaterPerimeter, lesserPerimeter);
        }
    }

    public static ClosedFigureSpecification.Builder builder() {
        return new ClosedFigureSpecification.Builder();
    }
}

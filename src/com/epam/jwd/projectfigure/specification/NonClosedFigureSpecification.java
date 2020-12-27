package com.epam.jwd.projectfigure.specification;

import com.epam.jwd.projectfigure.model.Color;

public class NonClosedFigureSpecification {

    private final Color color;
    private final Double greaterLineLength;
    private final Double lesserLineLength;

    private NonClosedFigureSpecification(Color color, Double greaterLineLength, Double lesserLineLength) {
        this.color = color;
        this.greaterLineLength = greaterLineLength;
        this.lesserLineLength = lesserLineLength;
    }

    public Color getColor() {
        return color;
    }

    public Double getGreaterLineLength() {
        return greaterLineLength;
    }

    public Double getLesserLineLength() {
        return lesserLineLength;
    }

    public static class Builder {

        private Color color;
        private Double greaterLineLength;
        private Double lesserLineLength;

        public Builder whereColor(Color color) {
            this.color = color;
            return this;
        }

        public Builder whereLineLengthGreaterThan(Double greaterLineLength) {
            this.greaterLineLength = greaterLineLength;
            return this;
        }

        public Builder whereLineLengthLesserThan(Double lesserLineLength) {
            this.lesserLineLength = lesserLineLength;
            return this;
        }

        public NonClosedFigureSpecification build() {
            return new NonClosedFigureSpecification(color, greaterLineLength, lesserLineLength);
        }
    }

    public static Builder builder() {
        return new Builder();
    }
}

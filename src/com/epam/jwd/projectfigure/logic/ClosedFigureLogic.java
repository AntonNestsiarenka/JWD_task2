package com.epam.jwd.projectfigure.logic;

import com.epam.jwd.projectfigure.exception.InvalidFigureData;
import com.epam.jwd.projectfigure.model.impl.ClosedFigure;

public abstract class ClosedFigureLogic<T extends ClosedFigure> {

    private PointLogic pointLogic;

    public ClosedFigureLogic(PointLogic pointLogic) {
        this.pointLogic = pointLogic;
    }

    public PointLogic getPointLogic() {
        return pointLogic;
    }

    public abstract boolean isCorrectFigure(T closedFigure);
    public abstract boolean isFigureExist(T closedFigure);
    public abstract double figureArea(T closedFigure) throws InvalidFigureData;
    public abstract double figurePerimeter(T closedFigure) throws InvalidFigureData;
    public abstract void printInfo(T[] closedFigures);
}

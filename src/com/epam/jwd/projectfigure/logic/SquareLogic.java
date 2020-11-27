package com.epam.jwd.projectfigure.logic;

import com.epam.jwd.projectfigure.exception.InvalidFigureDataException;
import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.Square;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SquareLogic extends ClosedFigureLogic<Square> {

    private final static Logger LOGGER = LogManager.getLogger(SquareLogic.class);

    public SquareLogic(PointLogic pointLogic) {
        super(pointLogic);
    }

    @Override
    public boolean isCorrectFigure(Square square) {
        return !(square.getPointA().equals(square.getPointB()) ||
                square.getPointA().equals(square.getPointC()) ||
                square.getPointA().equals(square.getPointD()) ||
                square.getPointB().equals(square.getPointC()) ||
                square.getPointB().equals(square.getPointD()) ||
                square.getPointC().equals(square.getPointD()));
    }

    @Override
    public boolean isFigureExist(Square square) {
        double lengthAB = getPointLogic().distanceBetweenPoints(square.getPointA(), square.getPointB());
        double lengthBC = getPointLogic().distanceBetweenPoints(square.getPointB(), square.getPointC());
        double lengthCD = getPointLogic().distanceBetweenPoints(square.getPointC(), square.getPointD());
        double lengthDA = getPointLogic().distanceBetweenPoints(square.getPointD(), square.getPointA());
        double diagonalAC = getPointLogic().distanceBetweenPoints(square.getPointA(), square.getPointC());
        double diagonalBD = getPointLogic().distanceBetweenPoints(square.getPointB(), square.getPointD());
        return lengthAB == lengthBC && lengthAB == lengthCD && lengthAB == lengthDA && diagonalAC == diagonalBD;
    }

    @Override
    public double figureArea(Square closedFigure) throws InvalidFigureDataException {
        if (!isCorrectFigure(closedFigure)) {
            throw new InvalidFigureDataException("Invalid data of figure. All points must be different.");
        }
        if (!isFigureExist(closedFigure)) {
            throw new InvalidFigureDataException(String.format("Invalid data of figure. Figure has not a %s.", closedFigure.getClass().getSimpleName()));
        }
        return closedFigure.getClosedFigurePropertiesStrategy().figureArea(closedFigure);
    }

    @Override
    public double figurePerimeter(Square closedFigure) throws InvalidFigureDataException {
        if (!isCorrectFigure(closedFigure)) {
            throw new InvalidFigureDataException("Invalid data of figure. All points must be different.");
        }
        if (!isFigureExist(closedFigure)) {
            throw new InvalidFigureDataException(String.format("Invalid data of figure. Figure has not a %s.", closedFigure.getClass().getSimpleName()));
        }
        return closedFigure.getClosedFigurePropertiesStrategy().figurePerimeter(closedFigure);
    }

    @Override
    public void printInfo(Square[] squares) {
        for (Square square : squares) {
            if (isCorrectFigure(square)) {
                if (isFigureExist(square)) {
                    LOGGER.info(square);
                }
                else {
                    LOGGER.error(String.format("Object %s is not a %s", square, "square"));
                }
            }
            else {
                LOGGER.error(String.format("Object %s is not a %s", square, "square"));
            }
        }
    }
}

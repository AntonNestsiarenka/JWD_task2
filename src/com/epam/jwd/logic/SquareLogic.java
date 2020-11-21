package com.epam.jwd.logic;

import com.epam.jwd.model.children.Square;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SquareLogic {

    private final static Logger LOGGER = LogManager.getLogger(SquareLogic.class);

    private PointLogic pointLogic;

    public SquareLogic(PointLogic pointLogic) {
        this.pointLogic = pointLogic;
    }

    public boolean isCorrectFigure(Square square)
    {
        return !(square.getPointA().equals(square.getPointB()) ||
                square.getPointA().equals(square.getPointC()) ||
                square.getPointA().equals(square.getPointD()) ||
                square.getPointB().equals(square.getPointC()) ||
                square.getPointB().equals(square.getPointD()) ||
                square.getPointC().equals(square.getPointD()));
    }

    public boolean isSquareExist(Square square)
    {
        double lengthAB = pointLogic.distanceBetweenPoints(square.getPointA(), square.getPointB());
        double lengthBC = pointLogic.distanceBetweenPoints(square.getPointB(), square.getPointC());
        double lengthCD = pointLogic.distanceBetweenPoints(square.getPointC(), square.getPointD());
        double lengthDA = pointLogic.distanceBetweenPoints(square.getPointD(), square.getPointA());
        double diagonalAC = pointLogic.distanceBetweenPoints(square.getPointA(), square.getPointC());
        double diagonalBD = pointLogic.distanceBetweenPoints(square.getPointB(), square.getPointD());
        return lengthAB == lengthBC && lengthAB == lengthCD && lengthAB == lengthDA && diagonalAC == diagonalBD;
    }

    public void printInfo(Square[] squares)
    {
        for (Square square : squares)
        {
            if (isCorrectFigure(square)) {
                if (isSquareExist(square)) {
                    LOGGER.info(square);
                }
                else {
                    LOGGER.error(String.format("Object %s has not a %s", square, "square"));
                }
            }
            else {
                LOGGER.error(String.format("Object %s has not a %s", square, "square"));
            }
        }
    }
}

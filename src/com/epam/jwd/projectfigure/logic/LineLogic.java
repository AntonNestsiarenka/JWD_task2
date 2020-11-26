package com.epam.jwd.projectfigure.logic;

import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Line;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LineLogic {

    private final static Logger LOGGER = LogManager.getLogger(LineLogic.class);

    public boolean isCorrectFigure(Line line) {
        return !line.getPointA().equals(line.getPointB());
    }

    public void printInfo(Line[] lines) {
        for (Line line : lines) {
            if (isCorrectFigure(line)) {
                LOGGER.info(line);
            }
            else {
                LOGGER.error(String.format("Object %s is not a %s", line, "line"));
            }
        }
    }
}

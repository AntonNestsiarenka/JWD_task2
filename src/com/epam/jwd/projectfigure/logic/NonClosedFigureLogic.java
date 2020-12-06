package com.epam.jwd.projectfigure.logic;

import com.epam.jwd.projectfigure.model.impl.NonClosedFigure;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Line;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NonClosedFigureLogic {

    private final static Logger LOGGER = LogManager.getLogger(NonClosedFigureLogic.class);
    private static NonClosedFigureLogic instance;

    private NonClosedFigureLogic() {

    }

    public static NonClosedFigureLogic createInstance() {
        if (instance == null) {
            instance = new NonClosedFigureLogic();
        }
        return instance;
    }

    public boolean isFigureNotExist(Line line) {
        return line.getPointA().equals(line.getPointB());
    }

    public void printInfo(NonClosedFigure[] nonClosedFigures) {
        for (NonClosedFigure nonClosedFigure : nonClosedFigures) {
            LOGGER.info(nonClosedFigure);
        }
    }
}

package com.epam.jwd.projectfigure.logic;

import com.epam.jwd.projectfigure.model.Figure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FigureLogic {

    private final static Logger LOGGER = LogManager.getLogger(FigureLogic.class);
    private static FigureLogic instance;

    private FigureLogic() {

    }

    public static FigureLogic createInstance() {
        if (instance == null) {
            instance = new FigureLogic();
        }
        return instance;
    }

    public void printInfo(Figure[] figures) {
        for (Figure figure : figures) {
            LOGGER.info(figure);
        }
    }
}

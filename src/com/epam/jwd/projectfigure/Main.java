package com.epam.jwd.projectfigure;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.factory.FigureFactory;
import com.epam.jwd.projectfigure.logic.FigureLogic;
import com.epam.jwd.projectfigure.model.Color;
import com.epam.jwd.projectfigure.model.Figure;
import com.epam.jwd.projectfigure.model.impl.ApplicationContext;
import com.epam.jwd.projectfigure.model.impl.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger(Main.class);
    private final static FigureLogic FIGURE_LOGIC = FigureLogic.createInstance();
    private final static FigureFactory FIGURE_FACTORY = ApplicationContext.INSTANCE.createFigureFactory();

    public static void main(String[] args) {
        Point[] points = {new Point(0, 0), new Point(0.56, 2.5), new Point(1, 2.25), new Point(-2.14, -5.48)};

        Figure[] lines = new Figure[0];
        try {
            lines = new Figure[] {FIGURE_FACTORY.createFigure("Line", Color.BLACK, new Point(0, 0), new Point(-1.25, 4.78)),
                    FIGURE_FACTORY.createFigure("Line", Color.BROWN, new Point(-2.21, 0.2), new Point(6.25, -4.05))};
        } catch (FigureException e) {
            LOGGER.error(e.getMessage());
        }

        Figure[] triangles = new Figure[0];
        try {
            triangles = new Figure[] {FIGURE_FACTORY.createFigure("Triangle", Color.BLACK, new Point(0, 0),
                    new Point(1.5, -2.59), new Point(3.45, 1.28)),
                    FIGURE_FACTORY.createFigure("Triangle", Color.GREEN, new Point(-3.12, 1.5),
                            new Point(0, 4.45), new Point(-6.15, -2.03))};
        } catch (FigureException e) {
            LOGGER.error(e.getMessage());
        }

        Figure[] squares = new Figure[0];
        try {
            squares = new Figure[] {FIGURE_FACTORY.createFigure("Square", Color.RED, new Point(1.1, 2.36),
                    new Point(-2.0, 3.45), new Point(-2.95, 3.35), new Point(4, 0))};
        } catch (FigureException e) {
            LOGGER.error(e.getMessage());
        }

        System.out.println(Arrays.toString(points));
        FIGURE_LOGIC.printInfo(lines);
        FIGURE_LOGIC.printInfo(triangles);
        FIGURE_LOGIC.printInfo(squares);

        Point[] pointsForMultiAngle1 = {new Point(-3.1, -2), new Point(0.12, 4.5), new Point(1.85, 1.96),
                new Point(1.95, -3.4)};

        Point[] pointsForMultiAngle2 = {new Point(-20, 20), new Point(0, 35.78), new Point(15, 20),
                new Point(-15, 30), new Point(0, -35.78), new Point(-20, -20)};

        Figure[] multiAngles = new Figure[0];
        try {
            multiAngles = new Figure[] {FIGURE_FACTORY.createFigure("MultiAngle", Color.BLUE, pointsForMultiAngle1),
                    FIGURE_FACTORY.createFigure("MultiAngle", Color.GREY, pointsForMultiAngle2)};
        } catch (FigureException e) {
            LOGGER.error(e.getMessage());
        }
        FIGURE_LOGIC.printInfo(multiAngles);

        try {
            FIGURE_FACTORY.createFigure("Triangle", Color.YELLOW, pointsForMultiAngle2);
        } catch (FigureException e) {
            LOGGER.error(e.getMessage());
        }
    }
}

package com.epam.jwd.projectfigure;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.logic.ClosedFigureLogic;
import com.epam.jwd.projectfigure.logic.NonClosedFigureLogic;
import com.epam.jwd.projectfigure.logic.PointLogic;
import com.epam.jwd.projectfigure.model.impl.ClosedFigure;
import com.epam.jwd.projectfigure.model.impl.NonClosedFigure;
import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.ApplicationContext;
import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.MultiAngle;
import com.epam.jwd.projectfigure.factory.ClosedFigureFactory;
import com.epam.jwd.projectfigure.model.impl.factory.NonClosedFigureFactory;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.NonClosedFigureFactoryImpl;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger(Main.class);
    private final static PointLogic POINT_LOGIC = PointLogic.createInstance();
    private final static NonClosedFigureLogic NON_CLOSED_FIGURE_LOGIC = NonClosedFigureLogic.createInstance();
    private final static ClosedFigureLogic CLOSED_FIGURE_LOGIC = ClosedFigureLogic.createInstance();
    private final static ClosedFigureFactory CLOSED_FIGURE_FACTORY = ApplicationContext.INSTANCE.createClosedFigureFactory();
    private final static NonClosedFigureFactory NON_CLOSED_FIGURE_FACTORY = NonClosedFigureFactoryImpl.createInstance();

    public static void main(String[] args) {
        Point[] points = {NON_CLOSED_FIGURE_FACTORY.createPoint(0, 0), NON_CLOSED_FIGURE_FACTORY.createPoint(0.56, 2.5),
                NON_CLOSED_FIGURE_FACTORY.createPoint(1, 2.25), NON_CLOSED_FIGURE_FACTORY.createPoint(-2.14, -5.48)};

        NonClosedFigure[] lines = new NonClosedFigure[0];
        try {
            lines = new NonClosedFigure[]{NON_CLOSED_FIGURE_FACTORY.createLine(NON_CLOSED_FIGURE_FACTORY.createPoint(0, 0), NON_CLOSED_FIGURE_FACTORY.createPoint(-1.25, 4.78)),
                    NON_CLOSED_FIGURE_FACTORY.createLine(NON_CLOSED_FIGURE_FACTORY.createPoint(-2.21, 0.2), NON_CLOSED_FIGURE_FACTORY.createPoint(6.25, -4.05))};
        } catch (FigureException e) {
            LOGGER.error(e.getMessage());
        }

        ClosedFigure[] triangles = new ClosedFigure[0];
        try {
            triangles = new ClosedFigure[]{CLOSED_FIGURE_FACTORY.createClosedFigure("Triangle", NON_CLOSED_FIGURE_FACTORY.createPoint(0, 0),
                    NON_CLOSED_FIGURE_FACTORY.createPoint(1.5, -2.59), NON_CLOSED_FIGURE_FACTORY.createPoint(3.45, 1.28)),
                    CLOSED_FIGURE_FACTORY.createClosedFigure("Triangle", NON_CLOSED_FIGURE_FACTORY.createPoint(-3.12, 1.5),
                            NON_CLOSED_FIGURE_FACTORY.createPoint(0, 4.45), NON_CLOSED_FIGURE_FACTORY.createPoint(-6.15, -2.03))};
        } catch (FigureException e) {
            LOGGER.error(e.getMessage());
        }

        ClosedFigure[] squares = new ClosedFigure[0];
        try {
            squares = new ClosedFigure[]{CLOSED_FIGURE_FACTORY.createClosedFigure("Square", NON_CLOSED_FIGURE_FACTORY.createPoint(1.1, 2.36),
                    NON_CLOSED_FIGURE_FACTORY.createPoint(-2.0, 3.45), NON_CLOSED_FIGURE_FACTORY.createPoint(-2.95, 3.35),
                    NON_CLOSED_FIGURE_FACTORY.createPoint(4, 0))};
        } catch (FigureException e) {
            LOGGER.error(e.getMessage());
        }

        NON_CLOSED_FIGURE_LOGIC.printInfo(points);
        NON_CLOSED_FIGURE_LOGIC.printInfo(lines);
        CLOSED_FIGURE_LOGIC.printInfo(triangles);
        CLOSED_FIGURE_LOGIC.printInfo(squares);

        Point[] pointsForMultiAngle1 = {NON_CLOSED_FIGURE_FACTORY.createPoint(-3.1, -2), NON_CLOSED_FIGURE_FACTORY.createPoint(0.12, 4.5),
                NON_CLOSED_FIGURE_FACTORY.createPoint(1.85, 1.96), NON_CLOSED_FIGURE_FACTORY.createPoint(1.95, -3.4)};

        Point[] pointsForMultiAngle2 = {NON_CLOSED_FIGURE_FACTORY.createPoint(-20, 20), NON_CLOSED_FIGURE_FACTORY.createPoint(0, 35.78),
                NON_CLOSED_FIGURE_FACTORY.createPoint(15, 20), NON_CLOSED_FIGURE_FACTORY.createPoint(-15, 30),
                NON_CLOSED_FIGURE_FACTORY.createPoint(0, -35.78), NON_CLOSED_FIGURE_FACTORY.createPoint(-20, -20)};

        ClosedFigure[] multiAngles = new MultiAngle[0];
        try {
            multiAngles = new ClosedFigure[] {CLOSED_FIGURE_FACTORY.createClosedFigure("MultiAngle", pointsForMultiAngle1), CLOSED_FIGURE_FACTORY.createClosedFigure("MultiAngle", pointsForMultiAngle2)};
        } catch (FigureException e) {
            LOGGER.error(e.getMessage());
        }
        CLOSED_FIGURE_LOGIC.printInfo(multiAngles);

        try {
            CLOSED_FIGURE_FACTORY.createClosedFigure("Triangle", pointsForMultiAngle2);
        } catch (FigureException e) {
            LOGGER.error(e.getMessage());
        }

    }
}

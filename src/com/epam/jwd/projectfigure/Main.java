package com.epam.jwd.projectfigure;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.logic.FigureLogic;
import com.epam.jwd.projectfigure.model.Color;
import com.epam.jwd.projectfigure.model.impl.Line;
import com.epam.jwd.projectfigure.model.impl.MultiAngle;
import com.epam.jwd.projectfigure.model.impl.Point;
import com.epam.jwd.projectfigure.service.ClosedFigureCrud;
import com.epam.jwd.projectfigure.service.NonClosedFigureCrud;
import com.epam.jwd.projectfigure.service.impl.LineCrudImpl;
import com.epam.jwd.projectfigure.service.impl.MultiAngleCrudImpl;
import com.epam.jwd.projectfigure.specification.ClosedFigureSpecification;
import com.epam.jwd.projectfigure.specification.NonClosedFigureSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger(Main.class);
    private final static FigureLogic FIGURE_LOGIC = FigureLogic.createInstance();
    private final static NonClosedFigureCrud<Line> LINE_CRUD = LineCrudImpl.INSTANCE;
    private final static ClosedFigureCrud<MultiAngle> MULTI_ANGLE_CRUD = MultiAngleCrudImpl.INSTANCE;

    public static void main(String[] args) {
        try {
            LINE_CRUD.create(Color.GREY, new Point(0, 0), new Point(-1.25, 4.78));
            LINE_CRUD.create(Color.BLUE, new Point(-2.21, 0.2), new Point(6.25, -4.05));
        } catch (FigureException e) {
            LOGGER.error(e.getMessage());
        }

        LOGGER.info(LINE_CRUD.findBySpecification(NonClosedFigureSpecification.builder()
                .whereColor(Color.BLUE)
                .whereLineLengthGreaterThan(2.0)
                .build()));

        Point[] pointsForMultiAngle1 = {new Point(-3.1, -2), new Point(0.12, 4.5), new Point(1.85, 1.96),
        new Point(1.95, -3.4)};

        Point[] pointsForMultiAngle2 = {new Point(-5, 9), new Point(0, 8), new Point(2.55, -4),
                new Point(2.0, -2.27), new Point(0.58, -6), new Point(-3.46, -1.05)};

        try {
            MULTI_ANGLE_CRUD.create(Color.RED, pointsForMultiAngle1);
            MULTI_ANGLE_CRUD.create(Color.ORANGE, pointsForMultiAngle2);
        } catch (FigureException e) {
            LOGGER.error(e.getMessage());
        }

        LOGGER.info(MULTI_ANGLE_CRUD.findBySpecification(ClosedFigureSpecification.builder()
                .whereColor(Color.ORANGE)
                .wherePointsQuantityGreaterThan(3)
                .wherePointsQuantityLesserThan(7)
                .whereAreaGreaterThan(15.55)
                .wherePerimeterLesserThan(52.75)
                .build()));
    }
}

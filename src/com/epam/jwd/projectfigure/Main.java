package com.epam.jwd.projectfigure;

import com.epam.jwd.projectfigure.logic.ClosedFigureLogic;
import com.epam.jwd.projectfigure.logic.LineLogic;
import com.epam.jwd.projectfigure.logic.MultiAngleLogic;
import com.epam.jwd.projectfigure.logic.PointLogic;
import com.epam.jwd.projectfigure.logic.SquareLogic;
import com.epam.jwd.projectfigure.logic.TriangleLogic;
import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.MultiAngle;
import com.epam.jwd.projectfigure.model.impl.factory.ClosedFigureFactory;
import com.epam.jwd.projectfigure.model.impl.factory.NonClosedFigureFactory;
import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.ClosedFigureFactoryImpl;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.NonClosedFigureFactoryImpl;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Line;
import com.epam.jwd.projectfigure.model.impl.nonclosedfigureimpl.Point;
import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.Square;
import com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl.Triangle;
import com.epam.jwd.projectfigure.strategy.impl.multianglestrategyimpl.MainMultiAngleStrategy;
import com.epam.jwd.projectfigure.strategy.impl.squarestrategyimpl.MainSquareStrategy;
import com.epam.jwd.projectfigure.strategy.impl.trianglestrategyimpl.AlterTriangleStrategy;
import com.epam.jwd.projectfigure.strategy.impl.trianglestrategyimpl.MainTriangleStrategy;

public class Main {

    private final static PointLogic POINT_LOGIC = new PointLogic();
    private final static LineLogic LINE_LOGIC = new LineLogic();
    private final static ClosedFigureLogic<Triangle> TRIANGLE_LOGIC = new TriangleLogic(POINT_LOGIC);
    private final static ClosedFigureLogic<Square> SQUARE_LOGIC = new SquareLogic(POINT_LOGIC);
    private final static ClosedFigureLogic<MultiAngle> MULTI_ANGLE_LOGIC = new MultiAngleLogic(POINT_LOGIC);
    private final static ClosedFigureFactory CLOSED_FIGURE_FACTORY = ClosedFigureFactoryImpl.createInstance();
    private final static NonClosedFigureFactory NON_CLOSED_FIGURE_FACTORY = NonClosedFigureFactoryImpl.createInstance();

    public static void main(String[] args) {
        Point[] points = {NON_CLOSED_FIGURE_FACTORY.createPoint(0, 0), NON_CLOSED_FIGURE_FACTORY.createPoint(0.56, 2.5),
                NON_CLOSED_FIGURE_FACTORY.createPoint(1, 2.25), NON_CLOSED_FIGURE_FACTORY.createPoint(-2.14, -5.48)};

        Line[] lines = {NON_CLOSED_FIGURE_FACTORY.createLine(NON_CLOSED_FIGURE_FACTORY.createPoint(0, 0), NON_CLOSED_FIGURE_FACTORY.createPoint(-1.25, 4.78)),
                NON_CLOSED_FIGURE_FACTORY.createLine(NON_CLOSED_FIGURE_FACTORY.createPoint(-2.21, 0.2), NON_CLOSED_FIGURE_FACTORY.createPoint(6.25, -4.05))};

        Triangle[] triangles = {CLOSED_FIGURE_FACTORY.createTriangle(NON_CLOSED_FIGURE_FACTORY.createPoint(0, 0),
                NON_CLOSED_FIGURE_FACTORY.createPoint(1.5, -2.59), NON_CLOSED_FIGURE_FACTORY.createPoint(3.45, 1.28),
                MainTriangleStrategy.createInstance()),
                CLOSED_FIGURE_FACTORY.createTriangle(NON_CLOSED_FIGURE_FACTORY.createPoint(-3.12, 1.5),
                        NON_CLOSED_FIGURE_FACTORY.createPoint(0, 4.45), NON_CLOSED_FIGURE_FACTORY.createPoint(-6.15, -2.03),
                        AlterTriangleStrategy.INSTANCE)};

        Square[] squares = {CLOSED_FIGURE_FACTORY.createSquare(NON_CLOSED_FIGURE_FACTORY.createPoint(1.1, 2.36),
                NON_CLOSED_FIGURE_FACTORY.createPoint(-2.0, 3.45), NON_CLOSED_FIGURE_FACTORY.createPoint(-2.95, 3.35),
                NON_CLOSED_FIGURE_FACTORY.createPoint(4, 0), MainSquareStrategy.createInstance())};

        POINT_LOGIC.printInfo(points);
        LINE_LOGIC.printInfo(lines);
        TRIANGLE_LOGIC.printInfo(triangles);
        SQUARE_LOGIC.printInfo(squares);

        Point[] pointsForMultiAngle1 = {NON_CLOSED_FIGURE_FACTORY.createPoint(-3.1, -2), NON_CLOSED_FIGURE_FACTORY.createPoint(0.12, 4.5),
                NON_CLOSED_FIGURE_FACTORY.createPoint(1.85, 1.96), NON_CLOSED_FIGURE_FACTORY.createPoint(1.95, -3.4)};

        Point[] pointsForMultiAngle2 = {NON_CLOSED_FIGURE_FACTORY.createPoint(-20, 20), NON_CLOSED_FIGURE_FACTORY.createPoint(0, 35.78),
                NON_CLOSED_FIGURE_FACTORY.createPoint(15, 20), NON_CLOSED_FIGURE_FACTORY.createPoint(-15, 30),
                NON_CLOSED_FIGURE_FACTORY.createPoint(0, -35.78), NON_CLOSED_FIGURE_FACTORY.createPoint(-20, -20)};

        MultiAngle multiAngle1 = CLOSED_FIGURE_FACTORY.createMultiAngle(MainMultiAngleStrategy.createInstance(), pointsForMultiAngle1);
        MultiAngle multiAngle2 = CLOSED_FIGURE_FACTORY.createMultiAngle(MainMultiAngleStrategy.createInstance(), pointsForMultiAngle2);

        MultiAngle[] multiAngles = {multiAngle1, multiAngle2};
        MULTI_ANGLE_LOGIC.printInfo(multiAngles);
    }
}

package com.epam.jwd;

import com.epam.jwd.logic.LineLogic;
import com.epam.jwd.logic.PointLogic;
import com.epam.jwd.logic.SquareLogic;
import com.epam.jwd.logic.TriangleLogic;
import com.epam.jwd.model.children.Line;
import com.epam.jwd.model.children.Point;
import com.epam.jwd.model.children.Square;
import com.epam.jwd.model.children.Triangle;

public class Main {

    private final static PointLogic POINT_LOGIC = new PointLogic();
    private final static LineLogic LINE_LOGIC = new LineLogic();
    private final static TriangleLogic TRIANGLE_LOGIC = new TriangleLogic(POINT_LOGIC);
    private final static SquareLogic SQUARE_LOGIC = new SquareLogic(POINT_LOGIC);

    public static void main(String[] args) {
        Point[] points = {new Point(), new Point(0.56, 2.5), new Point(1, 2.25), new Point(-2.14, -5.48)};
        Line[] lines = {new Line(new Point(), new Point(-1.25, 4.78)),
                        new Line(new Point(-2.21, 0.2), new Point(6.25, -4.05))};
        Triangle[] triangles = {new Triangle(new Point(), new Point(1.5, -2.59), new Point(3.45, 1.28)),
                                new Triangle(new Point(-3.12, 1.5), new Point(0, 4.45), new Point(-6.15, -2.03))};
        Square[] squares = {new Square(new Point(1.1, 2.36), new Point(-2.0, 3.45), new Point(-2.95, 3.35),
                            new Point(4.0, 0))};

        POINT_LOGIC.printInfo(points);
        LINE_LOGIC.printInfo(lines);
        TRIANGLE_LOGIC.printInfo(triangles);
        SQUARE_LOGIC.printInfo(squares);
    }
}

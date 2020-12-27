package com.epam.jwd.projectfigure.service.impl;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.factory.FigureFactory;
import com.epam.jwd.projectfigure.model.Color;
import com.epam.jwd.projectfigure.model.Figure;
import com.epam.jwd.projectfigure.model.impl.ApplicationContext;
import com.epam.jwd.projectfigure.model.impl.Point;
import com.epam.jwd.projectfigure.model.impl.Square;
import com.epam.jwd.projectfigure.service.ClosedFigureCrud;
import com.epam.jwd.projectfigure.specification.ClosedFigureSpecification;
import com.epam.jwd.projectfigure.storage.FigureStorage;
import com.epam.jwd.projectfigure.storage.impl.SquareStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum SquareCrudImpl implements ClosedFigureCrud<Square> {

    INSTANCE(SquareStorage.INSTANCE);

    private final static Logger LOGGER = LogManager.getLogger(LineCrudImpl.class);

    private final FigureFactory FIGURE_FACTORY = ApplicationContext.INSTANCE.createFigureFactory();
    private final FigureStorage<Square> squareStorage;

    SquareCrudImpl(FigureStorage<Square> squareStorage) {
        this.squareStorage = squareStorage;
    }

    @Override
    public Square create(Color color, Point... points) throws FigureException {
        Square createdFigure = (Square) FIGURE_FACTORY.createFigure("Square", color, points);
        squareStorage.save(createdFigure);
        return createdFigure;
    }

    @Override
    public List<Square> multiCreate(int quantity, Color color, Point... points) throws FigureException {
        List<Square> createdFigures = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            createdFigures.add((Square) FIGURE_FACTORY.createFigure("Square", color, points));
        }
        for (Figure figure : createdFigures) {
            squareStorage.save((Square) figure);
        }
        return createdFigures;
    }

    @Override
    public Optional<Square> find(Square square) {
        return squareStorage.find(square);
    }

    @Override
    public Optional<Square> findById(Long id) {
        return squareStorage.findById(id);
    }

    @Override
    public Square update(Square square) {
        return squareStorage.save(square);
    }

    @Override
    public void delete(Square square) {
        squareStorage.delete(square);
    }

    @Override
    public List<Square> findBySpecification(ClosedFigureSpecification closedFigureSpecification) {
        List<Square> allSquares = squareStorage.findAll();
        if (closedFigureSpecification.getColor() != null) {
            allSquares = allSquares.stream()
                    .filter(square -> square.getColor().equals(closedFigureSpecification.getColor()))
                    .collect(Collectors.toList());
        }
        if (closedFigureSpecification.getGreaterPointsQuantity() != null) {
            allSquares = allSquares.stream()
                    .filter(square -> square.getPoints().length > closedFigureSpecification.getGreaterPointsQuantity())
                    .collect(Collectors.toList());
        }
        if (closedFigureSpecification.getLesserPointsQuantity() != null) {
            allSquares = allSquares.stream()
                    .filter(square -> square.getPoints().length < closedFigureSpecification.getLesserPointsQuantity())
                    .collect(Collectors.toList());
        }
        if (closedFigureSpecification.getGreaterArea() != null) {
            allSquares = allSquares.stream()
                    .filter(square -> square.figureArea() > closedFigureSpecification.getGreaterArea())
                    .collect(Collectors.toList());
        }
        if (closedFigureSpecification.getLesserArea() != null) {
            allSquares = allSquares.stream()
                    .filter(square -> square.figureArea() < closedFigureSpecification.getLesserArea())
                    .collect(Collectors.toList());
        }
        if (closedFigureSpecification.getGreaterPerimeter() != null) {
            allSquares = allSquares.stream()
                    .filter(square -> square.figurePerimeter() > closedFigureSpecification.getGreaterPerimeter())
                    .collect(Collectors.toList());
        }
        if (closedFigureSpecification.getLesserPerimeter() != null) {
            allSquares = allSquares.stream()
                    .filter(square -> square.figurePerimeter() < closedFigureSpecification.getLesserPerimeter())
                    .collect(Collectors.toList());
        }
        return allSquares;
    }
}

package com.epam.jwd.projectfigure.service.impl;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.factory.FigureFactory;
import com.epam.jwd.projectfigure.model.Color;
import com.epam.jwd.projectfigure.model.Figure;
import com.epam.jwd.projectfigure.model.impl.ApplicationContext;
import com.epam.jwd.projectfigure.model.impl.Line;
import com.epam.jwd.projectfigure.model.impl.Point;
import com.epam.jwd.projectfigure.service.NonClosedFigureCrud;
import com.epam.jwd.projectfigure.specification.NonClosedFigureSpecification;
import com.epam.jwd.projectfigure.storage.FigureStorage;
import com.epam.jwd.projectfigure.storage.impl.LineStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum LineCrudImpl implements NonClosedFigureCrud<Line> {

    INSTANCE(LineStorage.INSTANCE);

    private final static Logger LOGGER = LogManager.getLogger(LineCrudImpl.class);

    private final FigureFactory FIGURE_FACTORY = ApplicationContext.INSTANCE.createFigureFactory();
    private final FigureStorage<Line> lineStorage;

    LineCrudImpl(FigureStorage<Line> lineStorage) {
        this.lineStorage = lineStorage;
    }

    @Override
    public Line create(Color color, Point... points) throws FigureException {
        Line createdFigure = (Line) FIGURE_FACTORY.createFigure("Line", color, points);
        lineStorage.save(createdFigure);
        return createdFigure;
    }

    @Override
    public List<Line> multiCreate(int quantity, Color color, Point... points) throws FigureException {
        List<Line> createdFigures = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            createdFigures.add((Line) FIGURE_FACTORY.createFigure("Line", color, points));
        }
        for (Figure figure : createdFigures) {
            lineStorage.save((Line) figure);
        }
        return createdFigures;
    }

    @Override
    public Optional<Line> find(Line line) {
        return lineStorage.find(line);
    }

    @Override
    public Optional<Line> findById(Long id) {
        return lineStorage.findById(id);
    }

    @Override
    public Line update(Line line) {
        return lineStorage.save(line);
    }

    @Override
    public void delete(Line line) {
        lineStorage.delete(line);
    }

    @Override
    public List<Line> findBySpecification(NonClosedFigureSpecification nonClosedFigureSpecification) {
        List<Line> allLines = lineStorage.findAll();
        if (nonClosedFigureSpecification.getColor() != null) {
            allLines = allLines.stream()
                    .filter(line -> line.getColor().equals(nonClosedFigureSpecification.getColor()))
                    .collect(Collectors.toList());
        }
        if (nonClosedFigureSpecification.getGreaterLineLength() != null) {
            allLines = allLines.stream()
                    .filter(line -> line.getPoints()[0].distanceBetweenPoints(line.getPoints()[1]) > nonClosedFigureSpecification.getGreaterLineLength())
                    .collect(Collectors.toList());
        }
        if (nonClosedFigureSpecification.getLesserLineLength() != null) {
            allLines = allLines.stream()
                    .filter(line -> line.getPoints()[0].distanceBetweenPoints(line.getPoints()[1]) < nonClosedFigureSpecification.getLesserLineLength())
                    .collect(Collectors.toList());
        }
        return allLines;
    }
}

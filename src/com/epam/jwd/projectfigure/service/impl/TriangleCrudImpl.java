package com.epam.jwd.projectfigure.service.impl;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.factory.FigureFactory;
import com.epam.jwd.projectfigure.model.Color;
import com.epam.jwd.projectfigure.model.Figure;
import com.epam.jwd.projectfigure.model.impl.ApplicationContext;
import com.epam.jwd.projectfigure.model.impl.Point;
import com.epam.jwd.projectfigure.model.impl.Triangle;
import com.epam.jwd.projectfigure.service.ClosedFigureCrud;
import com.epam.jwd.projectfigure.specification.ClosedFigureSpecification;
import com.epam.jwd.projectfigure.storage.FigureStorage;
import com.epam.jwd.projectfigure.storage.impl.TriangleStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum TriangleCrudImpl implements ClosedFigureCrud<Triangle> {

    INSTANCE(TriangleStorage.INSTANCE);

    private final static Logger LOGGER = LogManager.getLogger(LineCrudImpl.class);

    private final FigureFactory FIGURE_FACTORY = ApplicationContext.INSTANCE.createFigureFactory();
    private final FigureStorage<Triangle> triangleStorage;

    TriangleCrudImpl(FigureStorage<Triangle> triangleStorage) {
        this.triangleStorage = triangleStorage;
    }

    @Override
    public Triangle create(Color color, Point... points) throws FigureException {
        Triangle createdFigure = (Triangle) FIGURE_FACTORY.createFigure("Triangle", color, points);
        triangleStorage.save(createdFigure);
        return createdFigure;
    }

    @Override
    public List<Triangle> multiCreate(int quantity, Color color, Point... points) throws FigureException {
        List<Triangle> createdFigures = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            createdFigures.add((Triangle) FIGURE_FACTORY.createFigure("Triangle", color, points));
        }
        for (Figure figure : createdFigures) {
            triangleStorage.save((Triangle) figure);
        }
        return createdFigures;
    }

    @Override
    public Optional<Triangle> find(Triangle triangle) {
        return triangleStorage.find(triangle);
    }

    @Override
    public Optional<Triangle> findById(Long id) {
        return triangleStorage.findById(id);
    }

    @Override
    public Triangle update(Triangle triangle) {
        return triangleStorage.save(triangle);
    }

    @Override
    public void delete(Triangle triangle) {
        triangleStorage.delete(triangle);
    }

    @Override
    public List<Triangle> findBySpecification(ClosedFigureSpecification closedFigureSpecification) {
        List<Triangle> allTriangles = triangleStorage.findAll();
        if (closedFigureSpecification.getColor() != null) {
            allTriangles = allTriangles.stream()
                    .filter(triangle -> triangle.getColor().equals(closedFigureSpecification.getColor()))
                    .collect(Collectors.toList());
        }
        if (closedFigureSpecification.getGreaterPointsQuantity() != null) {
            allTriangles = allTriangles.stream()
                    .filter(triangle -> triangle.getPoints().length > closedFigureSpecification.getGreaterPointsQuantity())
                    .collect(Collectors.toList());
        }
        if (closedFigureSpecification.getLesserPointsQuantity() != null) {
            allTriangles = allTriangles.stream()
                    .filter(triangle -> triangle.getPoints().length < closedFigureSpecification.getLesserPointsQuantity())
                    .collect(Collectors.toList());
        }
        if (closedFigureSpecification.getGreaterArea() != null) {
            allTriangles = allTriangles.stream()
                    .filter(triangle -> triangle.figureArea() > closedFigureSpecification.getGreaterArea())
                    .collect(Collectors.toList());
        }
        if (closedFigureSpecification.getLesserArea() != null) {
            allTriangles = allTriangles.stream()
                    .filter(triangle -> triangle.figureArea() < closedFigureSpecification.getLesserArea())
                    .collect(Collectors.toList());
        }
        if (closedFigureSpecification.getGreaterPerimeter() != null) {
            allTriangles = allTriangles.stream()
                    .filter(triangle -> triangle.figurePerimeter() > closedFigureSpecification.getGreaterPerimeter())
                    .collect(Collectors.toList());
        }
        if (closedFigureSpecification.getLesserPerimeter() != null) {
            allTriangles = allTriangles.stream()
                    .filter(triangle -> triangle.figurePerimeter() < closedFigureSpecification.getLesserPerimeter())
                    .collect(Collectors.toList());
        }
        return allTriangles;
    }
}

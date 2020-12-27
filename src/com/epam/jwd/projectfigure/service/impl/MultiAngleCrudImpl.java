package com.epam.jwd.projectfigure.service.impl;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.factory.FigureFactory;
import com.epam.jwd.projectfigure.model.Color;
import com.epam.jwd.projectfigure.model.Figure;
import com.epam.jwd.projectfigure.model.impl.ApplicationContext;
import com.epam.jwd.projectfigure.model.impl.MultiAngle;
import com.epam.jwd.projectfigure.model.impl.Point;
import com.epam.jwd.projectfigure.service.ClosedFigureCrud;
import com.epam.jwd.projectfigure.specification.ClosedFigureSpecification;
import com.epam.jwd.projectfigure.storage.FigureStorage;
import com.epam.jwd.projectfigure.storage.impl.MultiAngleStorage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum MultiAngleCrudImpl implements ClosedFigureCrud<MultiAngle> {

    INSTANCE(MultiAngleStorage.INSTANCE);

    private final static Logger LOGGER = LogManager.getLogger(LineCrudImpl.class);

    private final FigureFactory FIGURE_FACTORY = ApplicationContext.INSTANCE.createFigureFactory();
    private final FigureStorage<MultiAngle> multiAngleStorage;

    MultiAngleCrudImpl(FigureStorage<MultiAngle> multiAngleStorage) {
        this.multiAngleStorage = multiAngleStorage;
    }


    @Override
    public MultiAngle create(Color color, Point... points) throws FigureException {
        MultiAngle createdFigure = (MultiAngle) FIGURE_FACTORY.createFigure("MultiAngle", color, points);
        multiAngleStorage.save(createdFigure);
        return createdFigure;
    }

    @Override
    public List<MultiAngle> multiCreate(int quantity, Color color, Point... points) throws FigureException {
        List<MultiAngle> createdFigures = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            createdFigures.add((MultiAngle) FIGURE_FACTORY.createFigure("MultiAngle", color, points));
        }
        for (Figure figure : createdFigures) {
            multiAngleStorage.save((MultiAngle) figure);
        }
        return createdFigures;
    }

    @Override
    public Optional<MultiAngle> find(MultiAngle multiAngle) {
        return multiAngleStorage.find(multiAngle);
    }

    @Override
    public Optional<MultiAngle> findById(Long id) {
        return multiAngleStorage.findById(id);
    }

    @Override
    public MultiAngle update(MultiAngle multiAngle) {
        return multiAngleStorage.save(multiAngle);
    }

    @Override
    public void delete(MultiAngle multiAngle) {
        multiAngleStorage.delete(multiAngle);
    }

    @Override
    public List<MultiAngle> findBySpecification(ClosedFigureSpecification closedFigureSpecification) {
        List<MultiAngle> allMultiAngles = multiAngleStorage.findAll();
        if (closedFigureSpecification.getColor() != null) {
            allMultiAngles = allMultiAngles.stream()
                    .filter(multiAngle -> multiAngle.getColor().equals(closedFigureSpecification.getColor()))
                    .collect(Collectors.toList());
        }
        if (closedFigureSpecification.getGreaterPointsQuantity() != null) {
            allMultiAngles = allMultiAngles.stream()
                    .filter(multiAngle -> multiAngle.getPoints().length > closedFigureSpecification.getGreaterPointsQuantity())
                    .collect(Collectors.toList());
        }
        if (closedFigureSpecification.getLesserPointsQuantity() != null) {
            allMultiAngles = allMultiAngles.stream()
                    .filter(multiAngle -> multiAngle.getPoints().length < closedFigureSpecification.getLesserPointsQuantity())
                    .collect(Collectors.toList());
        }
        if (closedFigureSpecification.getGreaterArea() != null) {
            allMultiAngles = allMultiAngles.stream()
                    .filter(multiAngle -> multiAngle.figureArea() > closedFigureSpecification.getGreaterArea())
                    .collect(Collectors.toList());
        }
        if (closedFigureSpecification.getLesserArea() != null) {
            allMultiAngles = allMultiAngles.stream()
                    .filter(multiAngle -> multiAngle.figureArea() < closedFigureSpecification.getLesserArea())
                    .collect(Collectors.toList());
        }
        if (closedFigureSpecification.getGreaterPerimeter() != null) {
            allMultiAngles = allMultiAngles.stream()
                    .filter(multiAngle -> multiAngle.figurePerimeter() > closedFigureSpecification.getGreaterPerimeter())
                    .collect(Collectors.toList());
        }
        if (closedFigureSpecification.getLesserPerimeter() != null) {
            allMultiAngles = allMultiAngles.stream()
                    .filter(multiAngle -> multiAngle.figurePerimeter() < closedFigureSpecification.getLesserPerimeter())
                    .collect(Collectors.toList());
        }
        return allMultiAngles;
    }
}

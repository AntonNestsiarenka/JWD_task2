package com.epam.jwd.projectfigure.service.impl;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.factory.FigureFactory;
import com.epam.jwd.projectfigure.model.Color;
import com.epam.jwd.projectfigure.model.Figure;
import com.epam.jwd.projectfigure.model.impl.ApplicationContext;
import com.epam.jwd.projectfigure.model.impl.Point;
import com.epam.jwd.projectfigure.service.FigureCrud;
import com.epam.jwd.projectfigure.storage.FigureStorage;
import com.epam.jwd.projectfigure.storage.impl.FigureStorageImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public enum FigureCrudImpl implements FigureCrud {

    INSTANCE;

    private final static Logger LOGGER = LogManager.getLogger(FigureCrudImpl.class);

    private final static FigureFactory FIGURE_FACTORY = ApplicationContext.INSTANCE.createFigureFactory();
    private final static FigureStorage FIGURE_STORAGE = FigureStorageImpl.INSTANCE;

    @Override
    public Figure create(String figureName, Color color, Point... points) throws FigureException {
        Figure createdFigure = FIGURE_FACTORY.createFigure(figureName, color, points);
        FIGURE_STORAGE.save(createdFigure);
        return createdFigure;
    }

    @Override
    public List<Figure> multiCreate(int quantity, String figureName, Color color, Point... points) throws FigureException {
        List<Figure> createdFigures = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            createdFigures.add(FIGURE_FACTORY.createFigure(figureName, color, points));
        }
        for (Figure figure : createdFigures) {
            FIGURE_STORAGE.save(figure);
        }
        return createdFigures;
    }

    @Override
    public Optional<Figure> find(Figure figure) {
        return FIGURE_STORAGE.find(figure);
    }

    @Override
    public Optional<Figure> findById(Long id) {
        return FIGURE_STORAGE.findById(id);
    }

    @Override
    public Figure update(Figure figure) {
        return FIGURE_STORAGE.save(figure);
    }

    @Override
    public void delete(Figure figure) {
        FIGURE_STORAGE.delete(figure);
    }
}

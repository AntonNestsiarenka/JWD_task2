package com.epam.jwd.projectfigure.service;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.model.Color;
import com.epam.jwd.projectfigure.model.Figure;
import com.epam.jwd.projectfigure.model.impl.Point;
import java.util.List;
import java.util.Optional;

public interface FigureCrud {

    Figure create(String figureName, Color color, Point... points) throws FigureException;
    List<Figure> multiCreate(int quantity, String figureName, Color color, Point... points) throws FigureException;
    Optional<Figure> find(Figure figure);
    Optional<Figure> findById(Long id);
    Figure update(Figure figure);
    void delete(Figure figure);
}

package com.epam.jwd.projectfigure.service;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.model.Color;
import com.epam.jwd.projectfigure.model.Figure;
import com.epam.jwd.projectfigure.model.impl.Point;
import java.util.List;
import java.util.Optional;

public interface FigureCrud<T extends Figure> {

    T create(Color color, Point... points) throws FigureException;
    List<T> multiCreate(int quantity, Color color, Point... points) throws FigureException;
    Optional<T> find(T figure);
    Optional<T> findById(Long id);
    T update(T figure);
    void delete(T figure);
}

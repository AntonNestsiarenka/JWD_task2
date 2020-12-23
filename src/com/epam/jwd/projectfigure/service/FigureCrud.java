package com.epam.jwd.projectfigure.service;

import com.epam.jwd.projectfigure.model.Figure;
import java.util.List;
import java.util.Optional;

public interface FigureCrud<T> {

    Optional<T> findById(Long id);
    List<T> findAll();
    T create(Figure figure);
    T update(Figure figure);
    void deleteById(Long id);
}

package com.epam.jwd.projectfigure.storage;

import com.epam.jwd.projectfigure.model.Figure;

import java.util.List;
import java.util.Optional;

public interface FigureStorage<T extends Figure> {

    Optional<T> findById(Long id);
    List<T> findAll();
    void deleteById(Long id);
    void deleteAll();
    T save(T figure);
    List<T> findBySpecification(Specification specification);
}

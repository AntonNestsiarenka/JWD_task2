package com.epam.jwd.projectfigure.storage;

import com.epam.jwd.projectfigure.model.Figure;
import java.util.List;
import java.util.Optional;

public interface FigureStorage<T extends Figure> {

    Optional<T> findById(Long id);
    Optional<T> find(T figure);
    List<T> findAll();
    void deleteById(Long id);
    void delete(T figure);
    void deleteAll();
    T save(T figure);
}

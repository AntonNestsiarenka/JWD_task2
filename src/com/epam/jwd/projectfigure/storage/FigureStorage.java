package com.epam.jwd.projectfigure.storage;

import com.epam.jwd.projectfigure.model.Figure;
import java.util.List;
import java.util.Optional;

public interface FigureStorage {

    Optional<Figure> findById(Long id);
    Optional<Figure> find(Figure figure);
    List<Figure> findAll();
    void deleteById(Long id);
    void delete(Figure figure);
    void deleteAll();
    Figure save(Figure figure);
}

package com.epam.jwd.projectfigure.storage.impl;

import com.epam.jwd.projectfigure.model.Figure;
import com.epam.jwd.projectfigure.storage.FigureStorage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public enum FigureStorageImpl implements FigureStorage {

    INSTANCE;

    private static final List<Figure> STORAGE = new ArrayList<>();

    @Override
    public Optional<Figure> findById(Long id) {
        return STORAGE.stream().filter(figure -> figure.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Figure> find(Figure figure) {
        int index = STORAGE.indexOf(figure);
        if (index >= 0) {
            return Optional.of(STORAGE.get(index));
        }
        return Optional.empty();
    }

    @Override
    public List<Figure> findAll() {
        return new ArrayList<>(STORAGE);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Figure> foundFigure = STORAGE.stream().filter(figure -> figure.getId().equals(id)).findFirst();
        foundFigure.ifPresent(STORAGE::remove);
    }

    @Override
    public void delete(Figure figure) {
        STORAGE.remove(figure);
    }

    @Override
    public void deleteAll() {
        STORAGE.clear();
    }

    @Override
    public Figure save(Figure figure) {
        int index = STORAGE.indexOf(figure);
        if (index >= 0) {
            STORAGE.set(index, figure);
        }
        STORAGE.add(figure);
        return figure;
    }
}

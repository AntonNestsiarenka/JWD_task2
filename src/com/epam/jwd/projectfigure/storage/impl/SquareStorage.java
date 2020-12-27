package com.epam.jwd.projectfigure.storage.impl;

import com.epam.jwd.projectfigure.model.impl.Square;
import com.epam.jwd.projectfigure.storage.FigureStorage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public enum SquareStorage implements FigureStorage<Square> {

    INSTANCE;

    private static final List<Square> STORAGE = new ArrayList<>();


    @Override
    public Optional<Square> findById(Long id) {
        return STORAGE.stream().filter(square -> square.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Square> find(Square square) {
        int index = STORAGE.indexOf(square);
        if (index >= 0) {
            return Optional.of(STORAGE.get(index));
        }
        return Optional.empty();
    }

    @Override
    public List<Square> findAll() {
        return new ArrayList<>(STORAGE);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Square> foundFigure = STORAGE.stream().filter(square -> square.getId().equals(id)).findFirst();
        foundFigure.ifPresent(STORAGE::remove);
    }

    @Override
    public void delete(Square square) {
        STORAGE.remove(square);
    }

    @Override
    public void deleteAll() {
        STORAGE.clear();
    }

    @Override
    public Square save(Square square) {
        int index = STORAGE.indexOf(square);
        if (index >= 0) {
            STORAGE.set(index, square);
        }
        STORAGE.add(square);
        return square;
    }
}

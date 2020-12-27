package com.epam.jwd.projectfigure.storage.impl;

import com.epam.jwd.projectfigure.model.impl.Line;
import com.epam.jwd.projectfigure.storage.FigureStorage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public enum LineStorage implements FigureStorage<Line> {

    INSTANCE;

    private static final List<Line> STORAGE = new ArrayList<>();

    @Override
    public Optional<Line> findById(Long id) {
        return STORAGE.stream().filter(line -> line.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Line> find(Line line) {
        int index = STORAGE.indexOf(line);
        if (index >= 0) {
            return Optional.of(STORAGE.get(index));
        }
        return Optional.empty();
    }

    @Override
    public List<Line> findAll() {
        return new ArrayList<>(STORAGE);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Line> foundFigure = STORAGE.stream().filter(line -> line.getId().equals(id)).findFirst();
        foundFigure.ifPresent(STORAGE::remove);
    }

    @Override
    public void delete(Line line) {
        STORAGE.remove(line);
    }

    @Override
    public void deleteAll() {
        STORAGE.clear();
    }

    @Override
    public Line save(Line line) {
        int index = STORAGE.indexOf(line);
        if (index >= 0) {
            STORAGE.set(index, line);
        }
        STORAGE.add(line);
        return line;
    }
}

package com.epam.jwd.projectfigure.storage.impl;

import com.epam.jwd.projectfigure.model.impl.Line;
import com.epam.jwd.projectfigure.storage.FigureStorage;
import java.util.*;

public class LineStorage implements FigureStorage<Line> {

    private static final List<Line> STORAGE = new ArrayList<>();

    @Override
    public Optional<Line> findById(Long id) {
        if (id == null) {
            return Optional.empty();
        }
        return STORAGE.stream().filter(line -> line.getId().equals(id)).findFirst();
    }

    @Override
    public List<Line> findAll() {
        return Collections.unmodifiableList(STORAGE);
    }

    @Override
    public void deleteById(Long id) {
        Line foundLine = STORAGE.stream().filter(line -> line.getId().equals(id)).findFirst();
        STORAGE.remove(foundLine);
    }

    @Override
    public void deleteAll() {
        STORAGE.clear();
    }

    @Override
    public Line save(Line figure) {
        STORAGE.add(figure);
        return null;
    }

    @Override
    public List<Line> findBySpecification(Specification specification) {
        return null;
    }
}

package com.epam.jwd.projectfigure.storage.impl;

import com.epam.jwd.projectfigure.model.impl.Triangle;
import com.epam.jwd.projectfigure.storage.FigureStorage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public enum TriangleStorage implements FigureStorage<Triangle> {

    INSTANCE;

    private static final List<Triangle> STORAGE = new ArrayList<>();

    @Override
    public Optional<Triangle> findById(Long id) {
        return STORAGE.stream().filter(triangle -> triangle.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Triangle> find(Triangle triangle) {
        int index = STORAGE.indexOf(triangle);
        if (index >= 0) {
            return Optional.of(STORAGE.get(index));
        }
        return Optional.empty();
    }

    @Override
    public List<Triangle> findAll() {
        return new ArrayList<>(STORAGE);
    }

    @Override
    public void deleteById(Long id) {
        Optional<Triangle> foundFigure = STORAGE.stream().filter(triangle -> triangle.getId().equals(id)).findFirst();
        foundFigure.ifPresent(STORAGE::remove);
    }

    @Override
    public void delete(Triangle triangle) {
        STORAGE.remove(triangle);
    }

    @Override
    public void deleteAll() {
        STORAGE.clear();
    }

    @Override
    public Triangle save(Triangle triangle) {
        int index = STORAGE.indexOf(triangle);
        if (index >= 0) {
            STORAGE.set(index, triangle);
        }
        STORAGE.add(triangle);
        return triangle;
    }
}

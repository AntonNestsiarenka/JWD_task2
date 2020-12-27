package com.epam.jwd.projectfigure.storage.impl;

import com.epam.jwd.projectfigure.model.impl.MultiAngle;
import com.epam.jwd.projectfigure.storage.FigureStorage;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public enum MultiAngleStorage implements FigureStorage<MultiAngle> {

    INSTANCE;

    private static final List<MultiAngle> STORAGE = new ArrayList<>();


    @Override
    public Optional<MultiAngle> findById(Long id) {
        return STORAGE.stream().filter(multiAngle -> multiAngle.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<MultiAngle> find(MultiAngle multiAngle) {
        int index = STORAGE.indexOf(multiAngle);
        if (index >= 0) {
            return Optional.of(STORAGE.get(index));
        }
        return Optional.empty();
    }

    @Override
    public List<MultiAngle> findAll() {
        return new ArrayList<>(STORAGE);
    }

    @Override
    public void deleteById(Long id) {
        Optional<MultiAngle> foundFigure = STORAGE.stream().filter(multiAngle -> multiAngle.getId().equals(id)).findFirst();
        foundFigure.ifPresent(STORAGE::remove);
    }

    @Override
    public void delete(MultiAngle multiAngle) {
        STORAGE.remove(multiAngle);
    }

    @Override
    public void deleteAll() {
        STORAGE.clear();
    }

    @Override
    public MultiAngle save(MultiAngle multiAngle) {
        int index = STORAGE.indexOf(multiAngle);
        if (index >= 0) {
            STORAGE.set(index, multiAngle);
        }
        STORAGE.add(multiAngle);
        return multiAngle;
    }
}

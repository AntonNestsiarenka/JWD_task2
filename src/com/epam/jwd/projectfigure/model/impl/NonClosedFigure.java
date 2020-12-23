package com.epam.jwd.projectfigure.model.impl;

import com.epam.jwd.projectfigure.model.Color;
import com.epam.jwd.projectfigure.model.Figure;

public abstract class NonClosedFigure extends Figure {

    public NonClosedFigure(Long id, Color color) {
        super(id, color);
    }
}

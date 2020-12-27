package com.epam.jwd.projectfigure.service;

import com.epam.jwd.projectfigure.model.impl.ClosedFigure;
import com.epam.jwd.projectfigure.specification.ClosedFigureSpecification;
import java.util.List;

public interface ClosedFigureCrud<T extends ClosedFigure> extends FigureCrud<T> {

    public List<T> findBySpecification(ClosedFigureSpecification nonClosedFigureSpecification);
}

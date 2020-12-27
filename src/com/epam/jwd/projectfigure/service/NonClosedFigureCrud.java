package com.epam.jwd.projectfigure.service;

import com.epam.jwd.projectfigure.model.impl.NonClosedFigure;
import com.epam.jwd.projectfigure.specification.NonClosedFigureSpecification;
import java.util.List;

public interface NonClosedFigureCrud<T extends NonClosedFigure> extends FigureCrud<T> {

    public List<T> findBySpecification(NonClosedFigureSpecification nonClosedFigureSpecification);
}

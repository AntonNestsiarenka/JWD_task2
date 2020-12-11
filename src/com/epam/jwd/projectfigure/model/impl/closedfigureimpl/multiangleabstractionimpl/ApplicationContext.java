package com.epam.jwd.projectfigure.model.impl.closedfigureimpl.multiangleabstractionimpl;

import com.epam.jwd.projectfigure.factory.ClosedFigureFactory;
import com.epam.jwd.projectfigure.factory.PostProcessingFactory;

public enum ApplicationContext {

    INSTANCE;

    public ClosedFigureFactory createClosedFigureFactory() {
        return new PostProcessingFactory(ClosedFigureFactoryImpl.createInstance());
    }
}

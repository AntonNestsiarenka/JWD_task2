package com.epam.jwd.projectfigure.model.impl;

import com.epam.jwd.projectfigure.factory.FigureFactory;
import com.epam.jwd.projectfigure.factory.PostProcessingFactory;

public enum ApplicationContext {

    INSTANCE;

    public FigureFactory createFigureFactory() {
        return new PostProcessingFactory(FigureFactoryImpl.createInstance());
    }
}

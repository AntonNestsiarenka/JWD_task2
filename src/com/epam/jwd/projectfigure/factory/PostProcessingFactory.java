package com.epam.jwd.projectfigure.factory;

import com.epam.jwd.projectfigure.exception.FigureException;
import com.epam.jwd.projectfigure.model.Figure;
import com.epam.jwd.projectfigure.model.impl.Point;
import com.epam.jwd.projectfigure.service.FigurePostProcessor;
import com.epam.jwd.projectfigure.service.impl.FigurePostProcessorImpl;
import java.util.ArrayList;
import java.util.List;

public class PostProcessingFactory extends FigureFactoryDecorator {

    private final List<FigurePostProcessor> figurePostProcessors = new ArrayList<>();

    {
        figurePostProcessors.add(new FigurePostProcessorImpl());
    }

    public PostProcessingFactory(FigureFactory figureFactory) {
        super(figureFactory);
    }

    @Override
    public Figure createFigure(String figureName, Point... points) throws FigureException {
        Figure figure = super.createFigure(figureName, points);
        for (FigurePostProcessor figurePostProcessor : figurePostProcessors) {
            figure = figurePostProcessor.process(figure);
        }
        return figure;
    }
}

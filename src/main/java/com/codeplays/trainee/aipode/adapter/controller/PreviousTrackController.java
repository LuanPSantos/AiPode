package com.codeplays.trainee.aipode.adapter.controller;

import com.codeplays.trainee.aipode.adapter.gateway.TrackFileSystemGateway;
import com.codeplays.trainee.aipode.adapter.presenter.GetPreviousTrackPresenter;
import com.codeplays.trainee.aipode.app.usecase.previoustrack.GetPreviousTrackInputPort;
import com.codeplays.trainee.aipode.app.usecase.previoustrack.GetPreviousTrackOutputPort;
import com.codeplays.trainee.aipode.app.usecase.previoustrack.GetPreviousTrackUseCase;

import static com.codeplays.trainee.aipode.adapter.presenter.GetPreviousTrackPresenter.*;

public class PreviousTrackController {

    private final GetPreviousTrackInputPort useCase;
    private final GetPreviousTrackOutputPort<GetPreviousTrackViewModel> presenter;

    public PreviousTrackController() {
        this.presenter = new GetPreviousTrackPresenter();
        this.useCase = new GetPreviousTrackUseCase(new TrackFileSystemGateway(), this.presenter);
    }

    public GetPreviousTrackViewModel getPreviousTrack() {
        useCase.getPreviousTrack();

        return presenter.toViewModel();
    }
}

package com.codeplays.trainee.aipode.adapter.controller;

import com.codeplays.trainee.aipode.adapter.gateway.TrackFileSystemGateway;
import com.codeplays.trainee.aipode.adapter.presenter.GetNextTrackPresenter;
import com.codeplays.trainee.aipode.app.usecase.nexttrack.GetNextTrackInputPort;
import com.codeplays.trainee.aipode.app.usecase.nexttrack.GetNextTrackOutputPort;
import com.codeplays.trainee.aipode.app.usecase.nexttrack.GetNextTrackUseCase;

import static com.codeplays.trainee.aipode.adapter.presenter.GetNextTrackPresenter.*;

public class NextTrackController {

    private final GetNextTrackInputPort useCase;
    private final GetNextTrackOutputPort<GetNextTrackViewModel> presenter;

    public NextTrackController() {
        this.presenter = new GetNextTrackPresenter();
        this.useCase = new GetNextTrackUseCase(new TrackFileSystemGateway(), this.presenter);
    }

    public GetNextTrackViewModel getNextTrack() {
        useCase.getNextTrack();

        return presenter.toViewModel();
    }
}

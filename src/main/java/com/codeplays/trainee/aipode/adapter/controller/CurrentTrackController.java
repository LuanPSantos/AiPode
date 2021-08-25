package com.codeplays.trainee.aipode.adapter.controller;

import com.codeplays.trainee.aipode.app.usecase.currenttrack.GetCurrentTrackInputPort;
import com.codeplays.trainee.aipode.app.usecase.currenttrack.GetCurrentTrackOutputPort;
import com.codeplays.trainee.aipode.adapter.presenter.GetCurrentTrackPresenter;
import com.codeplays.trainee.aipode.adapter.presenter.GetCurrentTrackPresenter.GetCurrentTrackViewModel;
import com.codeplays.trainee.aipode.adapter.gateway.TrackFileSystemGateway;
import com.codeplays.trainee.aipode.app.usecase.currenttrack.GetCurrentTrackUseCase;

public class CurrentTrackController {

    private final GetCurrentTrackInputPort useCase;
    private final GetCurrentTrackOutputPort<GetCurrentTrackViewModel> presenter;

    public CurrentTrackController() {
        this.presenter = new GetCurrentTrackPresenter();
        this.useCase = new GetCurrentTrackUseCase(new TrackFileSystemGateway(), presenter);
    }

    public GetCurrentTrackViewModel getCurrentTrack() {

        useCase.getCurrentTrack();

        return presenter.toViewModel();
    }
}

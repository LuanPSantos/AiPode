package com.codeplays.trainee.aipode.app.usecase.previoustrack;

import com.codeplays.trainee.aipode.app.usecase.previoustrack.GetPreviousTrackOutputPort.ResponseModel;
import com.codeplays.trainee.aipode.domain.track.gateway.TrackGateway;
import com.codeplays.trainee.aipode.domain.track.model.Track;

public class GetPreviousTrackUseCase implements GetPreviousTrackInputPort {

    private final TrackGateway trackGateway;
    private final GetPreviousTrackOutputPort<?> presenter;

    public GetPreviousTrackUseCase(TrackGateway trackGateway, GetPreviousTrackOutputPort<?> presenter) {
        this.trackGateway = trackGateway;
        this.presenter = presenter;
    }

    @Override
    public void getPreviousTrack() {
        Track track = trackGateway.previousTrack();

        presenter.setOutputModel(new ResponseModel(track));
    }
}

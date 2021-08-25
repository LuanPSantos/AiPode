package com.codeplays.trainee.aipode.app.usecase.currenttrack;

import com.codeplays.trainee.aipode.app.usecase.currenttrack.GetCurrentTrackOutputPort.ResponseModel;
import com.codeplays.trainee.aipode.domain.track.model.Track;
import com.codeplays.trainee.aipode.domain.track.gateway.TrackGateway;

public class GetCurrentTrackUseCase implements GetCurrentTrackInputPort {

    private final TrackGateway trackGateway;
    private final GetCurrentTrackOutputPort<?> outputPort;

    public GetCurrentTrackUseCase(TrackGateway trackGateway, GetCurrentTrackOutputPort<?> outputBoundary) {
        this.trackGateway = trackGateway;
        this.outputPort = outputBoundary;
    }

    @Override
    public void getCurrentTrack() {
        Track track = trackGateway.currentTrack();

        outputPort.setOutputModel(new ResponseModel(track));
    }
}

package com.codeplays.trainee.aipode.app.usecase.nexttrack;

import com.codeplays.trainee.aipode.domain.track.gateway.TrackGateway;
import com.codeplays.trainee.aipode.domain.track.model.Track;

public class GetNextTrackUseCase implements GetNextTrackInputPort {

    private final TrackGateway trackGateway;
    private final GetNextTrackOutputPort<?> outputPort;

    public GetNextTrackUseCase(TrackGateway trackGateway, GetNextTrackOutputPort<?> outputPort) {
        this.trackGateway = trackGateway;
        this.outputPort = outputPort;
    }

    @Override
    public void getNextTrack() {
        Track track = trackGateway.nextTrack();

        outputPort.setOutputModel(new GetNextTrackOutputPort.ResponseModel(track));
    }

    public static class Output {
        private final Track track;

        Output(Track track) {
            this.track = track;
        }

        public Track getTrack() {
            return track;
        }
    }
}

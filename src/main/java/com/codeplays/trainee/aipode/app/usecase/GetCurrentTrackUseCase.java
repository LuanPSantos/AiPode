package com.codeplays.trainee.aipode.app.usecase;

import com.codeplays.trainee.aipode.domain.track.model.Track;
import com.codeplays.trainee.aipode.domain.track.gateway.TrackGateway;

public class GetCurrentTrackUseCase {

    private final TrackGateway trackGateway;

    public GetCurrentTrackUseCase(TrackGateway trackGateway) {
        this.trackGateway = trackGateway;
    }

    public Output execute() {
        Track track = trackGateway.currentTrack();

        return new Output(track);
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

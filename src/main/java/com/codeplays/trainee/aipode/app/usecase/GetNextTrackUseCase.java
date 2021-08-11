package com.codeplays.trainee.aipode.app.usecase;

import com.codeplays.trainee.aipode.domain.track.gateway.TrackGateway;
import com.codeplays.trainee.aipode.domain.track.model.Track;

public class GetNextTrackUseCase {

    private final TrackGateway trackGateway;

    public GetNextTrackUseCase(TrackGateway trackGateway) {
        this.trackGateway = trackGateway;
    }

    public Output execute() {
        Track track = trackGateway.nextTrack();

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

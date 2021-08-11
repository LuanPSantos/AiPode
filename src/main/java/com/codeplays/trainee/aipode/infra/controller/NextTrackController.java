package com.codeplays.trainee.aipode.infra.controller;

import com.codeplays.trainee.aipode.infra.gateway.TrackFileSystemGateway;
import com.codeplays.trainee.aipode.domain.track.gateway.TrackGateway;
import com.codeplays.trainee.aipode.app.usecase.GetNextTrackUseCase;
import javafx.scene.media.Media;

public class NextTrackController {

    private final GetNextTrackUseCase getNextTrackUseCase;

    public NextTrackController() {
        TrackGateway trackGateway = new TrackFileSystemGateway();

        this.getNextTrackUseCase = new GetNextTrackUseCase(trackGateway);
    }

    public NextTrackResponse getNextTrack() {

        GetNextTrackUseCase.Output output = getNextTrackUseCase.execute();

        return new NextTrackResponse(new Media(output.getTrack().getSourceLocation().toString()));
    }

    public static class NextTrackResponse {
        private final Media media;

        public NextTrackResponse(Media media) {
            this.media = media;
        }

        public Media getMedia() {
            return media;
        }
    }
}

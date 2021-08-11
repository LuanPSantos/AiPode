package com.codeplays.trainee.aipode.infra.controller;

import com.codeplays.trainee.aipode.infra.gateway.TrackFileSystemGateway;
import com.codeplays.trainee.aipode.domain.track.gateway.TrackGateway;
import com.codeplays.trainee.aipode.app.usecase.GetPreviousTrackUseCase;
import com.codeplays.trainee.aipode.app.usecase.GetPreviousTrackUseCase.Output;
import javafx.scene.media.Media;

public class PreviousTrackController {

    private final GetPreviousTrackUseCase getPreviousTrackUseCase;

    public PreviousTrackController() {
        TrackGateway trackGateway = new TrackFileSystemGateway();
        this.getPreviousTrackUseCase = new GetPreviousTrackUseCase(trackGateway);
    }

    public PreviousTrackResponse getPreviousTrack() {
        Output output = getPreviousTrackUseCase.execute();

        return new PreviousTrackResponse(new Media(output.getTrack().getSourceLocation().toString()));
    }

    public static class PreviousTrackResponse {
        private final Media media;

        public PreviousTrackResponse(Media media) {
            this.media = media;
        }

        public Media getMedia() {
            return media;
        }
    }
}

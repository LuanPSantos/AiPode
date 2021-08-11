package com.codeplays.trainee.aipode.infra.controller;

import com.codeplays.trainee.aipode.infra.gateway.TrackFileSystemGateway;
import com.codeplays.trainee.aipode.domain.track.gateway.TrackGateway;
import com.codeplays.trainee.aipode.app.usecase.GetCurrentTrackUseCase;
import com.codeplays.trainee.aipode.app.usecase.GetCurrentTrackUseCase.Output;
import javafx.scene.media.Media;

public class CurrentTrackController {

    private final GetCurrentTrackUseCase getCurrentTrackUseCase;

    public CurrentTrackController() {
        TrackGateway trackGateway = new TrackFileSystemGateway();
        this.getCurrentTrackUseCase = new GetCurrentTrackUseCase(trackGateway);
    }

    public CurrentTrackResponse getCurrentTrack() {

        Output output = getCurrentTrackUseCase.execute();

        return new CurrentTrackResponse(new Media(output.getTrack().getSourceLocation().toString()));
    }

    public static class CurrentTrackResponse {
        private final Media media;

        public CurrentTrackResponse(Media media) {
            this.media = media;
        }

        public Media getMedia() {
            return media;
        }
    }
}

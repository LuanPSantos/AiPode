package com.codeplays.trainee.aipode.infra.view;

import com.codeplays.trainee.aipode.infra.view.mediaplayer.MediaPlayerManager;
import com.codeplays.trainee.aipode.infra.controller.CurrentTrackController;
import com.codeplays.trainee.aipode.infra.controller.CurrentTrackController.CurrentTrackResponse;
import com.codeplays.trainee.aipode.infra.controller.NextTrackController;
import com.codeplays.trainee.aipode.infra.controller.NextTrackController.NextTrackResponse;
import com.codeplays.trainee.aipode.infra.controller.PreviousTrackController;
import com.codeplays.trainee.aipode.infra.controller.PreviousTrackController.PreviousTrackResponse;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.media.Media;

public class MediaPlayerView {

    private final NextTrackController nextTrackController;
    private final CurrentTrackController currentTrackController;
    private final PreviousTrackController previousTrackController;

    @FXML
    private Label display;

    private final MediaPlayerManager mediaPlayerManager;

    public MediaPlayerView() {
        nextTrackController = new NextTrackController();
        currentTrackController = new CurrentTrackController();
        previousTrackController = new PreviousTrackController();

        mediaPlayerManager = new MediaPlayerManager();
    }

    @FXML
    protected void initialize() {
        CurrentTrackResponse response = currentTrackController.getCurrentTrack();

        setNewMedia(response.getMedia());
    }

    @FXML
    protected void onPlayPause() {
        mediaPlayerManager.playPauseCurrentMedia();
    }

    @FXML
    public void onNext() {
        NextTrackResponse response = nextTrackController.getNextTrack();

        setNewMedia(response.getMedia());
    }

    @FXML
    public void onPrevious() {
        PreviousTrackResponse response = previousTrackController.getPreviousTrack();

        setNewMedia(response.getMedia());
    }

    private void setNewMedia(Media media) {
        mediaPlayerManager.playNewMedia(media);

        mediaPlayerManager.onCurrentMediaEnded(this::onNext);
        mediaPlayerManager.onMediaInformationChanged((mediaPlayerViewModel ->
                display.setText(mediaPlayerViewModel.getTitle())
        ));
    }
}
package com.codeplays.trainee.aipode.view;

import com.codeplays.trainee.aipode.adapter.presenter.GetCurrentTrackPresenter.GetCurrentTrackViewModel;
import com.codeplays.trainee.aipode.adapter.presenter.GetNextTrackPresenter.GetNextTrackViewModel;
import com.codeplays.trainee.aipode.adapter.presenter.GetPreviousTrackPresenter;
import com.codeplays.trainee.aipode.adapter.presenter.GetPreviousTrackPresenter.GetPreviousTrackViewModel;
import com.codeplays.trainee.aipode.view.mediaplayer.MediaPlayerManager;
import com.codeplays.trainee.aipode.adapter.controller.CurrentTrackController;
import com.codeplays.trainee.aipode.adapter.controller.NextTrackController;
import com.codeplays.trainee.aipode.adapter.controller.PreviousTrackController;
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
        GetCurrentTrackViewModel viewModel = currentTrackController.getCurrentTrack();

        setNewMedia(new Media(viewModel.getSourceLocation()));
    }

    @FXML
    protected void onPlayPause() {
        mediaPlayerManager.playPauseCurrentMedia();
    }

    @FXML
    public void onNext() {
        GetNextTrackViewModel viewModel = nextTrackController.getNextTrack();

        setNewMedia(new Media(viewModel.getSourceLocation()));
    }

    @FXML
    public void onPrevious() {
        GetPreviousTrackViewModel viewModel = previousTrackController.getPreviousTrack();

        setNewMedia(new Media(viewModel.getSourceLocation()));
    }

    private void setNewMedia(Media media) {
        mediaPlayerManager.playNewMedia(media);

        mediaPlayerManager.onCurrentMediaEnded(this::onNext);
        mediaPlayerManager.onMediaInformationChanged((mediaPlayerViewModel ->
                display.setText(mediaPlayerViewModel.getTitle())
        ));
    }
}
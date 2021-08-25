package com.codeplays.trainee.aipode.view.mediaplayer;

import com.codeplays.trainee.aipode.view.model.MediaPlayerViewModel;
import javafx.collections.MapChangeListener;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.function.Consumer;

public class MediaPlayerManager {

    private static MediaPlayer currentMediaPlayer;
    private static boolean isPlaying = false;

    public void playPauseCurrentMedia() {
        if (isPlaying) {
            currentMediaPlayer.pause();
            isPlaying = false;
        } else {
            currentMediaPlayer.play();
            isPlaying = true;
        }
    }

    public void stopCurrentMedia() {
        if (currentMediaPlayer != null) {
            currentMediaPlayer.stop();
            currentMediaPlayer.dispose();
        }
    }

    public void playNewMedia(Media media) {
        stopCurrentMedia();

        setUpCurrentMediaPlayer(media);

        currentMediaPlayer.setAutoPlay(true);
    }

    public void onCurrentMediaEnded(Runnable runnable) {
        currentMediaPlayer.setOnEndOfMedia(runnable);
    }

    public void onMediaInformationChanged(Consumer<MediaPlayerViewModel> consumer) {

        consumer.accept(new MediaPlayerViewModel("Desconhecido"));

        currentMediaPlayer.getMedia()
                .getMetadata()
                .addListener((MapChangeListener<String, Object>) change -> {
                            String title = (String) change.getMap().get("title");

                            consumer.accept(new MediaPlayerViewModel(title));
                        }
                );
    }

    private void setUpCurrentMediaPlayer(Media media) {
        currentMediaPlayer = new MediaPlayer(media);
    }
}

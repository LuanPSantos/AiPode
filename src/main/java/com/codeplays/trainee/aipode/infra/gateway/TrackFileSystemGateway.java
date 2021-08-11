package com.codeplays.trainee.aipode.infra.gateway;

import com.codeplays.trainee.aipode.domain.track.gateway.TrackGateway;
import com.codeplays.trainee.aipode.domain.track.model.Track;
import com.codeplays.trainee.aipode.domain.track.model.vo.SourceLocation;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class TrackFileSystemGateway implements TrackGateway {
    private Integer currentTrackIndex = 0;
    private final Track[] tracks;

    public TrackFileSystemGateway() {
        String source = "assets/media";
        this.tracks = loadTracks(source);
    }

    @Override
    public Track nextTrack() {
        setNextTrackAsCurrent();
        return currentTrack();
    }

    @Override
    public Track previousTrack() {
        setPreviousTrackAsCurrent();
        return currentTrack();
    }

    @Override
    public Track currentTrack() {
        return tracks[currentTrackIndex];
    }

    private void setPreviousTrackAsCurrent() {
        currentTrackIndex--;

        if (currentTrackIndex < 0) {
            currentTrackIndex = tracks.length - 1;
        }
    }

    private void setNextTrackAsCurrent() {
        currentTrackIndex++;

        if (currentTrackIndex > tracks.length - 1) {
            currentTrackIndex = 0;
        }
    }

    private Track[] loadTracks(String source) {

        return Arrays
                .stream(requireNonNull(new File(source).listFiles(this::isSupported)))
                .map(file -> {
                    try {
                        return new Track(new SourceLocation(file.toURI().toURL().toString()));
                    } catch (MalformedURLException e) {
                        e.printStackTrace();
                    }
                    return null;
                }).filter(Objects::nonNull).toArray(Track[]::new);
    }

    private boolean isSupported(File file) {
        return file.isFile() && file.getName().endsWith(".mp3");
    }
}

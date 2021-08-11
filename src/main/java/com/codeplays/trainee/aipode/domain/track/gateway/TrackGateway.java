package com.codeplays.trainee.aipode.domain.track.gateway;

import com.codeplays.trainee.aipode.domain.track.model.Track;

public interface TrackGateway {
    Track nextTrack();
    Track previousTrack();
    Track currentTrack();
}

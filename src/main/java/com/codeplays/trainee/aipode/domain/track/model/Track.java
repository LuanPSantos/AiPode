package com.codeplays.trainee.aipode.domain.track.model;

import com.codeplays.trainee.aipode.domain.track.model.vo.SourceLocation;

public class Track {

    private final SourceLocation sourceLocation;

    public Track(SourceLocation sourceLocation) {

        this.sourceLocation = sourceLocation;
    }

    public SourceLocation getSourceLocation() {
        return sourceLocation;
    }
}

package com.codeplays.trainee.aipode.app.usecase.nexttrack;


import com.codeplays.trainee.aipode.domain.track.model.Track;

public abstract class GetNextTrackOutputPort<VM> {
    private ResponseModel responseModel;

    public void setOutputModel(ResponseModel responseModel) {
        this.responseModel = responseModel;
    }

    protected ResponseModel getOutputModel() {
        return responseModel;
    }

    public abstract VM toViewModel();

    public static class ResponseModel {
        private final Track track;

        public ResponseModel(Track track) {
            this.track = track;
        }

        public Track getTrack() {
            return track;
        }
    }
}

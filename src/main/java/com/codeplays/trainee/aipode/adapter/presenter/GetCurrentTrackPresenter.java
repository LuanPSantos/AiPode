package com.codeplays.trainee.aipode.adapter.presenter;

import com.codeplays.trainee.aipode.app.usecase.currenttrack.GetCurrentTrackOutputPort;

import static com.codeplays.trainee.aipode.adapter.presenter.GetCurrentTrackPresenter.*;

public class GetCurrentTrackPresenter extends GetCurrentTrackOutputPort<GetCurrentTrackViewModel> {

    @Override
    public GetCurrentTrackViewModel toViewModel() {
        return new GetCurrentTrackViewModel(getOutputModel().getTrack().getSourceLocation().toString());
    }

    public static class GetCurrentTrackViewModel {
        private final String sourceLocation;

        public GetCurrentTrackViewModel(String sourceLocation) {
            this.sourceLocation = sourceLocation;
        }

        public String getSourceLocation() {
            return sourceLocation;
        }
    }
}

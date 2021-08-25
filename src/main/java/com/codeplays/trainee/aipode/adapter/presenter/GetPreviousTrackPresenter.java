package com.codeplays.trainee.aipode.adapter.presenter;


import com.codeplays.trainee.aipode.app.usecase.previoustrack.GetPreviousTrackOutputPort;

import static com.codeplays.trainee.aipode.adapter.presenter.GetPreviousTrackPresenter.*;

public class GetPreviousTrackPresenter extends GetPreviousTrackOutputPort<GetPreviousTrackViewModel> {

    @Override
    public GetPreviousTrackViewModel toViewModel() {
        return new GetPreviousTrackViewModel(getOutputModel().getTrack().getSourceLocation().toString());
    }

    public static class GetPreviousTrackViewModel {
        private final String sourceLocation;

        public GetPreviousTrackViewModel(String sourceLocation) {
            this.sourceLocation = sourceLocation;
        }

        public String getSourceLocation() {
            return sourceLocation;
        }
    }
}

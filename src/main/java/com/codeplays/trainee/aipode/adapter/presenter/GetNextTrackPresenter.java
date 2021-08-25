package com.codeplays.trainee.aipode.adapter.presenter;


import com.codeplays.trainee.aipode.app.usecase.nexttrack.GetNextTrackOutputPort;

import static com.codeplays.trainee.aipode.adapter.presenter.GetNextTrackPresenter.*;

public class GetNextTrackPresenter extends GetNextTrackOutputPort<GetNextTrackViewModel> {

    @Override
    public GetNextTrackViewModel toViewModel() {
        return new GetNextTrackViewModel(getOutputModel().getTrack().getSourceLocation().toString());
    }

    public static class GetNextTrackViewModel {
        private final String sourceLocation;

        public GetNextTrackViewModel(String sourceLocation) {
            this.sourceLocation = sourceLocation;
        }

        public String getSourceLocation() {
            return sourceLocation;
        }
    }
}

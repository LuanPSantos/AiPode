package com.codeplays.trainee.aipode.view.model;

public class MediaPlayerViewModel {

    private final String title;

    public MediaPlayerViewModel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title == null ? "Desconhecido" : title;
    }
}

package com.codeplays.trainee.aipode;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AiPodeApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(AiPodeApplication.class.getResource("main-view.fxml"));

        Scene scene = new Scene(fxmlLoader.load(), 250, 200);
        stage.setTitle("AiPode");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
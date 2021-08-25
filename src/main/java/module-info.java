module com.codeplays.trainee.aipode {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.codeplays.trainee.aipode to javafx.fxml, javafx.graphics;
    exports com.codeplays.trainee.aipode.domain.track.model;
    opens com.codeplays.trainee.aipode.domain.track.model to javafx.fxml;
    exports com.codeplays.trainee.aipode.domain.track.gateway;
    opens com.codeplays.trainee.aipode.domain.track.gateway to javafx.fxml;
    exports com.codeplays.trainee.aipode.domain.track.model.vo;
    opens com.codeplays.trainee.aipode.domain.track.model.vo to javafx.fxml;
    opens com.codeplays.trainee.aipode.adapter.controller to javafx.fxml, javafx.graphics;
    opens com.codeplays.trainee.aipode.view to javafx.fxml, javafx.graphics;
    exports com.codeplays.trainee.aipode.adapter.gateway;
    opens com.codeplays.trainee.aipode.adapter.gateway to javafx.fxml;
    opens com.codeplays.trainee.aipode.adapter.presenter to javafx.fxml, javafx.graphics;
}
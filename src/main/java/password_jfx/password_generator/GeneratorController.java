package password_jfx.password_generator;

import entity.Password;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GeneratorController {

    @FXML
    public Label passwordShow;

    @FXML
    public void generateButton() {

        Password password = new Password(8);
        passwordShow.setText(password.generate());

    }
}
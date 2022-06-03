module password_jfx.password_generator {
    requires javafx.controls;
    requires javafx.fxml;


    opens password_jfx.password_generator to javafx.fxml;
    exports password_jfx.password_generator;
}
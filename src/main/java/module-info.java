/**
 * Module's requires
 */
module com.epicteam.mathgame {
    requires javafx.swing;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.epicteam.mathgame to javafx.fxml, javafx.swing;
    exports com.epicteam.mathgame;
}
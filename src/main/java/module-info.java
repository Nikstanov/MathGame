module com.epicteam.mathgame {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.epicteam.mathgame to javafx.fxml;
    exports com.epicteam.mathgame;
}
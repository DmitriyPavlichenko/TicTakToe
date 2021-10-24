module TicTakToe {
    requires javafx.fxml;
    requires javafx.controls;
    opens sample to javafx.graphics;
    exports sample;
}
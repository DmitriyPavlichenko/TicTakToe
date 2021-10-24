package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;

import java.util.LinkedList;

public class Controller {
    @FXML public Button b1;
    @FXML public Button b2;
    @FXML public Button b3;
    @FXML public Button b4;
    @FXML public Button b5;
    @FXML public Button b6;
    @FXML public Button b7;
    @FXML public Button b8;
    @FXML public Button b9;
    @FXML public GridPane gameBoard;
    private boolean isFirstPlayer = true;

    public void menuActionHandler(ActionEvent event) {
        MenuItem clickedItem = (MenuItem) event.getTarget();
        String itemLabel = clickedItem.getText();

        if ("Play".equals(itemLabel)) {
            gameBoard.getChildren().forEach(btn -> {
                ((Button) btn).setText("");
                btn.getStyleClass().add("default-button");
            });
            isFirstPlayer = true;
        }
    }

    public void buttonClickHandler(ActionEvent event) {
        Button clickedButton = (Button) event.getTarget();
        String buttonLabel = clickedButton.getText();

        if ("".equals(buttonLabel)) {
            if (isFirstPlayer) {
                clickedButton.setText("X");
                isFirstPlayer = false;

                find3InARow();
            } else {
                clickedButton.setText("O");
                isFirstPlayer = true;

                find3InARow();
            }
        }
    }

    private boolean find3InARow() {
        // 1 row
        if(!"".equals(b1.getText())
                && b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText())) {
            highlightCombo(b1, b2, b3);
            return true;
        }

        // 2 row
        if(!"".equals(b4.getText())
                && b4.getText().equals(b5.getText()) && b5.getText().equals(b6.getText())) {
            highlightCombo(b4, b5, b6);
            return true;
        }

        // 3 row
        if(!"".equals(b7.getText())
                && b7.getText().equals(b8.getText()) && b8.getText().equals(b9.getText())) {
            highlightCombo(b7, b8, b9);
            return true;
        }

        // 1 column
        if(!"".equals(b1.getText())
                && b1.getText().equals(b4.getText()) && b4.getText().equals(b7.getText())) {
            highlightCombo(b1, b4, b7);
            return true;
        }

        // 2 column
        if(!"".equals(b2.getText())
                && b2.getText().equals(b5.getText()) && b5.getText().equals(b8.getText())) {
            highlightCombo(b2, b5, b8);
            return true;
        }

        // 3 column
        if(!"".equals(b3.getText())
                && b3.getText().equals(b6.getText()) && b6.getText().equals(b9.getText())) {
            highlightCombo(b3, b6, b9);
            return true;
        }

        // 1 diagonal
        if(!"".equals(b1.getText())
                && b1.getText().equals(b5.getText()) && b5.getText().equals(b9.getText())) {
            highlightCombo(b1, b5, b9);
            return true;
        }

        // 2 diagonal
        if(!"".equals(b3.getText())
                && b3.getText().equals(b5.getText()) && b5.getText().equals(b7.getText())) {
            highlightCombo(b3, b5, b7);
            return true;
        }
        return false;
    }

    private void highlightCombo(Button first, Button second, Button third) {
        first.getStyleClass().add("winning-button");
        second.getStyleClass().add("winning-button");
        third.getStyleClass().add("winning-button");
    }
}

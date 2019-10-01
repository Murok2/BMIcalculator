package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class BmiController {

    @FXML
    private Font x1;

    @FXML
    private Color x2;

    @FXML
    private Label weightLabel;

    @FXML
    private Label heightLabel;

    @FXML
    private Label bmiLabel;

    @FXML
    private TextField weightTextField;

    @FXML
    private TextField heightTextField;

    @FXML
    private TextField bmiTextField;

    @FXML
    private Button calculateButton;

    @FXML
    private TextArea statusTextArea;

    @FXML
    private Label statusLabel;

    @FXML
    private GridPane GridPane;

    @FXML
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    private ImageView bmiImageView;

    @FXML
    void calculatePress(ActionEvent event) throws Exception {
        try {
            Double weight = new Double(weightTextField.getText());
            Double height = new Double(heightTextField.getText());
            Double h = height / 100;
            Double bmi = (weight) / (Math.pow(h, 2));

            String strDouble = String.format("%.2f", bmi);
            bmiTextField.setText(strDouble);
            if (bmi <= 18.5) {
                bmiImageView.setImage(new Image("/img/under.jpg"));
                statusTextArea.setText("UNDERWEIGHT");
            } else if (bmi > 18.5 && bmi < 25) {

                bmiImageView.setImage(new Image("/img/normal.jpg"));
                statusTextArea.setText("NORMAL");
            } else if (bmi >= 25 && bmi < 30) {
                bmiImageView.setImage(new Image("/img/over.jpg"));
                statusTextArea.setText("OVERWEIGHT");
            } else {
                bmiImageView.setImage(new Image("/img/obese.jpg"));
                statusTextArea.setText("OBESE");
            }
        }catch (NumberFormatException ex) {
            heightTextField.setText("Enter integer");
            heightTextField.selectAll();
            heightTextField.requestFocus();
            weightTextField.setText("Enter integer");
            weightTextField.selectAll();
        }

    }

}
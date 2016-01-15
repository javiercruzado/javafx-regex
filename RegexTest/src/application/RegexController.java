package application;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;

public class RegexController {

	@FXML
	TextField regexField;

	@FXML
	TextArea regexTestField;

	@FXML
	ToggleButton regexStatusButton;

	public void initialize() {

		regexField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				evaluateRegex();
			}
		});

		regexTestField.textProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				evaluateRegex();
			}
		});

	}

	public void evaluateRegex() {
		Pattern p = Pattern.compile(regexField.getText());
		Matcher m = p.matcher(regexTestField.getText());
		boolean b = m.matches();
		if (b) {
			regexTestField.setStyle("-fx-background-color: yellow");
		} else {
			regexTestField.setStyle("-fx-background-color: red");
		}
	}

}

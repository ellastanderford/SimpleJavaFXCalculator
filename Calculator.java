import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.input.*;
import javafx.event.*;
import javafx.scene.text.*;
import javafx.scene.paint.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.geometry.*;

public class Calculator extends Application {

	private TextField numOneField;
	private TextField numTwoField;
	private Label resultLabel;

	public static void main (String[] args) {
		launch(args);
	}

	@Override
	public void start (Stage stage) {
		GridPane root = new GridPane();
		Scene scene = new Scene(root, 400, 500);

		TextField display = new TextField("0");
		root.add(display, 0, 0, 4, 1); // Spans 3 columns, 1 row for the display
		display.setPrefSize(400, 100);

		//Addition parameters are (button, column, row)
		Button clearButton = new Button("Clear");
		root.add(clearButton, 1, 5);
		clearButton.setPrefSize(50, 50);
		Button zeroButton = new Button("0");
		root.add(zeroButton, 0, 4);
		zeroButton.setPrefSize(50, 50);
		Button dotButton = new Button(".");
		root.add(dotButton, 1, 4);
		dotButton.setPrefSize(50, 50);
		Button plusButton = new Button("+");
		root.add(plusButton, 3, 4);
		plusButton.setPrefSize(50, 50);
		Button equalsButton = new Button("=");
		root.add(equalsButton, 2, 5, 2, 1); //At column 2, row 5 spanning 2 columns and 1 row
		equalsButton.setPrefSize(110, 50);
		Button oneButton = new Button("1");
		root.add(oneButton, 0, 3);
		oneButton.setPrefSize(50, 50);
		Button twoButton = new Button("2");
		root.add(twoButton, 1, 3);
		twoButton.setPrefSize(50, 50);
		Button threeButton = new Button("3");
		root.add(threeButton, 2, 3);
		threeButton.setPrefSize(50, 50);
		Button minusButton = new Button("-");
		root.add(minusButton, 3, 3);
		minusButton.setPrefSize(50, 50);
		Button fourButton = new Button("4");
		root.add(fourButton, 0, 2);
		fourButton.setPrefSize(50, 50);
		Button fiveButton = new Button("5");
		root.add(fiveButton, 1, 2);
		fiveButton.setPrefSize(50, 50);
		Button sixButton = new Button("6");
		root.add(sixButton, 2, 2);
		sixButton.setPrefSize(50, 50);
		Button multiplicationButton = new Button("*");
		root.add(multiplicationButton, 3, 2);
		multiplicationButton.setPrefSize(50, 50);
		Button divisionButton = new Button("/");
		root.add(divisionButton, 3, 1);
		divisionButton.setPrefSize(50, 50);
		Button sevenButton = new Button("7");
		root.add(sevenButton, 0, 1);
		sevenButton.setPrefSize(50, 50);
		Button eightButton = new Button("8");
		root.add(eightButton, 1, 1);
		eightButton.setPrefSize(50, 50);
		Button nineButton = new Button("9");
		root.add(nineButton, 2, 1);
		nineButton.setPrefSize(50, 50);
		Button posOrNegButton = new Button("+/-");
		root.add(posOrNegButton, 2, 4);
		posOrNegButton.setPrefSize(50, 50);
		Button onOffButton = new Button("Power");
		root.add(onOffButton, 0, 5);
		onOffButton.setPrefSize(50, 50);
		onOffButton.setStyle("-fx-background-color: Red");

		//Configuring spacing
		root.setHgap(10);
		root.setVgap(10);
		root.setAlignment(Pos.CENTER);

		stage.setScene(scene);
		stage.setTitle("Basic Calculator");
		stage.show();

		//Using buttons
		CalculatorUtility util = new CalculatorUtility(display);

		sevenButton.setOnAction(e -> util.inputDigit("7"));
		eightButton.setOnAction(e -> util.inputDigit("8"));
		nineButton.setOnAction(e -> util.inputDigit("9"));
		divisionButton.setOnAction(e -> util.inputOperator("/"));

		fourButton.setOnAction(e -> util.inputDigit("4"));
		fiveButton.setOnAction(e -> util.inputDigit("5"));
		sixButton.setOnAction(e -> util.inputDigit("6"));
		multiplicationButton.setOnAction(e -> util.inputOperator("*"));

		oneButton.setOnAction(e -> util.inputDigit("1"));
		twoButton.setOnAction(e -> util.inputDigit("2"));
		threeButton.setOnAction(e -> util.inputDigit("3"));
		minusButton.setOnAction(e -> util.inputOperator("-"));

		zeroButton.setOnAction(e -> util.inputDigit("0"));
		dotButton.setOnAction(e -> util.inputDot());
		posOrNegButton.setOnAction(e -> util.toggleSign());
		plusButton.setOnAction(e -> util.inputOperator("+"));

		clearButton.setOnAction(e -> util.clear());
		equalsButton.setOnAction(e -> util.equals());
		onOffButton.setOnAction(e -> util.togglePower());

	}
}
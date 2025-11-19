import javafx.scene.control.TextField;

public class CalculatorUtility {

    private final TextField display;

    private double storedValue = 0;
    private String pendingOperator = "";
    private boolean powerOn = true;
    private boolean newInput = true;

    public CalculatorUtility(TextField display) {
        this.display = display;
    }

    // ---------------- DIGITS ----------------
    public void inputDigit(String digit) {
        if (!powerOn) return;

        if (newInput || display.getText().equals("0")) {
            display.setText(digit);
            newInput = false;
        } else {
            display.setText(display.getText() + digit);
        }
    }

    // ---------------- DECIMAL ----------------
    public void inputDot() {
        if (!powerOn) return;

        if (newInput) {
            display.setText("0.");
            newInput = false;
        } else if (!display.getText().contains(".")) {
            display.setText(display.getText() + ".");
        }
    }

    // ---------------- OPERATORS (+ - * /) ----------------
    public void inputOperator(String op) {
        if (!powerOn) return;

        storedValue = Double.parseDouble(display.getText());
        pendingOperator = op;
        newInput = true;
    }

    // ---------------- SIGN TOGGLE (+/-) ----------------
    public void toggleSign() {
        if (!powerOn) return;

        double val = Double.parseDouble(display.getText());
        display.setText(String.valueOf(-val));
    }

    // ---------------- CLEAR ----------------
    public void clear() {
        if (!powerOn) return;

        display.setText("0");
        storedValue = 0;
        pendingOperator = "";
        newInput = true;
    }

    // ---------------- EQUALS (=) ----------------
    public void equals() {
        if (!powerOn) return;

        double currentValue = Double.parseDouble(display.getText());
        double result = storedValue;

        switch (pendingOperator) {
            case "+" -> result += currentValue;
            case "-" -> result -= currentValue;
            case "*" -> result *= currentValue;
            case "/" -> {
                if (currentValue == 0) {
                    display.setText("ERROR");
                    newInput = true;
                    return;
                }
                result /= currentValue;
            }
        }

        display.setText(String.valueOf(result));
        newInput = true;
        pendingOperator = "";
    }

    // ---------------- POWER TOGGLE ----------------
    public void togglePower() {
        powerOn = !powerOn;

        if (!powerOn) {
            display.setText("");
        } else {
            display.setText("0");
            newInput = true;
        }
    }
}
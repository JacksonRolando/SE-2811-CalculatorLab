package calc;

import java.math.BigInteger;

public class AppendDigitCommand extends CalculatorCommand {
    private boolean newNumberState;
    private char newChar;
    private String displayState;

    public AppendDigitCommand(Calculator c, char newChar) {
        super(c);
        this.newChar = newChar;
    }

    public void execute() {
        newNumberState = calculator.getNewNumber();
        displayState = calculator.getDisplay();
        calculator.appendDigit(newChar);
    }

    public void unexecute() {
        if (Character.isDigit(newChar)) {
            calculator.setDisplay(displayState);
        }
        calculator.setReadyForNewNumber(newNumberState);
    }
}

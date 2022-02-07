package calc;

public class RecallCommand extends CalculatorCommand {
    private String displayState;

    public RecallCommand(Calculator c) {
        super(c);
    }

    public void execute() {
        displayState = calculator.getDisplay();
        calculator.recallFromMemory();
    }

    public void unexecute() {
        calculator.setDisplay(displayState);
        calculator.setReadyForNewNumber(true);
    }
}

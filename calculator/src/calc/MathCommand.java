package calc;

public abstract class MathCommand extends CalculatorCommand {
    private String accumulatorAtExec;
    private String displayAtExec;

    public MathCommand(Calculator c) {
        super(c);
    }

    protected void saveState() {
        displayAtExec = calculator.getDisplay();
        accumulatorAtExec = calculator.getAccumulator();
    }

    protected void loadState() {
        calculator.setDisplay(displayAtExec);
        calculator.setAccumulator(accumulatorAtExec);
    }

    @Override
    public void unexecute() {
        loadState();
        calculator.setReadyForNewNumber(true);
    }
}

package calc;

public class EnterCommand extends CalculatorCommand {
    private String accumulatorState;

    public EnterCommand(Calculator c) {
        super(c);
    }

    public void execute() {
        accumulatorState = calculator.getAccumulator();
        calculator.enter();
    }

    public void unexecute() {
        calculator.setAccumulator(accumulatorState);
        calculator.setReadyForNewNumber(true);
    }
}

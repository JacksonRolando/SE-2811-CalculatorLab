package calc;

public class SaveCommand extends CalculatorCommand {
    private String memoryState;
    private String accumulatorState;

    public SaveCommand(Calculator c) {
        super(c);
    }

    public void execute() {
        memoryState = calculator.getMemory();
        accumulatorState = calculator.getAccumulator();
        calculator.saveToMemory();
    }

    public void unexecute() {
        calculator.setMemory(memoryState);
        calculator.setAccumulator(accumulatorState);
        calculator.setReadyForNewNumber(true);
    }
}

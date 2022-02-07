package calc;

import java.math.BigInteger;

public class ClearCommand extends CalculatorCommand {
    private String displayState;
    private String accumulatorState;
    private String memoryState;

    public ClearCommand(Calculator c) {
        super(c);
    }

    public void execute() {
        displayState = calculator.getDisplay();
        accumulatorState = calculator.getAccumulator();
        memoryState = calculator.getMemory();
        calculator.clear();
    }

    public void unexecute() {
        calculator.setDisplay(displayState);
        calculator.setAccumulator(accumulatorState);
        calculator.setMemory(memoryState);
        calculator.setReadyForNewNumber(true);
    }
}

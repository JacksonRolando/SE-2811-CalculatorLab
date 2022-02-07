package calc;

public class MinusCommand extends MathCommand {
    public MinusCommand(Calculator c) {
        super(c);
    }

    public void execute() {
        saveState();
        calculator.minus();
    }
}

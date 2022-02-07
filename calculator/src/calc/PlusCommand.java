package calc;

public class PlusCommand extends MathCommand {
    public PlusCommand(Calculator c) {
        super(c);
    }

    public void execute() {
        saveState();
        calculator.plus();
    }
}

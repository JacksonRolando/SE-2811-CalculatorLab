package calc;

public class TimesCommand extends MathCommand {
    public TimesCommand(Calculator c) {
        super(c);
    }

    public void execute() {
        saveState();
        calculator.times();
    }
}

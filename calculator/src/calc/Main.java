package calc;

import java.util.Scanner;

/**
 * Interface to calculator, taking commands (see the following code) and converting them
 * to calculator operations.
 *
 * @author R. Hasker
 */
public class Main {

    /**
     * Display user-visible status of calculator. Shows stored memory value if it
     * is not 0.
     *
     * @param c calculator to display
     */
    public static void show(Calculator c) {
        String display = "Display: " + c.result();
        if (!c.getMemory().equals("0"))
            display += " [Mem: " + c.getMemory() + "]";
        System.out.println(display);
    }

    /**
     * Main loop driving calculator: turns input into calculator commands
     * This procedure is long because it encapsulates a large case statement.
     *
     * @param args ignored
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\\s*"); // treat whitespace as a word separator
        Calculator calculator = new Calculator();
        History history = new History();

        boolean doContinue = true;
        while (doContinue && in.hasNext()) {
            String text = in.next();
            for (char c : text.toCharArray()) {
                if (Character.isDigit(c))
                    calculator.appendDigit(c);
                else {
                    switch (Character.toLowerCase(c)) {
                        case 'q':
                            System.out.println("Quit");
                            doContinue = false;
                            break;
                        case '+':
                            System.out.println("Add");
                            calculator.plus();
                            show(calculator);
                            break;
                        case '-':
                            System.out.println("Subtract");
                            calculator.minus();
                            show(calculator);
                            break;
                        case '*':
                            System.out.println("Multiply");
                            history.done_cmds.add(new TimesCommand(calculator));
                            history.done_cmds.peek().execute();
                            show(calculator);
                            break;
                        case ',':
                            calculator.enter();
                            show(calculator);
                            break;
                        case 's':
                            System.out.println("Save");
                            calculator.saveToMemory();
                            show(calculator);
                            break;
                        case 'r':
                            System.out.println("Recall");
                            calculator.recallFromMemory();
                            show(calculator);
                            break;
                        case 'c':
                            System.out.println("Clear");
                            calculator.clear();
                            show(calculator);
                            break;
                        default:
                            if (!Character.isISOControl(c))
                                System.out.println("Unrecognized command `" + c + "'");
                    }
                }
            }
        }
        // end of loop over input
        System.out.println("Final result: " + calculator.result());
    }
}

package eg.edu.alexu.csd.datastructure.stack.cs10;

import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;

/**
 * The Class ExpressionEvaluator_UI.
 */
public class ExpressionEvaluatorUI {

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        String x;

        Scanner input = new Scanner(System.in);
        IExpressionEvaluator express = new ExpressionEvaluator();

        System.out.println("\nInsert An Expression to be evaluated :"
        + "[only parentheses are allowed]"
        + "\n----------------------------------"
        + "-----------------------------------\n");

        x = input.nextLine();

        String postFix = express.infixToPostfix(x);
        System.out.println(express.evaluate(postFix));

    }
}

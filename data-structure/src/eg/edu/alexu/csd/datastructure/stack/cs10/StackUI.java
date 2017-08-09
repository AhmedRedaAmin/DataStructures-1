package eg.edu.alexu.csd.datastructure.stack.cs10;

import java.util.Scanner;

import eg.edu.alexu.csd.datastructure.stack.IStack;

/**
 * The Class Stack_UI.
 */
public class StackUI {
    /** The Constant THREE. */
    private static final int THREE = 3;

    /** The Constant FOUR. */
    private static final int FOUR = 4;

    /** The Constant FIVE. */
    private static final int FIVE = 5;
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(final String[] args) {
        int x;

        Scanner input = new Scanner(System.in);
        IStack stacker = new Stack();

        do {
            System.out.println("\nChoose Your Action :\n"
            + "-------------------\n"
            + "1 - Push\n" + "2 - Pop\n"
            + "3 - Peek\n" + "4 - Get size\n" + "5 - Check if Empty\n"
            + "================================="
            + "===================================");

            x = input.nextInt();
            input.nextLine();
            switch (x) {
            case 1:
                System.out.println("\nPlease Insert Your Object: ");
                Object z = input.nextLine();
                stacker.push(z);
                break;
            case 2:
                System.out.println("\nPlease Observe Your Object: ");
                if (stacker.size() == 0) {
                    throw new RuntimeException("The Stack is empty !");
                }
                Object y = stacker.pop();
                System.out.println(y);
                break;
            case THREE:
                if (stacker.size() == 0) {
                    throw new RuntimeException("The Stack is empty !");
                }
                System.out.println("\nPlease Observe Your Object: ");
                Object t = stacker.pop();
                stacker.push(t);
                System.out.println(t);
                break;
            case FOUR:
                int f = stacker.size();
                System.out.println("\nSize: " + f);
                break;
            case FIVE:

                boolean r = stacker.isEmpty();
                System.out.println("is it empty ?" + r);
                break;
            default:
                throw new RuntimeException("Invalid choice");

            }

        } while (true);

    }
}

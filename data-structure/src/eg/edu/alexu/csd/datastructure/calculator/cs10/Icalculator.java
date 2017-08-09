package eg.edu.alexu.csd.datastructure.calculator.cs10;

import eg.edu.alexu.csd.datastructure.calculator.ICalculator;

/**
 * The Class I_calculator.
 */
public class Icalculator implements ICalculator {

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.calculator.ICalculator#add(int, int)
     */
    @Override
    public int add(final int x, final int y) {
        // TODO Auto-generated method stub
        return x + y;
    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.calculator.ICalculator
     */
    @Override
    public float divide(int x, int y) {
        if (y == 0) {
            System.out.println("Invalid argument,Denominator is zero");
            return 0;
        }
        if (x == 0) {
            return 0;
        }
        if (y < 0) {
            if (x < 0) {
                y *= (-1);
                x *= (-1);
            }
            if (x > 0) {
                y *= (-1);
                x *= (-1);
            }
        }

        // TODO Auto-generated method stub
        return (float) x / (float) y;
    }
}

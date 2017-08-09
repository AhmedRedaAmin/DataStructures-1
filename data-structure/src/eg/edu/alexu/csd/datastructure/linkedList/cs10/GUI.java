package eg.edu.alexu.csd.datastructure.linkedList.cs10;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * The Class GUI.
 */
public class GUI {

    /** The Constant THREE. */
    private static final int THREE = 3;

    /** The Constant FOUR. */
    private static final int FOUR = 4;

    /** The Constant FIVE. */
    private static final int FIVE = 5;

    /** The Constant SIX. */
    private static final int SIX = 6;

    /** The Constant SEVEN. */
    private static final int SEVEN = 7;

    /** The Constant EIGHT. */
    private static final int EIGHT = 8;

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		// MyPolySolver test= new MyPolySolver();
		int x;

		Scanner input = new Scanner(System.in);

		do {

			System.out.println("\n"
			+ "Choose Your Action :\n-------------------\n"
			+ "1 - Set a polynomial variable\n"
			+ "2 - Print the value of a polynomial variable\n"
			+ "3 - Add two polynomials\n"
			+ "4 - Subtract two polynomials\n"
			+ "5 - Multiply two polynomials\n"
			+ "6 - Evaluate a polynomial at some point\n"
			+ "7 - Clear a polynomial variable\n"
			+ "8 - Terminate Program\n"
			+ "================================="
			+ "===================================");

			x = input.nextInt();
			input.nextLine();
			switch (x) {
			case 1:
	System.out.println("Insert the variable name A , B or C");
				String s = input.next();
				input.nextLine();
				char cS = s.charAt(0);
				if (s.length() != 1) {
					throw new RuntimeException();
				}
				if (cS == 'A' || cS == 'B' || cS == 'C') {
					System.out.println(
           "Insert the Polynomial terms in the form : \n"
  + " (coeff1,exponent1),(coeff2,exponent2) .... etc. [nospaces] /n");
					String choice = input.nextLine();
					String[] terms = choice.split(",");
					int i = 0;
		int[][] polyTerms = new int[terms.length / 2][2];
					if (terms.length % 2 != 0) {
	throw new RuntimeException("Invalid input");
					}
					for (i = 0; i < terms.length; i++) {
						if (i % 2 == 0) {
				terms[i] = terms[i].split("\\(")[1];
						} else {
				terms[i] = terms[i].split("\\)")[0];
						}
					}
					int k = 0;
					for (i = 0; i < terms.length / 2; i++) {

					try {
				polyTerms[i][0] = Integer.parseInt(terms[k]);
				k++;
				polyTerms[i][1] = Integer.parseInt(terms[k]);
				k++;
					} catch (NumberFormatException e) {
				throw new RuntimeException();
						}

					}
					// test.setPolynomial(S,polyTerms);

				} else {
	throw new RuntimeException("Case Sensitive letters bound");

				}
				break;

			case 2:
	System.out.println("Choose the variable you want to print/n");
				String s2 = input.next();
				input.nextLine();
				char cS2 = s2.charAt(0);
				if (s2.length() != 1) {
					throw new RuntimeException();

				}
				if (cS2 != 'A' && cS2 != 'B'
				        && cS2 != 'C' && cS2 != 'R') {
					throw new RuntimeException();
				}

				// System.out.println(test.print(cS2));
				break;
			case  THREE:
	System.out.println("Choose the variables you want to add"
			+ "  [First Operand]/n");
				String s3 = input.next();
				input.nextLine();
	System.out.println("Choose the variables you want to add "
			+ " [Second Operand]/n");
				String s3B = input.next();
				input.nextLine();
				if (s3.length() != 1 || s3B.length() != 1) {
					throw new RuntimeException();

				}
				char cS3 = s3.charAt(0);
				char cS3b = s3B.charAt(0);
				//cS stands for character string
				// test.setPolynomial(R,test.add(cS3,cS3b));
				// test.print(R);
				// System.out.println(R);

				break;

			case FOUR:
	System.out.println("Choose the variables you want to Subtract"
			+ "  [First Operand]/n");
				String s4 = input.next();
				input.nextLine();
	System.out.println("Choose the variables you want to Subtract "
			+ " [Second Operand]/n");
				String s4B = input.next();
				input.nextLine();
				if (s4.length() != 1 || s4B.length() != 1) {
					throw new RuntimeException();

				}
				char cS4 = s4.charAt(0);
				char cS4b = s4B.charAt(0);
				//cS stands for character string
			// test.setPolynomial(R,test.subtract(cS4,cS4b));
				// test.print(R);
				// System.out.println(R);

				break;

			case FIVE:

  System.out.println("Choose the variables you want to Multiply"
  + "  [First Operand]/n");
				String s5 = input.next();
				input.nextLine();
  System.out.println("Choose the variables you want to Multiply"
  + "  [Second Operand]/n");
				String s5B = input.next();
				input.nextLine();
				if (s5.length() != 1 || s5B.length() != 1) {
					throw new RuntimeException();

				}
				char cS5 = s5.charAt(0);
				char cS5b = s5B.charAt(0);
				//cS stands for character string
			// test.setPolynomial(R,test.multiply(cS5,cS5b));
				// test.print(R);
				// System.out.println(R);

				break;

			case SIX:
	System.out.println("Choose the variable you want to evalute \n");
				String s6 = input.next();
				input.nextLine();
				if (s6.length() != 1) {
					throw new RuntimeException();

				}
				char cS6 = s6.charAt(0);
				if (cS6 != 'A' && cS6 != 'B'
				        && cS6 != 'C' && cS6 != 'R') {
					throw new RuntimeException();
				}
				try {
	System.out.println("Choose the value you want to evalute at \n");
					double point = input.nextDouble();
					input.nextLine();
				} catch (InputMismatchException e) {
					throw new RuntimeException();
				}

	// System.out.println(test.evaluatePolynomial(cS2,point));
				break;

			case SEVEN:
	System.out.println("Choose the variable you want to clear/n");
				String s7 = input.next();
				input.nextLine();
				char cS7 = s7.charAt(0);
				if (s7.length() != 1) {
					throw new RuntimeException();

				}
				if (cS7 != 'A' && cS7 != 'B'
				        && cS7 != 'C' && cS7 != 'R') {
					throw new RuntimeException();
				}

				// test.clearPolynomial(cS7);
				break;
			case EIGHT:
				System.out.println("App Terminated");
				break;
			default:
	throw new RuntimeException("You are entering an invalid list choice");

			}

		} while (x != EIGHT);

	}

}

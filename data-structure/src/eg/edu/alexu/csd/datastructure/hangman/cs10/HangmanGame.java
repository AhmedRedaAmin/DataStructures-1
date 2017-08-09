package eg.edu.alexu.csd.datastructure.hangman.cs10;

import java.util.Random;
import eg.edu.alexu.csd.datastructure.hangman.IHangman;


/**
 * The Class HangmanGame.
 */
public class HangmanGame implements IHangman {

    /** The Constant NUMBER_LETTERS. */
    private static final int NUMBER_LETTERS = 26;

    /** The Constant NUMBER_WORDS. */
    private static final int NUMBER_WORDS = 5;
    /** The current wrong. */
    private int choice, length, maxWrong, currentWrong;

    /** The displayer. */
    private char[] displayer;

    /** The secret words. */
    private String[] secretWords = new String[NUMBER_WORDS];

    /** The used. */
    char[] used = new char[NUMBER_LETTERS];

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.hangman.IHangman
     */
    @Override
    public void setDictionary(final String[] words) {
        secretWords = words;

        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.hangman.IHangman
     */
    @Override
    public String selectRandomSecretWord() {
        int j;

        int rnd = new Random().nextInt(secretWords.length);
        if (secretWords[rnd] == null) {
            return null;
        }
        choice = rnd;
        if (secretWords != null) {
            length = secretWords[rnd].length();

            displayer = new char[secretWords[rnd].length()];
            for (j = 0; j < length; j++) {
                displayer[j] = '-';
            }

            return secretWords[rnd];
        }

        return null;

        // TODO Auto-generated method stub

    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.hangman.IHangman
     */
    @Override
    public String guess(final Character c) {
        String displayline = new String(displayer);

        if (c == null) {
            return displayline;
        }

        int j, flag = 0;

        for (j = 0; j < length; j++) {
            if (secretWords[choice].charAt(j) == Character.toLowerCase(c)
              || secretWords[choice].charAt(j) == Character.toUpperCase(c)) {
                displayer[j] = secretWords[choice].charAt(j);
                flag = 1;

            }
        }

        if (flag == 0) {
            currentWrong++;
        }

        if (currentWrong >= maxWrong) {
            return null;
        }
        displayline = new String(displayer);
        // TODO Auto-generated method stub
        return displayline;

    }

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.hangman.IHangman
     */
    @Override
    public void setMaxWrongGuesses(final Integer max) {
        // TODO Auto-generated method stub
        maxWrong = max;

    }

}

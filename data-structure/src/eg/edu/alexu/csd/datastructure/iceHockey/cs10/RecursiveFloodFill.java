package eg.edu.alexu.csd.datastructure.iceHockey.cs10;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

import eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder;


/**
 * The Class RecursiveFloodFill.
 */
public class RecursiveFloodFill implements IPlayersFinder {
    /**
     * int.
     */
    private int width, length;
    /**
     * Point.
     */
    Point max;
    /**
     * Point.
     */
    Point min;
    /**
     * int.
     */
    int cell;
    /**
     * int.
     */
    private static final int MAX = 10000;
    /**
     * int.
     */
   private static final int SQUARE_AREA = 4;
    /**
     * Point.
     */
    private Point[] answers;
    /**
     * Linked List  queue Point.
     */
    Queue<Point> tempanswers = new LinkedList<Point>();

    /* (non-Javadoc)
     * @see eg.edu.alexu.csd.datastructure.iceHockey.IPlayersFinder#findPlayers(java.lang.String[], int, int)
     */
    @Override
    public Point[] findPlayers(final String[] photo,
           final int team, final int threshold) {

        tempanswers = new LinkedList<Point>();
        int lenOfArr = photo.length;
        length = lenOfArr;
        int iI, stringwidth = 0;
        Point[] nothing = new Point[0];
        if (length == 0) {
            return nothing;
        }

        Character[][] arrOfElem = null;
        int lenStr = photo[0].length();

        arrOfElem = new Character[lenOfArr][lenStr];

        int zZ = 0;

        for (iI = 0; iI < lenOfArr; iI++) {
            char[] charArray = new char[photo[iI].length()];
            charArray = photo[iI].toCharArray();

            stringwidth = lenStr;
            width = stringwidth;
            for (zZ = 0; zZ < lenStr; zZ++) {
                arrOfElem[iI][zZ] = (charArray[zZ]);
            }
        }

        int j = 0;
        int endOfImage;
        int breaker;

        do {
            breaker = 0;

            endOfImage = 1;

            for (iI = 0; iI < lenOfArr; iI++) {
                if (endOfImage == 0) {
                    break;
                }
                for (zZ = 0; zZ < width; zZ++) {
                 if (Character.getNumericValue(arrOfElem[iI][zZ]) == (team)) {
                        endOfImage = 0;
                        breaker = 1;
                        break;
                    }

                }

                if (breaker == 1) {
                    break;
                }

            }
            if (breaker == 0) {
                break;
            }
            Point catcher = new Point();
            cell = 0;
            max = new Point(0, 0);
            min = new Point(MAX, MAX);
            floodFill(iI, zZ, team, arrOfElem);

            int area;

            area = SQUARE_AREA * cell;
            catcher.x = (min.x + max.x) + 1;
            catcher.y = (min.y + max.y) + 1;

            if (area < threshold) {
                catcher.x = -1;
                catcher.y = -1;
            }

            if (catcher.x >= 0) {
                j++;
                tempanswers.add(catcher);
            }

        } while (endOfImage != 1);

        answers = new Point[j];
        if (j == 0) {
            answers = new Point[1];
        }
        int k;
        for (k = 0; k < j; k++) {
            answers[k] = tempanswers.poll();

        }
        Point temp;
        int h;
        for (h = 0; h < j; h++) {

            for (k = 0; k < j - 1; k++) {
                if (answers[k].x > answers[k + 1].x) {
                    temp = answers[k];
                    answers[k] = answers[k + 1];
                    answers[k + 1] = temp;
                }
                if (answers[k].x == answers[k + 1].x) {
                    if (answers[k].y > answers[k + 1].y) {
                        temp = answers[k];
                        answers[k] = answers[k + 1];
                        answers[k + 1] = temp;
                    }
                }

            }
        }

        if (answers[0] == null) {
            return nothing;
        }

        // TODO Auto-generated method stub
        return answers;
    }

    /**
     * Flood fill.
     *
     * @param i the i
     * @param z the z
     * @param team the team
     * @param arrOfElem the arr of elem
     */
    public void floodFill(final int i, final int z,
        final int team, final Character[][] arrOfElem) {

        if (z == width) {
            return;
        }
        if (i == length) {
            return;
        }
        if (z < 0) {
            return;
        }
        if (i < 0) {
            return;
        }

        if (Character.getNumericValue(arrOfElem[i][z]) != team) {

            return;

        }

        if (z > max.x) {
            max.x = z;
        }
        if (i > max.y) {
            max.y = i;
        }
        if (z < min.x) {
            min.x = z;
        }
        if (i < min.y) {
            min.y = i;
        }

        arrOfElem[i][z] = 't';
        cell++;

        floodFill(i + 1, z, team, arrOfElem);
        floodFill(i, z + 1, team, arrOfElem);
        floodFill(i - 1, z, team, arrOfElem);
        floodFill(i, z - 1, team, arrOfElem);

    }

}

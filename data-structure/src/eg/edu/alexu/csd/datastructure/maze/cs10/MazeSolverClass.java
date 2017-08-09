package eg.edu.alexu.csd.datastructure.maze.cs10;

import java.awt.Point;
import java.io.File;
import java.util.Scanner;
import eg.edu.alexu.csd.datastructure.maze.IMazeSolver;
import eg.edu.alexu.csd.datastructure.queue.IQueue;
import eg.edu.alexu.csd.datastructure.queue.cs10.QueueLinkedList;
import eg.edu.alexu.csd.datastructure.stack.IStack;
import eg.edu.alexu.csd.datastructure.stack.cs10.Stack;


/**
 * The Class MazeSolverClass.
 */
public class MazeSolverClass implements IMazeSolver {

    /** The exit. */
    private Point exit = null;

    /**
     * The Class TraversalNode.
     */
    private class TraversalNode {

        /** The current. */
        private Point current;

        /** The parent. */
        private Point parent = null;

        /**
         * Instantiates a new traversal node.
         *
         * @param now the now
         * @param from the from
         */
        TraversalNode(final Point now, final Point from) {
            current = now;
            parent = from;

        }

        /**
         * Gets the parent.
         *
         * @return the parent
         */
        public Point getParent() {
            return parent;
        }

    }

    /**
     * Check.
     *
     * @param maze
     *            the maze
     * @return the char[][]
     */
    private char[][] check(final File maze) {

        char[][] temp = null;
        int lengthGiven = 0;
        int widthGiven = 0;
        int flagS = 0;
        int flagE = 0;
        try {

            Scanner read = new Scanner(maze);
            String dimensions = read.nextLine();
            String[] dim = dimensions.split(" ");
            lengthGiven = Integer.parseInt(dim[0]);
            widthGiven = Integer.parseInt(dim[1]);
            int j = 0, measuredLength = 0;
            while (read.hasNextLine()) {
                read.nextLine();
                measuredLength++;
            }
            temp = new char[measuredLength][];
            read = new Scanner(maze);
            read.nextLine();
            while (read.hasNextLine()) {
                String[] line = read.nextLine().split("");
                char[] liner = new char[line.length];
                int i = 0;
                for (i = 0; i < line.length; i++) {

                    liner[i] = line[i].charAt(0);
                    if (liner[i] == 'S') {
                        flagS++;

                    } else if (liner[i] == 'E') {
                        flagE = 1;
                    }

                }
                temp[j] = liner;
                j++;
            }
            read.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (temp.length != lengthGiven
                || temp[0].length != widthGiven
                || flagE != 1 || flagS > 1 || flagS == 0) {
            throw new RuntimeException("Invalid dimensions");

        }
        return temp;

    }

    /*
     * (non-Javadoc)
     *
     * @
     */
    @Override
    public int[][] solveBFS(final File maze) {
        int flagFound = 0;
        char[][] mazeMap = check(maze);
        IQueue myQueue = new QueueLinkedList();
        TraversalNode[][] grid =
                new TraversalNode[mazeMap.length][mazeMap[0].length];
        int i, j;
        for (j = 0; j < mazeMap.length; j++) {
            for (i = 0; i < mazeMap[0].length; i++) {
                if (mazeMap[j][i] == 'S') {
                    Point start = new Point(i, j);
                    myQueue.enqueue(start);
                    grid[j][i] = new TraversalNode(start, start);
                    break;
                }

            }
        }

        do {
            Point start = (Point) myQueue.dequeue();
            if (mazeMap[start.y][start.x] == 'E') {
                flagFound = 1;
                exit = new Point(start.x, start.y);
                break;
            }

            if (start.y - 1 >= 0
                    && (mazeMap[start.y - 1][start.x] == '.'
                    || mazeMap[start.y - 1][start.x] == 'E')) {
                Point path = new Point(start.x, start.y - 1);
                if (mazeMap[path.y][path.x] == 'E') {
                    myQueue.enqueue(path);
                    grid[path.y][path.x] = new TraversalNode(path, start);
                } else {
                    myQueue.enqueue(path);
                    mazeMap[path.y][path.x] = 'v';
                    grid[path.y][path.x] = new TraversalNode(path, start);
                }
            }
            if (start.x + 1 < mazeMap[0].length
                    && (mazeMap[start.y][start.x + 1] == '.'
                    || mazeMap[start.y][start.x + 1] == 'E')) {
                Point path = new Point(start.x + 1, start.y);
                if (mazeMap[path.y][path.x] == 'E') {
                    myQueue.enqueue(path);
                    grid[path.y][path.x] = new TraversalNode(path, start);
                } else {
                    myQueue.enqueue(path);
                    mazeMap[path.y][path.x] = 'v';
                    grid[path.y][path.x] = new TraversalNode(path, start);
                }
            }
            if (start.y + 1 < mazeMap.length
                    && (mazeMap[start.y + 1][start.x] == '.'
                    || mazeMap[start.y + 1][start.x] == 'E')) {
                Point path = new Point(start.x, start.y + 1);
                if (mazeMap[path.y][path.x] == 'E') {
                    myQueue.enqueue(path);
                    grid[path.y][path.x] = new TraversalNode(path, start);
                } else {
                    myQueue.enqueue(path);
                    mazeMap[path.y][path.x] = 'v';
                    grid[path.y][path.x] = new TraversalNode(path, start);
                }
            }
            if (start.x - 1 >= 0 && (mazeMap[start.y][start.x - 1] == '.'
                    || mazeMap[start.y][start.x - 1] == 'E')) {
                Point path = new Point(start.x - 1, start.y);
                if (mazeMap[path.y][path.x] == 'E') {
                    myQueue.enqueue(path);
                    grid[path.y][path.x] = new TraversalNode(path, start);
                } else {
                    myQueue.enqueue(path);
                    mazeMap[path.y][path.x] = 'v';
                    grid[path.y][path.x] = new TraversalNode(path, start);
                }
            }

            mazeMap[start.y][start.x] = 'V';

        } while (!myQueue.isEmpty());
        if (flagFound == 0) {
            return null;
        }
        IQueue result = new QueueLinkedList();
        while (flagFound == 1) {

            result.enqueue(exit);
            if (grid[exit.y][exit.x].parent
                    .equals(grid[exit.y][exit.x].current)) {

                break;

            }

            exit = grid[exit.y][exit.x].parent;

        }
        int[][] pathWay = new int[result.size()][2];
        int z = result.size();
        for (i = z - 1; i >= 0; i--) {
            Point f = (Point) result.dequeue();
            pathWay[i][0] = f.y;
            pathWay[i][1] = f.x;

        }

        // TODO Auto-generated method stub
        return pathWay;
    }

    /*
     * (non-Javadoc)
     *
     */
    @Override
    public int[][] solveDFS(final File maze) {
        int flagFound = 0;
        char[][] mazeMap = check(maze);
        IStack myStack = new Stack();
        TraversalNode[][] grid =
       new TraversalNode[mazeMap.length][mazeMap[0].length];
        int i, j;
        for (j = 0; j < mazeMap.length; j++) {
            for (i = 0; i < mazeMap[0].length; i++) {
                if (mazeMap[j][i] == 'S') {
                    Point start = new Point(i, j);
                    myStack.push(start);
                    grid[j][i] = new TraversalNode(start, start);
                    break;
                }

            }
        }

        do {
            Point start = (Point) myStack.pop();
            if (mazeMap[start.y][start.x] == 'E') {
                flagFound = 1;
                exit = new Point(start.x, start.y);
                break;
            }
            if (start.x - 1 >= 0
                    && (mazeMap[start.y][start.x - 1] == '.'
                    || mazeMap[start.y][start.x - 1] == 'E')) {
                Point path = new Point(start.x - 1, start.y);
                if (mazeMap[path.y][path.x] == 'E') {
                    myStack.push(path);
                    grid[path.y][path.x] = new TraversalNode(path, start);
                } else {
                    myStack.push(path);
                    mazeMap[path.y][path.x] = 'v';
                    grid[path.y][path.x] = new TraversalNode(path, start);
                }
            }

            if (start.y + 1 < mazeMap.length
                    && (mazeMap[start.y + 1][start.x] == '.'
                    || mazeMap[start.y + 1][start.x] == 'E')) {
                Point path = new Point(start.x, start.y + 1);
                if (mazeMap[path.y][path.x] == 'E') {
                    myStack.push(path);
                    grid[path.y][path.x] = new TraversalNode(path, start);
                } else {
                    myStack.push(path);
                    mazeMap[path.y][path.x] = 'v';
                    grid[path.y][path.x] = new TraversalNode(path, start);
                }
            }
            if (start.x + 1 < mazeMap[0].length
                    && (mazeMap[start.y][start.x + 1] == '.'
                    || mazeMap[start.y][start.x + 1] == 'E')) {
                Point path = new Point(start.x + 1, start.y);
                if (mazeMap[path.y][path.x] == 'E') {
                    myStack.push(path);
                    grid[path.y][path.x] = new TraversalNode(path, start);
                } else {
                    myStack.push(path);
                    mazeMap[path.y][path.x] = 'v';
                    grid[path.y][path.x] = new TraversalNode(path, start);
                }
            }
            if (start.y - 1 >= 0
                    && (mazeMap[start.y - 1][start.x] == '.'
                    || mazeMap[start.y - 1][start.x] == 'E')) {
                Point path = new Point(start.x, start.y - 1);
                if (mazeMap[path.y][path.x] == 'E') {
                    myStack.push(path);
                    grid[path.y][path.x] = new TraversalNode(path, start);
                } else {
                    myStack.push(path);
                    mazeMap[path.y][path.x] = 'v';
                    grid[path.y][path.x] = new TraversalNode(path, start);
                }
            }

            mazeMap[start.y][start.x] = 'V';

        } while (!myStack.isEmpty());
        if (flagFound == 0) {
            return null;
        }
        IQueue result = new QueueLinkedList();
        while (flagFound == 1) {

            result.enqueue(exit);
            if (grid[exit.y][exit.x].parent
                    .equals(grid[exit.y][exit.x].current)) {

                break;

            }

            exit = grid[exit.y][exit.x].parent;

        }
        int[][] pathWay = new int[result.size()][2];
        int z = result.size();
        for (i = z - 1; i >= 0; i--) {
            Point f = (Point) result.dequeue();
            pathWay[i][0] = f.y;
            pathWay[i][1] = f.x;

        }

        // TODO Auto-generated method stub
        return pathWay;
    }

}

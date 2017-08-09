package eg.edu.alexu.csd.datastructure.stack.cs10;

import eg.edu.alexu.csd.datastructure.stack.IExpressionEvaluator;
import eg.edu.alexu.csd.datastructure.stack.IStack;

/**
 * The Class ExpressionEvaluator.
 */
public class ExpressionEvaluator implements IExpressionEvaluator {

    @Override
    public String infixToPostfix(final String expression) {
        IStack stacker = new Stack();
        String[] splitter = expression.split("");
        int collate = 0;
        int i = 0;
        int hotNum = 0;
        int digitNum = 0;
        int signNum = 0;
        StringBuilder concat = new StringBuilder();
        while (i < splitter.length) {

            switch (splitter[i].charAt(0)) {
            case '+':
                if (hotNum == 1) {
                    throw new RuntimeException("successive operators!");
                }
                if (stacker.size() == 0) {
                    stacker.push(splitter[i].charAt(0));
                } else {
                    Object s;
                    int flag = 0;
                    while (flag == 0 && stacker.size() != 0) {
                        s = stacker.peek();
                        if (s.equals('+') || s.equals('-')
                         || s.equals('*') || s.equals('/')) {
                            concat.append(" " + stacker.pop());
                        } else {
                            flag = 1;
                        }
                    }
                    stacker.push(splitter[i].charAt(0));

                }
                signNum++;
                hotNum = 1;
                collate = 0;
                break;
            case '-':
                if (hotNum == 1) {
                    throw new RuntimeException("successive operators!");
                }
                if (stacker.size() == 0) {
                    stacker.push(splitter[i].charAt(0));
                } else {
                    Object s;
                    int flag = 0;
                    while (flag == 0 && stacker.size() != 0) {
                        s = stacker.peek();
                        if (s.equals('+') || s.equals('-')
                        || s.equals('*') || s.equals('/')) {
                            concat.append(" " + stacker.pop());
                        } else {
                            flag = 1;
                        }
                    }
                    stacker.push(splitter[i].charAt(0));

                }
                signNum++;
                hotNum = 1;
                collate = 0;
                break;
            case '*':
                if (hotNum == 1) {
                    throw new RuntimeException("successive operators!");
                }
                if (stacker.size() == 0) {
                    stacker.push(splitter[i].charAt(0));
                } else {
                    Object s;
                    int flag = 0;
                    while (flag == 0 && stacker.size() != 0) {
                        s = stacker.peek();
                        if (s.equals('*') || s.equals('/')) {
                            concat.append(" " + stacker.pop());
                        } else {
                            flag = 1;
                        }
                    }
                    stacker.push(splitter[i].charAt(0));

                }
                signNum++;
                hotNum = 1;
                collate = 0;
                break;
            case '/':
                if (hotNum == 1) {
                    throw new RuntimeException("successive operators!");
                }
                if (stacker.size() == 0) {
                    stacker.push(splitter[i].charAt(0));
                } else {
                    Object s;
                    int flag = 0;
                    while (flag == 0 && stacker.size() != 0) {
                        s = stacker.peek();
                        if (s.equals('*') || s.equals('/')) {
                            concat.append(" " + stacker.pop());
                        } else {
                            flag = 1;
                        }
                    }
                    stacker.push(splitter[i].charAt(0));

                }
                signNum++;
                hotNum = 1;
                collate = 0;
                break;
            case '(':
                stacker.push(splitter[i].charAt(0));
                collate = 0;
                break;
            case ')':
                if (stacker.size() == 0) {
                    throw new RuntimeException("Invalid Input");
                } else {
                    Object s;
                    int flag = 0;
                    while (flag == 0) {
                        s = stacker.peek();
                        if (!s.equals('(') && stacker.size() != 0) {
                            concat.append(" " + stacker.pop());
                        } else if (stacker.size() == 0) {
                            throw new RuntimeException("Invalid Input");
                        } else {
                            stacker.pop();
                            flag = 1;
                        }
                    }

                }
                collate = 0;
                break;
            case ' ':
                collate = 0;
                break;

            default:
                if (collate == 1) {
                    concat.append(splitter[i]);
                    break;
                }
                collate = 1;
                digitNum++;
                hotNum = 0;
                concat.append(" " + splitter[i]);
            }

            i++;

        }
        while (stacker.size() != 0) {
            Object t = stacker.peek();
            if (t.equals('(') || t.equals(')')) {
                throw new RuntimeException("Invalid Input");

            } else {
                concat.append(" " + stacker.pop());
            }

        }

        if (signNum >= digitNum) {
            throw new RuntimeException("Invalid Expression!");
        }
        // TODO Auto-generated method stub
        return concat.toString().trim();
    }

    @Override
    public int evaluate(final String expression) {

        IStack stacker = new Stack();
        String[] splitter = expression.split(" ");
        int i = 0;
        while (i < splitter.length) {

            switch (splitter[i].charAt(0)) {
            case '+':
                if (stacker.size() < 2) {
                    throw new RuntimeException("Invalid Input!");
                } else {
                    try {
                        String s1 = String.valueOf(stacker.pop());
                        String s2 = String.valueOf(stacker.pop());
                        Double s3 = Double.parseDouble(s2)
                              + Double.parseDouble(s1);
                        stacker.push(s3);
                    } catch (Exception e) {
                        throw new RuntimeException("Something"
                    + " is wrong with this expression!");
                    }
                }
                break;
            case '-':
                if (stacker.size() < 2) {
                    throw new RuntimeException("Invalid Input!");
                } else {
                    try {
                        String s1 = String.valueOf(stacker.pop());
                        String s2 = String.valueOf(stacker.pop());
                        Double s3 = Double.parseDouble(s2)
                             - Double.parseDouble(s1);
                        stacker.push(s3);
                    } catch (Exception e) {
                        throw new RuntimeException("Something"
                    + " is wrong with this expression!");
                    }
                }
                break;
            case '*':
                if (stacker.size() < 2) {
                    throw new RuntimeException("Invalid Input!");
                } else {
                    try {
                        String s1 = String.valueOf(stacker.pop());
                        String s2 = String.valueOf(stacker.pop());
                        Double s3 = Double.parseDouble(s2)
                              * Double.parseDouble(s1);
                        stacker.push(s3);
                    } catch (Exception e) {
                        throw new RuntimeException("Something"
                    + " is wrong with this expression!");
                    }
                }
                break;
            case '/':
                if (stacker.size() < 2) {
                    throw new RuntimeException("Invalid Input!");
                } else {
                    try {
                        String s1 = String.valueOf(stacker.pop());
                        String s2 = String.valueOf(stacker.pop());
                        Double s3 = Double.parseDouble(s2)
                           / Double.parseDouble(s1);
                        stacker.push(s3);
                    } catch (Exception e) {
                        throw new RuntimeException("Something"
                    + " is wrong with this expression!");
                    }
                }
                break;

            default:

                stacker.push(splitter[i]);
            }

            i++;
        }
        if (stacker.size() > 1) {
       throw new RuntimeException("Something is wrong with this expression !");
        }
        Integer f = ((Double) stacker.pop()).intValue();

        // TODO Auto-generated method stub
        return f;
    }

}

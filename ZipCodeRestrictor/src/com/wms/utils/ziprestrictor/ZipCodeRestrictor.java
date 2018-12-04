package com.wms.utils.ziprestrictor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.Logger;

/**
 * This Utility class helps to produce the minimum number of Zip Code ranges
 * required to represent the same restrictions as the input.
 * 
 * @author vignesh
 *
 */
public class ZipCodeRestrictor {
    
    private static final Logger LOGGER = Logger.getLogger( ZipCodeRestrictor.class.getName() );

    public static void main(String[] args) {
        Integer[][] input = getInput();
        Stack<Integer[]> stack = restrictor(input);
        getResultSet(stack);
    }

    /**
     * This method takes the ranges of Integer as an array and returns stack with
     * minimum number of Zip Code ranges.
     * 
     * @param input
     *            Integer[][]
     * @return Stack Integer[]
     */
    public static Stack<Integer[]> restrictor(Integer[][] input) {
        Stack<Integer[]> stack = new Stack<Integer[]>();
        Arrays.sort(input, (a, b) -> Integer.compare(a[0], b[0]));
        stack.push(input[0]);
        for (int rows = 1; rows < input.length; rows++) {
            Integer[] result = stack.peek();
            int startRange = result[0];
            int endRange = result[1];
            for (int columns = 0; columns < input[rows].length - 1; columns++) {
                if (endRange > input[rows][columns] && endRange < input[rows][columns + 1]) {
                    stack.pop();
                    endRange = input[rows][columns + 1];
                    Integer[] array = new Integer[2];
                    array[0] = startRange;
                    array[1] = endRange;
                    stack.push(array);
                    break;
                } else if (endRange < input[rows][columns]) {
                    stack.push(input[rows]);
                }
            }
        }

        return stack;
    }

    /**
     * Gets the user input and validates for 5 digit.
     * 
     * @return Integer[][]
     */
    public static Integer[][] getInput() {
        Scanner in = new Scanner(System.in);
        int noOfSets = in.nextInt();
        Integer[][] input = new Integer[noOfSets][2];
        for (int i = 0; i < noOfSets; i++) {
            for (int j = 0; j < input[i].length; j++) {
                while (true) {
                    int value = in.nextInt();
                    if (String.valueOf(value).matches("[0-9]{5}")) {
                        input[i][j] = value;
                        break;
                    } else {
                        LOGGER.info("Please enter the valid zip code");
                    }
                }
            }
        }
        in.close();
        return input;
    }

    /**
     * Iterates over the stack and prints out the minimum number of ranges of
     * ZipCode
     * 
     * @param stack
     */
    public static void getResultSet(Stack<Integer[]> stack) {
        Iterator<Integer[]> iterator = stack.iterator();
        LOGGER.info("The set of ranges are: ");
        while (iterator.hasNext()) {
            Integer[] res = iterator.next();
            LOGGER.info(Arrays.toString(res));
        }
    }
}
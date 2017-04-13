package com.selim;

import java.util.Stack;

public class GetAllSubsetByStack {
    public static final int TARGET_SUM = 15;
    public static int total_combination = 0;

    private Stack<Integer> stack = new Stack<Integer>();

    private int sumInStack = 0;

    public void populateSubset(int[] data, int fromIndex, int endIndex) {
        if (sumInStack == TARGET_SUM) {
            total_combination++;
            print(stack);
        }

        for (int i = fromIndex; i < endIndex; i++) {
            if (sumInStack + data[i] <= TARGET_SUM) {
                stack.push(data[i]);
                sumInStack += data[i];
                populateSubset(data, i + 1, endIndex);
                sumInStack -= (Integer) stack.pop();
            }
        }
    }

    private void print(Stack<Integer> stack) {
        StringBuilder sb = new StringBuilder();
        sb.append(TARGET_SUM).append(" = ");
        for (Integer i : stack) {
            sb.append(i).append("+");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }


    private static final int[] DATA = { 3,5,10,5 };

    public static void main(String[] args) {
        GetAllSubsetByStack get = new GetAllSubsetByStack();
        get.populateSubset(DATA, 0, DATA.length);
        //System.out.println(DATA.length);
        System.out.println(total_combination);
    }
}
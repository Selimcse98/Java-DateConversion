package com.selim;

import java.util.Stack;

/**
 * Created by mohammadselimmiah on 16/06/2016.
 */
public class TargetSum {
    private static final int TARGET_SUM = 15;
    private static int stackSum = 0;
    private static Stack<Integer> stack = new Stack<>();

    public static void main(String args[]){
        int integers[]={5,10,5,15};
        findCombinationSet(integers,0,integers.length);
    }

    private static void findCombinationSet(int[] integers, int start, int end) {
        if(stackSum == TARGET_SUM){
            printStack(stack);
        }

        for(int i = start;i<end; i++){
            if(stackSum+integers[i]<=TARGET_SUM){
                stackSum+=integers[i];
                stack.push(integers[i]);

                findCombinationSet(integers,i+1,end);
                stackSum-=stack.pop();
            }
        }
    }

    private static void printStack(Stack<Integer> stack) {
        StringBuffer sb = new StringBuffer();
        sb.append(TARGET_SUM +"=");
        for(Integer i:stack){
            sb.append(i+"+");
        }
        sb = sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }
}

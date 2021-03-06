package com.selim;


import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by mohammadselimmiah on 16/06/2016.
 */
public class TargetSumSet {
    static void sum_up_recursive(ArrayList<Integer> numbers, int target, ArrayList<Integer> partial) {
        int s = 0;
        for (int x: partial)
            s += x;

        if (s == target)
            System.out.println("sum("+ Arrays.toString(partial.toArray())+")="+target);

        if (s >= target)
            return;

        for(int i=0;i<numbers.size();i++) {
            ArrayList<Integer> remaining = new ArrayList<Integer>();
            int n = numbers.get(i);
            for (int j=i+1; j<numbers.size();j++)
                remaining.add(numbers.get(j));
            ArrayList<Integer> partial_rec = new ArrayList<Integer>(partial);
            partial_rec.add(n);
            sum_up_recursive(remaining,target,partial_rec);
        }
    }
    static void sum_up(ArrayList<Integer> numbers, int target) {
        sum_up_recursive(numbers,target,new ArrayList<Integer>());
    }
    public static void main(String args[]) {
        Integer[] numbers = {5,5,15,10};
        int target = 15;
        sum_up(new ArrayList<Integer>(Arrays.asList(numbers)),target);
    }
}

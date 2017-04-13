import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



public class Solution {
    private static boolean isSolvable(int m, int[] arr, int i) {
        if (i < 0 || arr[i] == 1)
            return false;
        if ((i == arr.length - 1) || i + m > arr.length - 1)
            return true;

        arr[i] = 1;
        return isSolvable(m, arr, i + 1) || isSolvable(m, arr, i - 1) || isSolvable(m, arr, i + m);
    }

    public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int T,n,m;
        Scanner sc = new Scanner(System.in);
        T=sc.nextInt();
        int arr[];

        for (int i = 0; i <T ; i++) {
            n=sc.nextInt();
            m=sc.nextInt();
            arr=new int[n];
            for(int j=0;j<n;j++)
                arr[j]=sc.nextInt();
            System.out.println(isSolvable(m,arr,0)?"YES":"NO");
        }

    }
}

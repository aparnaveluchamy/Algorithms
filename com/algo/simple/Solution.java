package com.algo.simple;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    	/*4
    	5
    	1 4 5 3 2
    	4
    	4
    	2 2 4 3*/
        //Scanner scanner = new Scanner(System.in);
        int t = 2;
        String [] result = new String[t];
        for (int i=0; i<t; i++){
            int m = 4;
            int n = 5;
            int a[] = {1, 4, 5, 3, 2};
            /*for (int j=0; j<n; j++){
                a[0] = scanner.nextInt();
            }*/
            for (int c = 0; c<n-1;c++){
                if (a[c] < m){
                for (int d =c+1; d<n; d++){
                    if (a[c]+a[d] == m){
                        result[i] = new String((c+1) + " " + (d+1));
                        break;
                    }
                }
                }
            }
        }
        for (int i=0; i<t; i++){
            System.out.println(result[i]);
        }
    }
}
package com.ghy.www;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt();
            int[] ints = new int[x];
            for (int i = 0; i < x; i++) {
                ints[i] = sc.nextInt();
            }
            int a = 0, b = 0;
            ArrayList<Integer> list = new ArrayList();
            for (int i = 0; i < x; i++) {
                for (int j = i-1; j > 0; j--) {
                    if (ints[j-1] <= ints[j]) {
                        a++;
                    } else {
                        break;
                    }
                }
                for (int j = i+1; j < x; j++) {
                    if (ints[j] <= ints[j-1]) {
                        b++;
                    } else {
                        break;
                    }
                }
                list.add(Integer.valueOf(a + b));
            }
            Integer max = Collections.max(list);
            System.out.println(max);
        }

    }
}

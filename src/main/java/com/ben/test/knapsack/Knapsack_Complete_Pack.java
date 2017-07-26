package com.ben.test.knapsack;

import java.util.Arrays;

/**
 * Created by ben on 2017/7/25.
 */
public class Knapsack_Complete_Pack {
    public int knapsack1(int[][] goods, int weight) {
        int[] f = new int[weight + 1];
        int len = goods.length;
        for (int i = 0; i < len; i++) {
            int c = goods[i][0];
            int v = goods[i][1];
            completePack(f, c, v, weight);
            System.out.println(Arrays.toString(f));
        }

        return f[weight];
    }

    public void completePack(int[] f, int c, int v, int weight) {
        //from w to ci,  1 goods can only be picked 1 time.
        for (int j = weight; j >= c; j--) {
            int a = f[j];
            int b = f[j - c];
            int d = f[j - c] + v;
            f[j] = Math.max(f[j], f[j - c] + v);
        }
    }
}

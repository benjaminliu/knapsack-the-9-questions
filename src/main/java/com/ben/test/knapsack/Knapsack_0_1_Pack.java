package com.ben.test.knapsack;

import java.util.Arrays;

/**
 * Created by ben on 2017/7/25.
 */
public class Knapsack_0_1_Pack {
    public int knapsack(int[][] goods, int w) {
        int len = goods.length;
        int[][] v = new int[len + 1][w + 1];

        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= w; j++) {
                //when there is enough space for another goods, we should add it up
                if (j >= goods[i - 1][0]) {
                    //how many space left
                    int t = j - goods[i - 1][0];
                    int cost = goods[i - 1][1] + v[i - 1][t];
                    v[i][j] = Math.max(cost, v[i - 1][j]);
                } else {
                    v[i][j] = v[i - 1][j];
                }
            }
        }

        for (int i = 0; i <= len; i++) {
            System.out.print(Arrays.toString(v[i]));
            System.out.println();
        }
        return v[len][w];
    }

    public int knapsack1(int[][] goods, int weight) {
        int[] f = new int[weight + 1];
        int len = goods.length;
        for (int i = 0; i < len; i++) {
            int c = goods[i][0];
            int v = goods[i][1];
            zeroOnePack(f, c, v, weight);
            System.out.println(Arrays.toString(f));
        }

        return f[weight];
    }

    public void zeroOnePack(int[] f, int c, int v, int weight) {
        //from w to ci,  1 goods can only be picked 1 time.
        for (int j = weight; j >= c; j--) {
            int a = f[j];
            int b = f[j - c];
            int d = f[j - c] + v;
            f[j] = Math.max(f[j], f[j - c] + v);
        }
    }
}

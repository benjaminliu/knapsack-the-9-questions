package com.ben.test.knapsack;

import java.util.Arrays;

/**
 * Created by ben on 2017/7/26.
 */
public class Knapsack_Multiple_Pack {
    private Knapsack_0_1_Pack zeroOne = new Knapsack_0_1_Pack();
    private Knapsack_Complete_Pack complete = new Knapsack_Complete_Pack();

    public int knapsack1(int[][] goods, int weight) {
        int[] f = new int[weight + 1];
        int len = goods.length;
        for (int i = 0; i < len; i++) {
            int c = goods[i][0];
            int v = goods[i][1];
            multiplePack(f, c, v, i + 1, weight);
            System.out.println(Arrays.toString(f));
        }

        return f[weight];
    }

    public void multiplePack(int[] f, int c, int v, int m, int weight) {
        if (c * m >= weight) {
            complete.completePack(f, c, v, weight);
            return;
        }
        int k = 1;
        while (k < m) {
            zeroOne.zeroOnePack(f, k * c, k * v, weight);
            m -= k;
            k *= 2;
        }
        zeroOne.zeroOnePack(f, c * m, v * m, weight);
    }
}

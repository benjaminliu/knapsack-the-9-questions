package com.ben.test;

import com.ben.test.knapsack.Knapsack_0_1_Pack;
import com.ben.test.knapsack.Knapsack_Complete_Pack;
import com.ben.test.knapsack.Knapsack_Multiple_Pack;

import static java.lang.System.out;

/**
 * Created by ben on 2017/7/25.
 */
public class Main {
    public static void main(String args[]) {
        long startTime = System.currentTimeMillis();
        int weight = 8;
        int[][] goods = new int[][]{{5, 4}, {6, 5}, {3, 3}, {4, 6}, {2, 6}};

        Knapsack_Multiple_Pack m = new Knapsack_Multiple_Pack();
        int i2 = m.knapsack1(goods, weight);
        out.println(i2);

//        Knapsack_Complete_Pack c = new Knapsack_Complete_Pack();
//        int i = c.knapsack1(goods, weight);
//        out.println(i);
//
//        Knapsack_0_1_Pack z = new Knapsack_0_1_Pack();
//        //int knapsack = k.knapsack(goods, weight);
//        int i1 = z.knapsack1(goods, weight);
//        out.println(i1);

        long endTime = System.currentTimeMillis();
        System.out.println("\n\rTotal time: " + (endTime - startTime) + "ms");
    }
}

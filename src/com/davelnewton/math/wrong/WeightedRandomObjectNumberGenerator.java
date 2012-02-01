package com.davelnewton.math.wrong;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Hi.
 */
public class WeightedRandomObjectNumberGenerator {

    private double[] totals;
    private List<? extends Weighted<?>> objects;

    public WeightedRandomObjectNumberGenerator(List<? extends Weighted<?>> objects) {
        this.objects = objects;
        totals = new double[objects.size()];
        init();
    }

    private void init() {
        int i = 0;
        double runningTotal = 0;
        for (Weighted<?> o : objects) {
            runningTotal += o.getWeight();
            totals[i++] = runningTotal;
        }
    }

    public Weighted<?> next() {
        Random rnd = new Random(System.nanoTime());
        double rndNum = rnd.nextDouble() * totals[totals.length - 1];
        int sNum = Arrays.binarySearch(totals, rndNum);
        int idx = (sNum >= 0) ? sNum : (Math.abs(sNum) - 1);
        return objects.get(idx);
    }

}

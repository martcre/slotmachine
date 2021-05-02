package org.example.slotmachine;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@AllArgsConstructor
@Log
public class Slotmachine {


    private int maxValue;
    private int minValue;
    private int bars;
    private double probability;
    private double spread;

    public Slotmachine() {
        maxValue = 12;
        minValue = 1;
        bars = 3;
        probability = 0.4;
        spread = 0.05;
    }

    public static boolean isWin(int[] result) {
        return (result[0] == result[1] && result[1] == result[2]);
    }

    public int[] run() {
        int[] result = new int[bars];
        if (Math.random() <= probability + ((Math.random() * (2 * spread)) - spread)) {
            int value = getRandom();
            for (int i = 0; i < bars; i++) {
                result[i] = value;
            }
        } else {
            for (int i = 0; i < bars; i++) {
                result[i] = getRandom();
            }
            if (isWin(result)) {
                int mixinPosition = (int) Math.floor(3 * Math.random());
                int mixin = 1;
                if (result[mixinPosition] == maxValue) {
                    mixin = -1;
                }
                result[mixinPosition] = result[mixinPosition] + mixin;
            }
        }
        return result;
    }

    private int getRandom() {
        return ((int) Math.round((maxValue - 1) * Math.random())) + minValue;
    }
}

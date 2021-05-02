package org.example.slotmachine;

import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Test;

@Log
public class TestSlotmachine {

    @Test
    public void testRun() {
        Slotmachine slotmachine = new Slotmachine(12, 1, 3, 0.4, 0.05);

        int limit = 1000;
        int winCount = 0;

        for (int i = 0; i < limit; i++) {
            if (Slotmachine.isWin(slotmachine.run())) {
                winCount++;
            }
        }

        double probability = ((double) winCount / (double) limit);

        double range = 0.05;
        double expected = 0.4;

        log.info("Limit: " + limit + " Wins: " + winCount + " Probability: " + probability);

        Assert.assertTrue((probability >= (expected - range) && probability <= (expected + range)));

    }

}

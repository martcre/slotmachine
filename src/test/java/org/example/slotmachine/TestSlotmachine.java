package org.example.slotmachine;

import lombok.extern.java.Log;
import org.junit.Assert;
import org.junit.Test;

@Log
public class TestSlotmachine {

    @Test
    public void testRun() {
        double spread = 0.05;
        double probability = 0.4;
        int limit = 1000;

        Slotmachine slotmachine = new Slotmachine(12, 1, 3, probability, spread);

        int winCount = 0;

        for (int i = 0; i < limit; i++) {
            if (Slotmachine.isWin(slotmachine.run())) {
                winCount++;
            }
        }

        double probabilityResult = ((double) winCount / (double) limit);



        log.info("Limit: " + limit + " Wins: " + winCount + " Probability: " + probabilityResult);

        Assert.assertTrue((probabilityResult >= (probability - spread) && probabilityResult <= (probability + spread)));

    }

}

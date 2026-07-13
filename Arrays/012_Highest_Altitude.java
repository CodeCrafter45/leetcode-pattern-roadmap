/*
 * Problem: Find the Highest Altitude
 * * Approach:
 * Solved using the Prefix Sum pattern. We start at an initial altitude of 0 and 
 * sequentially accumulate the net gain/loss (`gain[i]`) at each point. By keeping 
 * track of a running sum (`currentAltitude`) and updating our global maximum 
 * (`maxAltitude`) at each step, we find the peak altitude achieved during the journey.
 * * Complexity:
 * - Time Complexity: O(n) - Single pass iteration through the 'gain' array.
 * - Space Complexity: O(1) - Constant auxiliary space, tracking values via primitive variables.
 */
class Solution {
    public int largestAltitude(int[] gain) {
        int altitudesum = 0;
        int highestaltitude = 0;

        for (int i = 0; i < gain.length; i++) {
            altitudesum += gain[i];

            if (altitudesum > highestaltitude) {
                highestaltitude = altitudesum;
            }
        }

        return highestaltitude;

    }
}
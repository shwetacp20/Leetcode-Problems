import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // Step 1: Find the maximum number of candies currently owned by any kid
        int maxCandies = 0;
        for (int candy : candies) {
            if (candy > maxCandies) {
                maxCandies = candy;
            }
        }
        
        // Step 2: Create a list to store the boolean results
        List<Boolean> result = new ArrayList<>();
        
        // Step 3: Check each kid's potential total
        for (int candy : candies) {
            // If the kid's candies + extraCandies >= maxCandies, they have the greatest
            result.add(candy + extraCandies >= maxCandies);
        }
        
        return result;
    }
}
package main.java.dev.arrays;

//Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
//
//
//
//Example 1:
//
//Input: nums = [0,1]
//Output: 2
//Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
//
//Example 2:
//
//Input: nums = [0,1,0]
//Output: 2
//Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
//
//Example 3:
//
//Input: nums = [0,1,1,1,1,1,0,0,0]
//Output: 6
//Explanation: [1,1,1,0,0,0] is the longest contiguous subarray with equal number of 0 and 1.
//
//
//
//Constraints:
//
//        1 <= nums.length <= 105
//nums[i] is either 0 or 1.


public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int maxGlobalLength = 0;
        int[] continuousSumArray = new int[nums.length];
        continuousSumArray[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            continuousSumArray[i] = continuousSumArray[i - 1] + nums[i];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            int maxLocalLength;

            if (i % 2 == 0) {
                maxLocalLength = i;
            } else {
                maxLocalLength = i + 1;
            }
            if (maxLocalLength < maxGlobalLength) {
                if(i%2!=0){
                    break;
                }
                continue;
            }

            for (int j = i - maxLocalLength + 1; j < i; j += 2) {
                int currentLength = i - j + 1;

                if(currentLength<maxGlobalLength){
                    break;
                }

                int currentSum = continuousSumArray[i];
                if (j != 0) {
                    currentSum -= continuousSumArray[j - 1];
                }
                if (currentLength / 2 == currentSum) {
                    maxGlobalLength = Math.max(maxGlobalLength, currentLength);
                }
            }
        }
        return maxGlobalLength;
    }

    public static void main(String args[]) {
        ContiguousArray test = new ContiguousArray();
        System.out.println(test.findMaxLength(new int[]{0,1,1,1,1,1,0,0,0}));
    }

    // This took about 2.5 hours
}

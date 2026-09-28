package main.java.dev.arrays;

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

    // This took about 2.5 hours :(
}

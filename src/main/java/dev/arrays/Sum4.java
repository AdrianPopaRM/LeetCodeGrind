package main.java.dev.arrays;

import java.util.*;

public class Sum4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Map<Integer, Integer> numAndIndexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numAndIndexes.put(nums[i], numAndIndexes.getOrDefault(nums[i], 0) + 1);
        }

        Set<List<Integer>> solutionSet = new HashSet<>();

        for (Integer num1 : numAndIndexes.keySet()) {
            for (Integer num2 : numAndIndexes.keySet()) {
                if (num1.equals(num2)) {
                    if (numAndIndexes.get(num1) < 2) {
                        continue;
                    }
                }
                Integer rest = target - (num1 + num2);
                Integer combinationWithNum1 = rest - num1;
                if (numAndIndexes.containsKey(combinationWithNum1)) {

                }

                Integer combinationWithNum2 = rest - num2;
            }
        }
        return List.of(List.of(-1));
    }


    public List<List<Integer>> fourSumBruteForce(int[] nums, int target) {
        Map<Long, Integer> numAndIndexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numAndIndexes.put((long) nums[i], numAndIndexes.getOrDefault(nums[i], 0) + 1);
        }
        Set<List<Long>> solutionSet = new HashSet<>();
        for (Long num1 : numAndIndexes.keySet()) {
            for (Long num2 : numAndIndexes.keySet()) {
                if (num2.equals(num1)) {
                    if (numAndIndexes.get(num1) < 2) {
                        continue;
                    }
                }
                for (Long num3 : numAndIndexes.keySet()) {
                    if (num1.equals(num3)) {
                        if (numAndIndexes.get(num1) < 2) {
                            continue;
                        }
                    }
                    if (num2.equals(num3)) {
                        if (numAndIndexes.get(num2) < 2) {
                            continue;
                        }
                    }
                    if (num1.equals(num3) && num2.equals(num3)) {
                        if (numAndIndexes.get(num3) < 3) {
                            continue;
                        }
                    }

                    Long complementary = target - (num1 + num2 + num3);

                    if (!numAndIndexes.containsKey(complementary)) {
                        continue;
                    }

                    if (num1.equals(complementary)) {
                        if (numAndIndexes.get(complementary) < 2) {
                            continue;
                        }
                    }

                    if (num2.equals(complementary)) {
                        if (numAndIndexes.get(complementary) < 2) {
                            continue;
                        }
                    }

                    if (num3.equals(complementary)) {
                        if (numAndIndexes.get(complementary) < 2) {
                            continue;
                        }
                    }

                    if (num1.equals(num2) && num2.equals(complementary)) {
                        if (numAndIndexes.get(complementary) < 3) {
                            continue;
                        }
                    }
                    if (num1.equals(num3) && num3.equals(complementary)) {
                        if (numAndIndexes.get(complementary) < 3) {
                            continue;
                        }
                    }
                    if (num2.equals(num3) && num3.equals(complementary)) {
                        if (numAndIndexes.get(complementary) < 3) {
                            continue;
                        }
                    }

                    if (num1.equals(num2) && num2.equals(num3) && num3.equals(complementary)) {
                        if (numAndIndexes.get(complementary) < 4) {
                            continue;
                        }
                    }
                    List<Long> currentQuadruple = new ArrayList<>(List.of(num1, num2, num3, complementary));
                    currentQuadruple.sort(Comparator.naturalOrder());
                    solutionSet.add(currentQuadruple);
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (List<Long> line : solutionSet) {
            List<Integer> currentLine = new ArrayList<>();
            for (long num : line) {
                currentLine.add((int) num);
            }
            result.add(currentLine);
        }
        return result;
    }

    public static void main(String args[]) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        Sum4 test = new Sum4();
        System.out.println(test.fourSumBruteForce(nums, 0));
    }
}

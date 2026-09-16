package main.java.dev.arrays;

import java.util.*;

public class Sum3 {
//    public List<List<Integer>> threeSum(int[] nums) {
////        List<Integer> list = new ArrayList<>();
////        list.sort(Comparator.naturalOrder());
//        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
//
//        Set<List<Integer>> set = new HashSet<>();
//        int size = nums.length;
//        for(int i=0; i < size; i++){
//            map.putIfAbsent(nums[i], new ArrayList<>());
//            map.get(nums[i]).add(i);
//        }
//        for(int i=0; i<size;i++){
//            for(int j=0; j<size; j++){
//                int currentSum= nums[i] + nums[j];
//                if(i!=j && map.containsKey(-currentSum)){
//                    if(!map.get(-nums[i]+nums[j]).contains(i) && !map.get(-currentSum).contains(j)) {
//                        List<Integer> list =new ArrayList<>(List.of(nums[i], nums[j], -nums[i] +nums[j]));
//                        list.sort(Comparator.naturalOrder());
//                        set.add(list);
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(set);
//    }

public List<List<Integer>> threeSum(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();

    Set<List<Integer>> resultSet = new HashSet<>();
    int size = nums.length;
    for (int num : nums) {
        map.put(num, map.getOrDefault(num, 0) + 1);
    }

    for(Integer num1 : map.keySet()){
        for(Integer num2 : map.keySet()){
            if(num1.equals(num2) && map.get(num1)==1){
                continue;
            }
            int complementary = -(num1+num2);
            if(map.containsKey(complementary)){
                if(complementary==num1 && map.get(num1)==1 || complementary==num2 && map.get(num2)==1 || complementary == num1 && complementary == num2 && map.get(num1)<3){
                    continue;
                }
                List<Integer> list = new ArrayList<>(List.of(num1,num2,complementary));
                list.sort(Comparator.naturalOrder());
                resultSet.add(list);
            }
        }
    }
    return new ArrayList<>(resultSet);
}


    public static void main(String args[]){
        Sum3 s = new Sum3();
        int nums1[] = {-1,0,1,2,-1,-4};
        for(List<Integer> l : s.threeSum(nums1)){
            System.out.println(l);
        }
    }
}

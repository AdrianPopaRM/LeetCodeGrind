import main.java.dev.arrays.*;
import main.java.dev.hashing.RandomizedSet;
import main.java.dev.strings.ValidAnagram;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
//        testJumpGame2();
//        Test test=new Test();
//        testProductOfArrayExceptSelf();
//        testGasStation();
//        testCandy();
//        testSubarraySumEqualsK();
//        testContainerWithMostWatter();
//        testLongestSubstringWithoutRepeatingCharacters();
        testLongestRepeatingCharacterReplacement();
    }


    static void testAnagram(){
        ValidAnagram problem=new ValidAnagram();
        System.out.print(problem.solve("anagram", "nagram"));
    }

    static void testDynamicArray(){
        DynamicArray array= new DynamicArray(3);
        array.pushback(1);
        array.pushback(2);
        array.pushback(3);
        System.out.println(array.getSize());
        System.out.println(array.getCapacity());
        array.pushback(4);
        System.out.println(array.getSize());
        System.out.println(array.getCapacity());
    }

    static void testMergeSortedArray(){
        MergeSortedArray a=new MergeSortedArray();
        int[] nums1={1,2,3};
        int[] nums2={2,5,6};
        a.merge(nums1,3,nums2,3);
    }

    static void testRotateArray(){
        int[] array={-1,-100,3,99};
        RotateArray test=new RotateArray();
        test.rotateEfficient(array,2);
    }

    static void testBestTimeToBuyAndSellStock(){
        int[] prices={7,6,4,3,1};
        int[] prices2={7,1,5,3,6,4};
        BestTimeToBuyAndSellStock test=new BestTimeToBuyAndSellStock();
        System.out.println(test.maxProfit(prices));
        System.out.println(test.maxProfit(prices2));

    }

    static void testBestTimeToBuyAndSellStock2(){
        int[] prices={1,2,3,4,5};
        int[] prices2={7,6,4,3,1};
        BestTimeToBuyAndSellStock2 test=new BestTimeToBuyAndSellStock2();
        System.out.println(test.maxProfit(prices));
        System.out.println(test.maxProfit(prices2));

    }

    static void testJumpGame(){
        JumpGame test= new JumpGame();
        int[] nums={2,3,1,1,4};
        int[] nums2={3,2,1,0,4};
        int[] nums3={0,1};
        int[] nums4={3,0,8,2,0,0,1};
        System.out.println(test.canJumpOptimal(nums4));
        System.out.println(test.canJumpOptimal(nums3));
        System.out.println(test.canJumpOptimal(nums2));
        System.out.println(test.canJumpOptimal(nums));

    }

    static void testJumpGame2(){
        JumpGame2 test= new JumpGame2();
        int[] nums={2,3,1,1,4};
        int[] nums2={1,2,3};
        int[] nums3={5,4,0,1,3,6,8,0,9,4,9,1,8,7,4,8};
//        System.out.println(test.jump(nums2));
//        System.out.println(test.jump(nums));
        System.out.println(test.jump(nums));
    }

    static void testHIndex(){
        int[] arr={3,0,6,1,5};
        int[] arr2={1};
        HIndex test=new HIndex();
        System.out.println(test.hIndex(arr2));
    }

    static void testRandomizedSet(){
        RandomizedSet test=new RandomizedSet();
        test.insert(1);
        test.insert(2);
        test.insert(3);
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());
        System.out.println(test.getRandom());

    }

    static void testProductOfArrayExceptSelf(){
        ProductOfArrayExceptSelf test= new ProductOfArrayExceptSelf();
        int[] nums = {1,2,3,4};
        int[] nums2 = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(test.productExceptSelfWithoutDivision(nums)));
        System.out.println(Arrays.toString(test.productExceptSelfWithoutDivision(nums2)));
    }

    static void testGasStation(){
        GasStation test= new GasStation();
        int[] gas={1,2,3,4,5};
        int[] cost={3,4,5,1,2};

        int[] gas1={2,3,4};
        int[] cost1={3,4,3};
        System.out.println(test.canCompleteCircuit(gas1,cost1));
    }

    static void testContainerWithMostWatter(){
        ContainerWithMostWatter c = new ContainerWithMostWatter();
        int[] arr1={1,2,4,3};
        int[] arr2={1,8,6,2,5,4,8,3,7};
        System.out.println(c.maxAreaOptimal(arr1));
        System.out.println(c.maxAreaOptimal(arr2));

    }
    static void testSubarraySumEqualsK(){
        SubarraySumEqualsK s=new SubarraySumEqualsK();
        int[] arr1={1,1,1};
        int[] arr2={1,-1,5,-2,3};
        int[] arr3={1};
//        System.out.println(s.subarraySum(arr1,2));
//        System.out.println(s.subarraySum(arr2,3));
        System.out.println(s.subarraySum(arr3,0));
    }

    static void testCandy(){
        Candy test=new Candy();
        int[] ratings1={1,0,2};
        int[] ratings2={1,2,2};
        int[] ratings3={1,2,87,87,87,2,1};
        int[] ratings4={1,6,10,8,7,3,2};
        int[] ratings5={1,3,4,5,2};
        System.out.println(test.candy(ratings1)+" expected 5");
        System.out.println(test.candy(ratings2)+" expected 4");
        System.out.println(test.candy(ratings3)+" expected 13");
        System.out.println(test.candy(ratings4)+" expected 18");
        System.out.println(test.candy(ratings5)+" expected 11");

    }

    static void testLongestSubstringWithoutRepeatingCharacters(){
        LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
        String s1="abcabcbb";
        String s2="bbbbb";
        String s3="pwwkew";
        String s4="aabaab!bb";

        System.out.println(l.lengthOfLongestSubstring(s1));
        System.out.println(l.lengthOfLongestSubstring(s2));
        System.out.println(l.lengthOfLongestSubstring(s3));
        System.out.println(l.lengthOfLongestSubstring(s4));
    }

    static void testLongestRepeatingCharacterReplacement(){
        LongestRepeatingCharacterReplacement l = new LongestRepeatingCharacterReplacement();
        String s1="ABAB";
        String s2="AABABBA";
        System.out.println(l.characterReplacement(s1,2));
        System.out.println(l.characterReplacement(s2,1));
    }
}

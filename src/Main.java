import java.util.Arrays;

public class Main {
    public static void main(String[] args){
//        testJumpGame2();
//        Test test=new Test();
        testProductOfArrayExceptSelf();
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
}

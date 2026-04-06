import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElementInefficient(int[] nums) {
        int majority=nums[0];
        for(int i=0;i<nums.length;i++){
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    count++;
                }
            }
            if(count>nums.length/2){
                majority=nums[i];
                break;
            }
        }
        return majority;
    }

    public int majorityElement(int[] nums) {
        Map<Integer,Integer> freq=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(freq.containsKey(nums[i])){
                freq.replace(nums[i],freq.get(nums[i])+1);
                if(freq.get(nums[i])>nums.length/2){
                    return nums[i];
                }
            }
            else{
                freq.put(nums[i],1);
            }
        }
        return nums[0];
    }
}

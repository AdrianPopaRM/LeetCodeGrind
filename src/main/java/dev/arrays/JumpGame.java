package main.java.dev.arrays;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int currentIndex=0,targetIndex=nums.length-1;
        int jump= nums[currentIndex];
        while(currentIndex!=targetIndex){
            int possibleJump=currentIndex+jump;
            if(possibleJump>targetIndex){
                currentIndex=targetIndex;
                break;
            }
            if(nums[possibleJump]==0&&possibleJump!=targetIndex){
                jump--;
            }
            if(jump<=0){
                break;
            }
                currentIndex+=jump;
                jump= nums[currentIndex];
        }
        return currentIndex==targetIndex;
    }

    public boolean canJumpOptimal(int[] nums) {
        if(nums.length==1){
            return true;
        }
        int farthestReach=0;
        for(int i=0;i<nums.length;i++, farthestReach--){
            if(farthestReach<0){
                return false;
            }
            if(farthestReach<nums[i]){
                farthestReach=nums[i];
            }
        }
        return true;
    }
}

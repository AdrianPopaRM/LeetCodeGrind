public class JumpGame2 {
//    public int jump(int[] nums) {
//        int nrJumps=0, reach=nums[0]-1, target=nums.length-1;
//        for(int i=1;i<=target;i++,reach--){
//            if(i+reach>=target){
//                return nrJumps+=1;
//            }
//            if(reach==0){
//                nrJumps++;
//                reach=nums[i];
//                continue;
//            }
//            if(i+reach+nums[i+reach]>=target){
//                return nrJumps+=2;
//            }
//            else{
//                if(nums[i]>reach+nums[i+reach]){
//                    nrJumps++;
//                    reach=nums[i];
//                }
//            }
//        }
//        return nrJumps;
//    }

    public int jump(int[] nums){
        int nrJumps=0;
        int furthestPoint=0;
        int currentEnd=0;
        for(int i=0;i<nums.length-1;i++){
            furthestPoint=Math.max(furthestPoint,nums[i]+i);
            if(currentEnd==i){
                nrJumps++;
                currentEnd=furthestPoint;
            }

        }
        return nrJumps;
    }

//    public int jump(int[] nums){
//
//        int nrJumps=0, reach=nums[0]-1, target=nums.length-1;
//        int furthestReachIndex=0, furthestReachValue= nums[0];
//        for(int i=0; i<target;i++, reach--){
//            if(i+reach>=target){
//                nrJumps++;
//                break;
//            }
//            if(nums[i]>furthestReachValue){
//                furthestReachValue=nums[i];
//                furthestReachIndex=i;
//            }
//
//            if(reach==0){
//                reach=furthestReachValue-(furthestReachIndex-i);
//                nrJumps++;
//            }
//        }
//        return nrJumps;
//
//    }
}

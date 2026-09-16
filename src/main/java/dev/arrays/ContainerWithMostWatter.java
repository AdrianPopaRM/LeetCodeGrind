package main.java.dev.arrays;

public class ContainerWithMostWatter {
    //I've established the following:
    //The formula for calculating the watter volume is: (indexRight-IndexLeft) * min(height[indexRight], height[indexLeft])

    public int maxArea(int[] height) {
        int indexLeft=0, indexRight=1;
        int currentMaxVolume= calculateArea(indexLeft,indexRight,height[indexLeft],height[indexRight]);


        for(int currentIndex=2;currentIndex<height.length;currentIndex++){
//            if(height[indexRight]>height[indexLeft]){
//                if(height[currentIndex]>height[indexLeft]){
//                    indexLeft=indexRight;
//                    indexRight=currentIndex;
//                }
//            }
            int sumUpdateBothBoundaries= calculateArea(indexRight, currentIndex, height[indexRight], height[currentIndex]);
            int sumUpdateRightBoundary= calculateArea(indexLeft, currentIndex, height[indexLeft], height[currentIndex]);
            if(sumUpdateBothBoundaries>sumUpdateRightBoundary){
                if(sumUpdateBothBoundaries>currentMaxVolume){
                    currentMaxVolume=sumUpdateBothBoundaries;
                    indexLeft=indexRight;
                    indexRight=currentIndex;
                }
            }
            else{
                if(sumUpdateRightBoundary>currentMaxVolume){
                    currentMaxVolume=sumUpdateRightBoundary;
                    indexRight=currentIndex;
                }
            }
        }
        return currentMaxVolume;
    }

    public int maxAreaOptimal(int[] height){
        int indexLeft=0, indexRight=height.length-1;
        int maxVolume=0;
        while(indexLeft<indexRight){
            maxVolume= Math.max(calculateArea(indexLeft,indexRight,height[indexLeft],height[indexRight]), maxVolume);
            if(height[indexLeft]<height[indexRight]){
                indexLeft++;
            }
            else{
                indexRight--;
            }
        }
        return maxVolume;
    }
    private int calculateArea(int indexLeft, int indexRight, int heightLeft, int heightRight){
        return (indexRight-indexLeft)*Math.min(heightRight,heightLeft);
    }
}

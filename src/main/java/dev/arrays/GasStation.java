package main.java.dev.arrays;

import java.util.Arrays;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(Arrays.stream(gas).sum()<Arrays.stream(cost).sum()){
            return -1;
        }
        int result=-1;
//        for(int i=0;i<gas.length;i++){
//            if(gas[i]>=cost[i]){
//                startingIndex=i;
//            }
//        }
//        int counter=0;
//        while(counter<gas.length){
//        }
        for(int i=0;i<gas.length;i++){
            int counter=0;
            int currentGas=0;
            if(gas[i]>=cost[i]){
                while(counter<gas.length){
                    currentGas+=gas[(i+counter)%gas.length];
                    currentGas-=cost[(i+counter)%gas.length];
                    counter++;
                    if(currentGas<=0){
                        break;
                    }
                }
                if(counter==gas.length){
                    result=i;
                    break;
                }
            }
        }
        return result;
    }
}

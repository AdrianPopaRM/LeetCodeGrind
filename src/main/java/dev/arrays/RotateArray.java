package main.java.dev.arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        if(nums.length==1){
            return;
        }
        if(k==nums.length){
            return;
        }
        if(k>nums.length){
            k=k%nums.length;
        }
        int counter = 0;
        while (counter != k) {
            int previous=nums[0];
            nums[0]=nums[nums.length-1];
            for(int i=1;i<nums.length;i++){
                int aux=previous;
                previous=nums[i];
                nums[i]=aux;
            }
            counter++;
        }
    }


    public void rotateEfficient(int[] nums, int k) {
        if(k>nums.length){
            k=k%nums.length;
        }

        int counter=0,current=0;
        int previous=nums[0];

        if(nums.length%2!=0){
            while (counter < nums.length) {
                int aux = previous;
                previous = nums[(current + k) % nums.length];
                nums[(current + k) % nums.length] = aux;
                counter++;
                current = (current + k) % nums.length;
            }
        }
        else{
            while (counter < nums.length/2) {
                int aux = previous;
                previous = nums[(current + k) % nums.length];
                nums[(current + k) % nums.length] = aux;
                counter++;
                current = (current + k) % nums.length;
            }
            counter=nums.length/2;
            current=1;
            previous=nums[1];
            while (counter < nums.length) {
                int aux = previous;
                previous = nums[(current + k) % nums.length];
                nums[(current + k) % nums.length] = aux;
                counter++;
                current = (current + k) % nums.length;
            }
        }
    }


    public void rotateBest(int[] nums, int k) {
        int n = nums.length;
        k %= n; // Handle k > n

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}

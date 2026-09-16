package main.java.dev.arrays;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=0,j=0;
        int[] answer=new int[m+n];
        int k=0;
        while(i<m||j<n){
            if(i==m){
                answer[k]=nums2[j];
                j++;
                k++;
                continue;
            }
            if(j==n){
                answer[k] = nums1[i];
                i++;
                k++;
                continue;
            }
            if(nums1[i]>=nums2[j]) {
                answer[k] = nums2[j];
                j++;
                k++;
                continue;
            }
            answer[k] = nums1[i];
            k++;
            i++;
        }
        for(i=0;i<n+m;i++){
            nums1[i]=answer[i];
        }
    }
}

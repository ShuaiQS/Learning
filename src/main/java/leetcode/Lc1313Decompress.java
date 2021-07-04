package leetcode;

import java.util.Arrays;

public class Lc1313Decompress {
    public static int[] decompressRLElist(int[] nums) {
        int len = 0;
        for(int i=0;i<nums.length;i+=2){
            len+=nums[i];
        }
        int[] result = new int[len];
        int temp;
        for(int i=0,j=0;i<nums.length-1;i+=2){
            temp = nums[i+1];
            for(int k=0;k<nums[i];k++){
                result[j++] = temp;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Arrays.stream(decompressRLElist(new int[]{1,2,3,4,5,8,3,4})).forEach(System.out::println);
    }
}

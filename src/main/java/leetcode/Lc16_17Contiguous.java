package leetcode;

public class Lc16_17Contiguous {
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        if(nums.length==1) return nums[0];
        int temp = nums[0];
        for(int i=1;i<nums.length;i++){
            temp = Math.max(temp+nums[i],nums[i]);
            max = Math.max(max, temp);
        }
        return max;
    }
}

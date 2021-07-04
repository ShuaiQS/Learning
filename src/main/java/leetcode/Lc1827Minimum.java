package leetcode;

public class Lc1827Minimum {

    public int minOperations(int[] nums) {
        int result=0;
        if(nums.length>1) {
            int temp=nums[0];
            for(int i=1;i<nums.length;i++){
                if(nums[i]<=temp){
                    temp = temp+1;
                    result+=temp-nums[i];
                }else {
                    temp = nums[i];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Lc1827Minimum().minOperations(new int[]{}));
    }
}

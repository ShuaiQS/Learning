package leetcode;

public class Lc135Candy {
    public static void main(String[] args) {
        int[] r = {1,3,4,5,2};
        System.out.println(candy(r));
        System.out.println(candy1(r));
    }

    private static int candy(int[] ratings) {
        int sum = 0;
        int len = ratings.length;
        if(len<2) return len;
        int[] save = new int[len];
        save[0] = 1;
        for(int i=1;i<ratings.length;i++){
            if(ratings[i]>ratings[i-1])
                save[i] = save[i-1]+1;
            else save[i] = 1;
        }

        for (int i=len-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]&&save[i]<=save[i+1]){
                save[i]=save[i+1]+1;
            }
            sum+=save[i+1];
        }
        return sum+save[0];
    }

    public static int candy1(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for (int i = 0; i < n; i++) {
            if (i > 0 && ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right++;
            } else {
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }
}

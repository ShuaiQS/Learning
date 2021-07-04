package leetcode;

public class LcLCP22Plan {
    public int paintingPlan(int n, int k) {
        if(k<n) return 0;
        if(k==n*n) return 1;
        int result = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i*n+j*n-i*j==k){
                    result+=getCij(n,i)*getCij(n,j);
                }
            }
        }
        return result;
    }

    private int getCij(int i,int j){
        int result = 1;
        int m=1;
        j=Math.min(j,i-j);
        for(int n=0;n<j;n++){
            result*=i--;
        }
        for(int n=j;n>0;n--){
            m*=n;
        }
        return result/m;
    }

    public static void main(String[] args) {
        System.out.println(new LcLCP22Plan().paintingPlan(2,3));
    }
}

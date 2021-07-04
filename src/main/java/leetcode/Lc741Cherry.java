package leetcode;

public class Lc741Cherry {
    public int cherryPickup(int[][] grid) {
        int result = 0;
        int n = grid.length;
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            if(grid[i][0]==-1) dp[i][0] = 0;

        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==-1) dp[i][j] = 0;
                else {
                    dp[i][j] = grid[i][j]+Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

    }
}

package leetcode;

public class Lc200NumberOfIslands {
    private int m;
    private int n;
    private int result=0;
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    result++;
                    dfs(grid,i,j);
                }
            }
        }
        return result;

    }
    private void dfs(char[][] grid,int i, int j){
        if(i<0||i>=m||j<0||j>=n) return;
        if(grid[i][j]=='1'){
            grid[i][j]='0';
            dfs(grid,i-1,j);
            dfs(grid,i+1,j);
            dfs(grid,i,j-1);
            dfs(grid,i,j+1);
        }
    }
}

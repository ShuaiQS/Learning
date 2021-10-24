package leetcode;

import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * 深度优先算法
     * @param grid 二维网格
     * @param i x
     * @param j y
     */
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

    /**
     * 广度优先算法
     * @param grid 二维网格
     * @param i x
     * @param j y
     */
    private void bfs(char[][] grid,int i, int j){
        Queue<Integer> queue = new LinkedList<>();
        grid[i][j]='0';
        queue.add(i*n+j);
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            int x = poll/n;
            int y = poll%n;
            if(x-1>=0&&grid[x-1][y]=='1') {grid[x-1][y]='0';queue.add((x-1)*n+y);}
            if(y-1>=0&&grid[x][y-1]=='1') {grid[x][y-1]='0';queue.add((x)*n+y-1);}
            if(x+1<m&&grid[x+1][y]=='1') {grid[x+1][y]='0';queue.add((x+1)*n+y);}
            if(y+1<n&&grid[x][y+1]=='1') {grid[x][y+1]='0';queue.add((x)*n+y+1);}
        }
    }
}

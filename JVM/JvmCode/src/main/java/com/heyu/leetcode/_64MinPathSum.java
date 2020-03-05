package com.heyu.leetcode;

public class _64MinPathSum {

    /**
     * 给定一个包含非负整数的 m x n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     *
     * 示例:
     *
     * 输入:
     * [
     *   [1,3,1],
     *   [1,5,1],
     *   [4,2,1]
     * ]
     * 输出: 7
     * 解释: 因为路径 1→3→1→1→1 的总和最小。
     *
     * 解题思路：用逆推的办法，算出各个点到右下角点的最小距离，
     * @param grid
     * @return
     */
    public static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = (rows - 1); i >= 0; i--) {
            for(int j = (cols -1); j >= 0; j--) {
                int curr = grid[i][j];
                if(j == cols - 1 && i != rows - 1) {
                    grid[i][j] = grid[i + 1][j] + curr;
                } else if(i == rows - 1 && j != cols - 1){
                        grid[i][j] = grid[i][j+1] + curr;
                } else if(i != rows - 1) {
                    grid[i][j] = Math.min(grid[i+1][j], grid[i][j+1]) + curr;
                }

            }
        }
        return grid[0][0];
    }

    public static void main(String[] args) {
        int res = minPathSum(new int[][]{
                {1,3,1},
                {1,5,1},
                {4,2,1}
        });
        System.out.println(res);
    }

}

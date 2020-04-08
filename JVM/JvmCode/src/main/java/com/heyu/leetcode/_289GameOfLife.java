package com.heyu.leetcode;

public class _289GameOfLife {

    /**
     * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
     *
     * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
     *
     * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
     * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
     * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
     * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
     * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
     *
     *
     * 示例：
     *
     * 输入：
     * [
     *   [0,1,0],
     *   [0,0,1],
     *   [1,1,1],
     *   [0,0,0]
     * ]
     * 输出：
     * [
     *   [0,0,0],
     *   [1,0,1],
     *   [0,1,1],
     *   [0,1,0]
     * ]
     */
    static int[] dis = {-1, 0, 1};

    public static void gameOfLife(int[][] borad){

        if(borad.length == 0 || borad[0] == null || borad[0].length == 0) return;

        int m = borad.length, n = borad[0].length;
        int[][] nextState = new int[m][n];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int tmpValue = borad[i][j];
                int live = countLife(borad, i, j);
                System.out.println(live);
                if(tmpValue == 0 && live == 3) {
//                    borad[i][j] = 2;
                    tmpValue = 1;
                } else if(tmpValue == 1 && (live > 3 || live < 2)) {
//                    borad[i][j] = -1;
                    tmpValue = 0;
                }
                nextState[i][j] = tmpValue;
            }
        }
        borad = nextState;
//        for(int i = 0; i < m; i++) {
//            for(int j = 0; j < n; j++) {
//                int tmpValue = borad[i][j];
//                if(tmpValue > 0) {
//                    borad[i][j] = 1;
//                } else borad[i][j] = 0;
//            }
//        }
    }

    private static int countLife(int[][] borad, int m, int n) {
        int result = 0;
        int rows = borad.length;
        int cols = borad[0].length;
        for (int i = 0; i < dis.length; i++) {
            for (int j = 0; j < dis.length; j++) {
                int tmpM = (m + dis[i]);
                int tmpN = (n + dis[j]);
                if(
                    tmpM >= 0 && tmpM < rows && tmpN >= 0 && tmpN < cols
                        &&(tmpM != m || tmpN != n)
//                            && Math.abs(borad[tmpM][tmpN]) == 1
                ){
//                    result += 1;
                    result += borad[tmpM][tmpN];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] borad = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        gameOfLife(borad);
    }

}

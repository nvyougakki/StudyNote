package com.heyu.leetcode;

public class Offer13MovingCount {
    static int result = 0;
    public static int movingCount(int m, int n, int k) {

        byte[][] visited = new byte[m][n];
        start(0,0,m,n,k,visited);
        return result;
    }

    public static void start(int i, int j, int m, int n, int k, byte[][] visited) {
        if(i>=0&&j>=0&&i<m&&j<n&&visited[i][j]==0&&(getIntValue(i) + getIntValue(j)) <= k) {
            result++;
            visited[i][j] = 1;
            start(i+1, j, m, n, k, visited);
            start(i, j+1, m, n, k, visited);
            start(i-1, j, m, n, k, visited);
            start(i, j-1, m, n, k, visited);
        }
    }

    public static int getIntValue(int i) {
        int tmp = i%10;
        i = i / 10;
        while (i > 0) {
            tmp += i % 10;
            i = i / 10;
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(11,8,16));
    }

}

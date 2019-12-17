package com.heyu.leetcode;

public class Convert_6 {

    public static String convert(String s, int numRows) {
        if(null == s || s.length() == 0) return "";
        if(numRows == 1) return s;
        String result = "";
        StringBuffer[] arr = new StringBuffer[numRows];
        for(int i = 0; i < numRows; i++) {
            arr[i] = new StringBuffer();
        }
        /*int currRow = 1;
        //方向， true为从上到下，false为从下到上
        boolean dest = false;
        for(int i = 0; i < s.length(); i++) {
            if(currRow == 1) dest = !dest;
            if(currRow == numRows) dest = !dest;

            arr[currRow - 1].append(s.charAt(i));
            if(dest)
                currRow++;
            else
                currRow--;
        }*/
        for(int i = 0; i < s.length(); i++) {
            int index = i % (2 * numRows - 2);

            index = index >= numRows ? (2 * numRows - 2 - index): index;
            arr[index].append(s.charAt(i));
        }
        for(int i = 0; i < numRows; i++) {
            result += arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        String res = convert("A", 3);
        System.out.println(res);
    }

}

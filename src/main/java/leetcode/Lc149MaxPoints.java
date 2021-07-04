package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Lc149MaxPoints {
    public int maxPoints(int[][] points) {
        int num = points.length;
        if(num<3) return num;
        int max = 2;
        int temp;
        String key;
        Map<String,Integer> map;
        for (int i = 0; i < num; i++) {
            map = new HashMap<>();
            temp = 0;
            for (int j = i + 1; j < num; j++) {
                int a = points[i][0] - points[j][0], b = points[i][1] - points[j][1];
                int k = gcd(a, b);
                key = (a / k) + " " + (b / k);
                map.put(key, map.getOrDefault(key, 0) + 1);
                temp = Math.max(temp, map.get(key));
            }
            max = Math.max(max, temp + 1);
            if(max>num/2) return max;
        }
        return max;
    }

    private int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }


}

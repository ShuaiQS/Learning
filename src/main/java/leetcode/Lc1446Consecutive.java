package leetcode;

public class Lc1446Consecutive {
    public int maxPower(String s) {
        if(s.length()<2)
            return s.length();
        int max = 1;
        char[] ss = s.toCharArray();
        int temp = 1;
        int pre=ss[0];
        for(int i=1;i<ss.length;i++){
            if(ss[i]==pre) temp++;
            else temp=1;
            pre = ss[i];
            max = Math.max(temp,max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Lc1446Consecutive().maxPower("tourist"));
    }

}

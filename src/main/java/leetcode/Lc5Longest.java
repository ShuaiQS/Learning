package leetcode;

public class Lc5Longest {
    /**
     * 中心扩散法
     * @param s 字符串
     * @return 最长回文串
     */
    public String longestPalindrome1(String s) {
        int len = s.length();
        if(len<2) return s;
        int start=0;
        int end = 0;
        char[] chars = s.toCharArray();
        int temp;
        for(int i=0;i<len-1;i++){
            temp = Math.max(getMaxString(chars,i,i),getMaxString(chars,i,i+1));
            if(temp>end-start){
                start = i-(temp-1)/2;
                end = i+temp/2;
            }

        }
        return s.substring(start,end+1);
    }
    private int getMaxString(char[] chars,int start,int end){
        while (start>=0&&end<chars.length&&chars[start]==chars[end]){
           start--;
           end++;
        }
        return end-start-1;
    }

    /**
     * 动态规划解法
     * @param s 字符串
     * @return 最长回文串
     */
    public String longestPalindrome2(String s) {
        int len = s.length();
        if(len<2) return s;
        char[] chars = s.toCharArray();
        if(len==2) {
            if(chars[0]==chars[1]) return s;else return String.valueOf(chars[1]);
        }

        int max = 1;
        int start = 0;
        boolean[][] dp = new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i] = true;
        }
       int j;
        for(int l=2;l<=len;l++){
            for (int i=0;i<len;i++){
                j = i+l-1;
                if(j>=len) break;
                if(l==2){
                    if(chars[i]==chars[j]) dp[i][j]=true;
                }else {
                    if (chars[i] == chars[j])
                        dp[i][j] = dp[i + 1][j - 1];
                }
                if(dp[i][j]){
                    if(max<l){
                        max = l;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start,start+max);
    }
    public static void main(String[] args) {
        System.out.println(new Lc5Longest().longestPalindrome2("babaddddd"));
    }
}

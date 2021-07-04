package leetcode;

/**
 * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
 */
public class Lc712Minimum {
    /**
     *
     * @param s1 字符串1
     * @param s2 字符串2
     * @return ASCII最小和
     * dp[i][j]表示s1从i到字符串尾，s2从j到字符串尾最小ASCII和：
     *  当s1或者s2为空时，也就是dp[i][s2.length]和dp[s1.length][j]的值就是s2或者s1的所有字符的ASCII和
     *  当s1[i]==s2[j]时，dp[i][j]=dp[i+1][j+1]
     *  当s1[i]!=s2[j]时，dp[i][j]=min(dp[i+1][j]+ASCII(s1[i]),dp[i][j+1]+ASCII(S2[j]))
     */
    public int minimumDeleteSum(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        int[][] dp = new int[s1Len+1][s2Len+1];
        char[] s1Char = s1.toCharArray();
        char[] s2Char = s2.toCharArray();
        for(int i=s1Len-1;i>=0;i--){
            dp[i][s2Len] = dp[i+1][s2Len]+s1Char[i];
        }
        for(int j=s2Len-1;j>=0;j--){
            dp[s1Len][j] = dp[s1Len][j+1]+s2Char[j];
        }
        for(int i=s1Len-1;i>=0;i--){
            for(int j=s2Len-1;j>=0;j--){
                if(s1Char[i]==s2Char[j]){
                    dp[i][j] = dp[i+1][j+1];
                }else {
                    dp[i][j] = Math.min(dp[i+1][j]+s1Char[i],dp[i][j+1]+s2Char[j]);
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        System.out.println(new Lc712Minimum().minimumDeleteSum("delete", "leet"));
    }
}

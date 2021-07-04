package leetcode;


public class Lc1528Shuffle {
    public String restoreString(String s, int[] indices) {
        int n = indices.length;
        char[] re = new char[n];
        char[] ss = s.toCharArray();
        for(int i=0;i<n;i++){
            re[indices[i]]=ss[i];
        }
        return new String(re);
    }

    public static void main(String[] args) {
        System.out.println(new Lc1528Shuffle().restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
    }
}

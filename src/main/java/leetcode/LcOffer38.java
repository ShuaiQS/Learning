package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LcOffer38 {
    public String[] permutation(String s) {
        Set<String> set = new HashSet<>();
        char[] cs = s.toCharArray();
        fullSort(cs,0,cs.length-1,set);
        return set.toArray(new String[0]);

    }

    private void fullSort(char[] cs, int start, int end, Set<String> set){
        if(start==end){
            set.add(String.valueOf(cs));
        }
        for(int i=start;i<=end;i++){
            swap(cs,i,start);
            fullSort(cs,start+1,end,set);
            swap(cs,i,start);
        }
    }

    private void swap(char[] c,int a, int b) {
        char tmp = c[a];
        c[a] = c[b];
        c[b] = tmp;
    }

    public static void main(String[] args) {
        String[] abcs = new LcOffer38().permutation("abc");
        for(String s:abcs)
            System.out.println(s);
    }


}

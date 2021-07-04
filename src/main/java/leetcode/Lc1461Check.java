package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Lc1461Check {
    public static void main(String[] args) {

        System.out.println(hasAllCodes("001110",2));
        System.out.println(hasAllCodes1("00000000001011100",3));
    }
    private static boolean hasAllCodes(String s,int k){
        int num = 1<<k;
        Set<String> set = new HashSet<>();
        int len = s.length();
        if(len<k)
            return false;
        for(int i=0;i<len-k+1;i++){
            set.add(s.substring(i,i+k));
        }
        return set.size() >= num;
    }

    private static boolean hasAllCodes1(String s, int k) {
        int num =(int) Math.pow(2,3);
        for(int i=0;i<num;i++){
            String binary = getBinary(i, k);
            if(!s.contains(binary))
                return false;

        }
        return true;

    }

    private static String getBinary(int number, int k){
        String s = Integer.toBinaryString(number);
        StringBuilder sb= new StringBuilder();
        if(s.length()<k){

            for(int i=0;i<k-s.length();i++){
                sb.append("0");
            }

        }
        return sb.toString()+s;
    }
}

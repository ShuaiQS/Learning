package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Lc401Binary {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<12;i++){
            for(int j=0;j<60;j++){
                if(Integer.bitCount(i)+Integer.bitCount(j)==turnedOn){
                    list.add(i+":"+(j<10?"0"+j:j));
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(new Lc401Binary().readBinaryWatch(1));
    }

}

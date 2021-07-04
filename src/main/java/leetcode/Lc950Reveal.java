package leetcode;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Lc950Reveal {
    public static void main(String[] args) {
      int []deck = {17,13,11,2,3,5,7};
        System.out.println(Arrays.toString(deckRevealedIncreasing(deck)));
        System.out.println(Arrays.toString(deckRevealedIncreasing1(deck)));
    }
    private static int[] deckRevealedIncreasing1(int[] deck){
        int len = deck.length;
        Deque<Integer> index = new LinkedList<>();
        for(int i=0;i<len;i++){
            index.add(i);
        }
        int[] result = new int[len];
        Arrays.sort(deck);
        for(int item:deck){
            if(!index.isEmpty())
                result[index.pollFirst()] = item;
            if(!index.isEmpty())
                index.addLast(index.pollFirst());
        }
        return result;
    }







    public static int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        Deque<Integer> index = new LinkedList<>();
        for (int i = 0; i < N; ++i)
            index.add(i);

        int[] ans = new int[N];
        Arrays.sort(deck);
        for (int card: deck) {
            ans[index.pollFirst()] = card;
            if (!index.isEmpty())
                index.add(index.pollFirst());
        }

        return ans;
    }

}

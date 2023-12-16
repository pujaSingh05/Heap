package heap;

import java.util.HashMap;
import java.util.*;

public class ReducedhalfSizeOfArray {
    class Solution {
        public int minSetSize(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();

            for(int i : arr){
                map.put(i, map.getOrDefault(i, 0)+1);
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            for(int num : map.values()){
                pq.offer(num);
            }

            int size = arr.length; int result =0;
            while(size > arr.length/2){
                size -= pq.poll();
                result++;
            }
            return result;
        }
    }
}

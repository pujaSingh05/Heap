package heap;

import java.util.PriorityQueue;

public class Kth_Largest_Element_in_an_Array {
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            int n = nums.length;
            if(n==0){
                return -1;
            }

            PriorityQueue<Integer> pq = new PriorityQueue<>();

            for(int i=0; i<n ;i++){

                if(i < k){
                    pq.add(nums[i]);
                }else{
                    if(nums[i] > pq.peek()){
                        pq.remove();
                        pq.add(nums[i]);
                    }
                }

            }

            return pq.peek();

        }
    }
}

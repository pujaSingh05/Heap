import java.util.*;

public class Maximum_Subsequence_Sum {
    class Solution {
        // Nested Pair class
        class Pair {
            public int a, b;

            public Pair(int a, int b) {
                this.a = a;
                this.b = b;
            }
        }

        public long maxScore(int[] nums1, int[] nums2, int k) {
            int n = nums1.length;
            Pair[] arrp = new Pair[n];

            // Create pairs from nums1 and nums2
            for (int i = 0; i < n; i++)
                arrp[i] = new Pair(nums1[i], nums2[i]);

            // Sort pairs in descending order of 'a'
            Arrays.sort(arrp, (p1, p2) -> -Integer.compare(p1.a, p2.a));

            // Create a priority queue to store pairs based on 'b'
            PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.b, p2.b));

            long sum = 0;

            // Select 'k' pairs with maximum 'a' values and add them to the priority queue
            for (int i = 0; i < k; i++) {
                sum += arrp[i].a;
                pq.add(arrp[i]);
            }

            // Calculate the initial maximum score
            long max = pq.peek().b * sum;

            // Process remaining pairs
            for (int i = k; i < n; i++) {
                if (pq.peek().b < arrp[i].b) {
                    // Remove the pair with the minimum 'b' value
                    sum -= (long) pq.remove().a;

                    int min = arrp[i].b;

                    // Get the minimum 'b' value among the remaining pairs
                    if (pq.size() > 0)
                        min = Integer.min(pq.peek().b, min);

                    // Add the current pair to the priority queue
                    pq.add(arrp[i]);

                    // Update the sum and calculate the maximum score
                    sum += arrp[i].a;
                    max = Long.max(max, min * sum);
                }
            }

            return max;
        }
    }
}
package heap;

public class TaskScheduler {
    class Solution {
        public int leastInterval(char[] tasks, int n) {
            int [] freq = new int[26];
            int max=0;
            int maxCount =0;

            for(char c : tasks){
                freq[c-'A']++;
                max= Math.max(max , freq[c-'A']);
            }

            for(int i : freq){
                if( i== max ){
                    maxCount++;
                }
            }

            return Math.max(tasks.length, (max-1) * (n+1) + maxCount);
        }
    }


}

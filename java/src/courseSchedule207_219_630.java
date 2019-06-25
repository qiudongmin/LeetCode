import java.util.*;

/**
 * @author Qiu Dongmin
 * @date 2019-06-25
 */
public class courseSchedule207_219_630 {

    class Solution {

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            int edge_num = prerequisites.length;
            if (edge_num == 0)
                return true;
            int[] in_degrees = new int[numCourses];
            HashMap<Integer, Set<Integer>> adj = new HashMap<>();
            for (int[] edge :prerequisites) {
                int s = edge[0];
                int t = edge[1];
                in_degrees[t]++;
                if (!adj.containsKey(s)) {
                    Set<Integer> set = new HashSet<>();
                    set.add(t);
                    adj.put(s, set);
                }
                else {
                    adj.get(s).add(t);
                }

            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (in_degrees[i] == 0)
                    queue.offer(i);
            }
            int counter = 0;
            while (!queue.isEmpty()) {
                int top = queue.poll();
                counter++;
                if (!adj.containsKey(top))
                    continue;
                Set<Integer> set = adj.get(top);
                for (int t : set) {
                    in_degrees[t]--;
                    if (in_degrees[t] == 0)
                        queue.offer(t);
                }
            }
            return counter == numCourses;
        }

        public int[] findOrder(int numCourses, int[][] prerequisites) {
            int[] in_degrees = new int[numCourses];
            HashMap<Integer, Set<Integer>> adj = new HashMap<>();
            for (int[] edge :prerequisites) {
                int s = edge[0];
                int t = edge[1];
                in_degrees[t]++;
                if (!adj.containsKey(s)) {
                    Set<Integer> set = new HashSet<>();
                    set.add(t);
                    adj.put(s, set);
                }
                else {
                    adj.get(s).add(t);
                }

            }
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (in_degrees[i] == 0)
                    queue.offer(i);
            }
            int[] res = new int[numCourses];
            int counter = 0;
            while (!queue.isEmpty()) {
                int top = queue.poll();
                res[counter++] = top;
                if (!adj.containsKey(top))
                    continue;
                Set<Integer> set = adj.get(top);
                for (int t : set) {
                    in_degrees[t]--;
                    if (in_degrees[t] == 0)
                        queue.offer(t);
                }
            }
            if (numCourses == counter)
                return res;
            else
                return new int[0];
        }

        public int scheduleCourse(int[][] courses) {
            return 0;
        }
    }

    public void run() {
        Solution s = new Solution();
        int[][] a = {{1, 0}, {1, 2}};
        s.canFinish(3, a);
    }

    public static void main(String[] args) {
        courseSchedule207_219_630 p = new courseSchedule207_219_630();
        p.run();
    }
}


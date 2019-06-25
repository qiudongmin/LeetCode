import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Qiu Dongmin
 * @date 2019-06-25
 */
public class subset78_90 {

    class Solution {

        public List<List<Integer>> subsets(int[] nums) {
            int elem_num = nums.length;
            int subset_num = 1 << elem_num;
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < subset_num; i++) {
                List<Integer> subset = new ArrayList<>();
                for (int j = 0; j < elem_num; j++) {
                    if (((i >> j) & 1) == 1) {
                        subset.add(nums[j]);
                    }
                }
                ans.add(subset);
            }
            return ans;
        }

        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> ans = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            ans.add(temp);
            if (nums == null || nums.length == 0) {
                return ans;
            }
            Arrays.sort(nums);
            subset(ans, temp, nums, 0);
            return ans;
        }

        private void subset(List<List<Integer>> ans, List<Integer>temp, int[] nums, int idx) {
            for (int i = idx; i < nums.length; i++) {
                if (i > idx && nums[i] == nums[i-1])
                    continue;
                temp.add(nums[i]);
                ans.add(new ArrayList<>(temp));
                subset(ans, temp, nums, i+1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    public void run() {
        Solution s = new Solution();
        int[] nums = {1,2,3,2};
        System.out.println(s.subsetsWithDup(nums));
    }

    public static void main(String[] args) {
        subset78_90 p = new subset78_90();
        p.run();
    }
}


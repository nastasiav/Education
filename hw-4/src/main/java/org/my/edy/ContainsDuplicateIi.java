package org.my.edy;

/** 219
 Given an integer array nums and an integer k, return true if there are two
 distinct indices i and j in the array such that nums[i] == nums[j] and abs(i - j) <=
 k.

 Example 1:
 Input: nums = [1,2,3,1], k = 3
 Output: true

 Example 2:
 Input: nums = [1,0,1,1], k = 1
 Output: true

 Example 3:
 Input: nums = [1,2,3,1,2,3], k = 2
 Output: false

 Constraints:

 1 <= nums.length <= 10⁵
 -10⁹ <= nums[i] <= 10⁹
 0 <= k <= 10⁵

 Related Topics Array Hash Table Sliding Window 👍 7494 👎 3322

 */

import java.util.HashSet;
import java.util.Set;

class ContainsDuplicateIi {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();
        IO.println(solution.containsNearbyDuplicate(new int[]{1,2,3,1}, 3)); //true
        IO.println(solution.containsNearbyDuplicate(new int[]{1,0,1,1}, 1)); //true
        IO.println(solution.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2)); //false
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (i > k) {
                    set.remove(nums[i - k - 1]);
                }

                if (!set.add(nums[i]))
                    return true;

            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}

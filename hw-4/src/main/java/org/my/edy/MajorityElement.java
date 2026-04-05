package org.my.edy;

/** 169
 Given an array nums of size n, return the majority element.

 The majority element is the element that appears more than ⌊n / 2⌋ times. You
 may assume that the majority element always exists in the array.

 Example 1:
 Input: nums = [3,2,3]
 Output: 3

 Example 2:
 Input: nums = [2,2,1,1,1,2,2]
 Output: 2

 Constraints:

 n == nums.length
 1 <= n <= 5 * 10⁴
 -10⁹ <= nums[i] <= 10⁹
 The input is generated such that a majority element will exist in the array.

 Follow-up: Could you solve the problem in linear time and in
 O(1) space?

 Related Topics Array Hash Table Divide and Conquer Sorting Counting 👍 22743 👎
 823

 */

import java.util.HashMap;
import java.util.Map;

class MajorityElement {
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        IO.println(solution.majorityElement(new int[]{3,2,3}));
        IO.println(solution.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            int resCount = 0;
            int res = 0;
            for (int num : nums) {
                int count = map.getOrDefault(num, 0) + 1;
                map.put(num, count);
                if (count > resCount && count >= nums.length / 2) {
                    res = num;
                    resCount = count;
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}

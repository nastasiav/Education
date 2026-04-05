package org.my.edy;

/** 217
 Given an integer array nums, return true if any value appears at least twice in
 the array, and return false if every element is distinct.
 Example 1:
 Input: nums = [1,2,3,1]
 Output: true

 Explanation:

 The element 1 occurs at the indices 0 and 3.

 Example 2:
 Input: nums = [1,2,3,4]
 Output: false

 Explanation:

 All elements are distinct.

 Example 3:
 Input: nums = [1,1,1,3,3,4,3,2,4,2]

 Output: true

 Constraints:
 1 <= nums.length <= 10⁵
 -10⁹ <= nums[i] <= 10⁹
 Related Topics Array Hash Table Sorting 👍 13934 👎 1369

 */

import java.util.*;
import java.util.stream.Collectors;

class ContainsDuplicate {
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicate().new Solution();
        IO.println(solution.containsDuplicate(new int[]{1,2,3,1})); //true
        IO.println(solution.containsDuplicate(new int[]{1,2,3,4})); //false
        IO.println(solution.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2})); //true
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            Set<Integer> set  = Arrays.stream(nums)
                    .boxed()
                    .collect(Collectors.toSet());
            return set.size() < nums.length;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
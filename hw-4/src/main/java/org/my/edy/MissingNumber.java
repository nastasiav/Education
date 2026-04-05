package org.my.edy;
/** 268
 Given an array nums containing n distinct numbers in the range [0, n], return
 the only number in the range that is missing from the array.


 Example 1:
 Input: nums = [3,0,1]
 Output: 2
 Explanation:
 n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is
 the missing number in the range since it does not appear in nums.

 Example 2:
 Input: nums = [0,1]
 Output: 2
 Explanation:
 n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is
 the missing number in the range since it does not appear in nums.

 Example 3:
 Input: nums = [9,6,4,2,3,5,7,0,1]
 Output: 8
 Explanation:
 n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is
 the missing number in the range since it does not appear in nums.
 Constraints:

 n == nums.length
 1 <= n <= 10⁴
 0 <= nums[i] <= n
 All the numbers of nums are unique.

 Follow up: Could you implement a solution using only O(1) extra space
 complexity and O(n) runtime complexity?

 Related Topics Array Hash Table Math Binary Search Bit Manipulation Sorting 👍
 14288 👎 3473

 */

import java.util.*;
import java.util.stream.IntStream;

class MissingNumber {
    public static void main(String[] args) {
        Solution solution = new MissingNumber().new Solution();
        IO.println(solution.missingNumber(new int[]{3,0,1})); //2
        IO.println(solution.missingNumber(new int[]{0,1})); //2
        IO.println(solution.missingNumber(new int[]{9,6,4,2,3,5,7,0,1})); //8
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int missingNumber_1(int[] nums) {
            int res = 0;

            List<Integer> list = new ArrayList<>(IntStream
                    .range(0, nums.length + 1)
                    .boxed()
                    .toList());

            for (int i : nums) {
                list.remove(Integer.valueOf(i));
            }

            return list.getFirst();
        }

        public int missingNumber(int[] nums) {
            int res = nums.length;

            for (int i = 0; i < nums.length; i++) {
                res += i - nums[i];
            }

            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
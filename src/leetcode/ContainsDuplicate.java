package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.Collectors;

/*
Given an integer array nums, return true if any value appears at least
twice in the array, and return false if every element is distinct.

Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true


Constraints:

1 <= nums.length <= 105
-109 <= nums[i] <= 109
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        ContainsDuplicate duplicate = new ContainsDuplicate();
        int[] nums1 = {1,2,3,1};
        int[] nums2 = {1,2,3,4};
        int[] nums3 = {1,1,1,3,3,4,3,2,4,2};

        System.out.println(duplicate.containsDuplicate(nums1));
        System.out.println(duplicate.containsDuplicate(nums2));
        System.out.println(duplicate.containsDuplicate(nums3));
    }

    // Using set to filter out duplicates
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> container = new HashSet<>();
        for (int value: nums) {
            if(container.contains(value)) {
                return true;
            }
            container.add(value);
        }
        return false;
    }
}

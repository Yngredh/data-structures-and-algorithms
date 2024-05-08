package Exercises;

import java.util.HashMap;
import java.util.Map;

public class ExerciseArray {

    /**
     * [1] Leetcode <p style="color: green;">Easy</p>
     * <a href="https://leetcode.com/problems/two-sum/">Two Sum</a>
     * @TimeComplexity O(n)
     * @SpaceComplexity O(n)
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) return new int[]{0,1};
        if (nums.length == 1 ) return null;

        Map<Integer, Integer> comb = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int pair = (target - nums[i]);
            if (comb.get(pair) != null) return new int[]{i, comb.get(pair)};
            else comb.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /**
     * [287] LeetCode <p style="color: yellow;">Medium</p>
     * <a href="https://leetcode.com/problems/find-the-duplicate-number/">Find the Duplicate Number</a>
     * @TimeComplexity O(n)
     * @SpaceComplexity O(1)
     */
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (fast != slow);

        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    /**
     * [41] LeetCode <p style="color: red;">Hard</p>
     * <a href="https://leetcode.com/problems/first-missing-positive/description/">First Missing Positive</a>
     * @TimeComplexity O(n)
     * @SpaceComplexity O(1)
     */
    public static int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int current = nums[i];
            if ( (current > 0) && (current <= nums.length) && (nums[current - 1] != current) ) {
                int aux = nums[current - 1];
                nums[current] = current;
                nums[i] = aux;
                continue;
            }
            i++;
        }

        for (i = 1; i < nums.length + 1; i++) {
            if (nums[i-1] != i) return i;
        }

        return nums.length + 1;
    }

    /**
     * [35] LeetCode <p style="color: green;">Easy</p>
     * <a href="https://leetcode.com/problems/search-insert-position/">Search Insert Position</a>
     * @TimeComplexity O(log n)
     * @SpaceComplexity O(1)
     */
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                start = mid + 1;
            } else end = mid - 1;
        }
        return end + 1;
    }

    public boolean isPalindrome(int x) {
        int rest = x;
        int[] rev = new int[x];
        int i = 0;

        while(rest > 1) {
            rest = x % 10;
            rev[i] = rest;
            i++;
        }

        i = 0;
        int e = rev.length - 1;
        while(i != e) {
            if (rev[i] != rev[e]) return false;
            i++;    e--;
        }
        return true;
    }

    public static int findMaxNumber(int[] array) {
        return maxNumber(array, 0, array.length);
    }

    public static int findMinNumber(int[] array) {
        return minNumber(array, 0, array.length);
    }

    private static int maxNumber(int[] array, int index, int len) {
        if(len - 1 == 0) return array[index];
        if (index >= len - 2) return Math.max(array[index], array[index + 1]);

        int max;
        max = maxNumber(array, index + 1, len);
        return Math.max(array[index], max);
    }

    private static int minNumber(int[] array, int index, int len) {
        if(len - 1 == 0) return array[index];
        if (index >= len - 2) return Math.min(array[index], array[index + 1]);

        int min;
        min = maxNumber(array, index + 1, len);
        return Math.min(array[index], min);
    }

    public static <T> void reverseArray(T[] array) {
        T aux;
        int initIndex = 0;
        int endIndex = array.length - 1;

        while (initIndex < endIndex) {
            aux = array[endIndex];
            array[endIndex] = array[initIndex];
            array[initIndex] = aux;
            initIndex++;
            endIndex--;
        }
    }

    public static String[] reverseString(String[] string) {
        String[] reverse = new String[string.length];

        int reverseIndex = 0;
        for (int i = string.length - 1; i >= 0; i--) {
            reverse[reverseIndex] = string[i];
            reverseIndex++;
        }

        return reverse;
    }
}

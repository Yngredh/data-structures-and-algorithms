package Exercises;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ExerciseHashTable {

    /**
     * [217] Leetcode <p style="color: green;">Easy</p>
     * <a href="https://leetcode.com/problems/contains-duplicate/">Contains Duplicate</a>
     * @TimeComplexity O(n/2)
     * @SpaceComplexity O(n)
     */
    public static boolean containsDuplicate(int[] nums) {
        if (nums.length == 1) return false;
        Set<Integer> storage = new HashSet<>();

        for (int i = 0, j = nums.length - 1; i <= j ; i++, j--) {
            if (i != j && nums[i] == nums[j]) return true;
            if (storage.contains(nums[i]) || storage.contains(nums[j])) return true;
            else {
                storage.add(nums[i]);
                storage.add(nums[j]);
            }
        }
        return false;
    }

    public static int firstRecurringNumber(int[] array) {
        Set<Integer> memory = new HashSet<>();
        for (int i = 0; i < array.length -1; i++) {
            if (memory.contains(array[i])) return array[i];
            memory.add(array[i]);
        }
        return 0;
    }

    /**
     * [169] LeetCode <p style="color: green;">Easy</p>
     * <a href="https://leetcode.com/problems/majority-element/">Majority Element</a>
     * @TimeComplexity O(?)
     * @SpaceComplexity O(?)
     */
    public static int majorityElement(int[] nums) {
        Map<Integer,Integer> appearance = new HashMap<>();
        int init = 0;   int end = nums.length -1;
        int maxCount = 0;   int maxNumber = 0;

        while (init <= end) {
            appearance.put(nums[init], appearance.getOrDefault(nums[init], 0) + 1);
            if (init != end) appearance.put(nums[end], appearance.getOrDefault(nums[end], 0) + 1);

            if (appearance.get(nums[init]) >= maxCount) {
                    maxCount = appearance.get(nums[init]);
                    maxNumber = nums[init];
            }
            if (appearance.get(nums[end]) >= maxCount) {
                maxCount = appearance.get(nums[end]);
                maxNumber = nums[end];
            }
            init++;     end--;
        }
        return maxNumber;
    }

    /**
     * [13] LeetCode <p style="color: green;">Easy</p>
     * <a href="https://leetcode.com/problems/roman-to-integer/">Roman to Integer</a>
     * @TimeComplexity O(?)
     * @SpaceComplexity O(?)
     */
    public int romanToInt(String s) {
        Map<Character, Integer> romanToInt = new HashMap<>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};
        int result = 0, length = s.length();

        for (int i = 0; i < length; i++) {
            if (i < length - 1 && romanToInt.get(s.charAt(i)) < romanToInt.get(s.charAt(i + 1)))
                result -= romanToInt.get(s.charAt(i));
            else result += romanToInt.get(s.charAt(i));
        }
        return result;
    }

    /**
     * [242] LeetCode <p style="color: green;">Easy</p>
     * <a href="https://leetcode.com/problems/valid-anagram/">Valid Anagram</a>
     * @TimeComplexity O(n)
     * @SpaceComplexity O(s + t)
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        Map<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
            freqMap.put(t.charAt(i), freqMap.getOrDefault(t.charAt(i), 0) - 1);
        }

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() != 0) return false;
        }

        return true;
    }
}

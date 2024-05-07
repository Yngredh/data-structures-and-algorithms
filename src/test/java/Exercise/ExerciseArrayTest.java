package Exercise;

import Exercises.ExerciseArray;
import org.junit.Test;

public class ExerciseArrayTest {

    @Test
    public void findMaxNumberTest() {
        int[] array = new int[] {2,5,5,2,9,3,4};
        int maxNumber = ExerciseArray.findMaxNumber(array);
        System.out.println(maxNumber);
    }

    @Test
    public void findMinNumberTest() {
        int[] array = new int[] {2,5,5,2,9,3,4};
        int minNumber = ExerciseArray.findMinNumber(array);
        System.out.println(minNumber);
    }

    @Test
    public void firstMissingPositive() {
        int[] case3 = {7,8,9,11,12};
        int[] case2 = {3,4,-1,1};
        ExerciseArray.firstMissingPositive(case3);
    }

    @Test
    public void twoSum() {
        int[] case1 = {2,7,11,15};
        int[] case2 = {3,2,3};
        ExerciseArray.twoSum(case2, 6);
    }

}

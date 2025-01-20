import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Backtracking
 */
public class Backtracking {

    public static List<List<Integer>> permute(List<Integer> nums) {
        List<List<Integer>> output = new ArrayList<>();
        permute(nums, output, 0);
        return output;
    }

    public static void permute(List<Integer> nums, List<List<Integer>> output, int first) {
        int n = nums.size();
        if (first == n)
            output.add(new ArrayList<Integer>(nums));
        for (int i = first; i < n; i++) {
            Collections.swap(nums, first, i);
            permute(nums, output, first + 1);
            Collections.swap(nums, first, i);
        }
    }

    public static void main(String[] args) {
        System.out.println(permute(Arrays.asList(1,2,3)));
    }
}
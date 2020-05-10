import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Permute {

    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        findPermute(nums, new Stack<>());
        return res;
    }


    public void findPermute(int[] nums, Stack<Integer> stack) {
        if (stack.size() == nums.length) {
            res.add(stack);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (stack.contains(nums[i])) {
                continue;
            }
            stack.push(nums[i]);
            findPermute(nums, stack);
            stack.pop();
        }

    }

}

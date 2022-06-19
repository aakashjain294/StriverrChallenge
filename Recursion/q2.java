package Recursion;
import java.util.ArrayList;
import java.util.Arrays;

public class q2 {
    public void singleCombination(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> sm, int[] arr, int target, int idx) {
        if (target == 0) {
            ArrayList<Integer> base = new ArrayList<>(sm);
            ans.add(base);
            return;
        }
        int prev = -1;
        for (int i = idx; i < arr.length; i++) {
            if (prev != arr[i] && target - arr[i] >= 0) {
                sm.add(arr[i]);
                singleCombination(ans, sm, arr, target - arr[i], i + 1);
                sm.remove(sm.size() - 1);
                prev = arr[i];
            }
        }

    }

    public ArrayList<ArrayList<Integer>> combinationSum2(int[] candidates, int target) {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> sm = new ArrayList<>();
        Arrays.sort(candidates);
        singleCombination(ans, sm, candidates, target, 0);
        return ans;
    }
}

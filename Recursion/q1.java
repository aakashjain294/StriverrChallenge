package Recursion;

import java.util.ArrayList;

public class q1 {
    public void infiCombination(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> sm, int[] arr, int target,
            int idx) {
        if (target == 0) {
            ArrayList<Integer> base = new ArrayList<>(sm);
            ans.add(base);
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (target - arr[i] >= 0) {
                sm.add(arr[i]);
                infiCombination(ans, sm, arr, target - arr[i], i);
                sm.remove(sm.size() - 1);
            }
        }

    }

    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> sm = new ArrayList<>();
        infiCombination(ans, sm, candidates, target, 0);
        return ans;
    }
}

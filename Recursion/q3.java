package Recursion;

import java.util.ArrayList;

public class q3 {
    public void singleCombi(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> sm, int k, int n, int idx) {
        if (n == 0 && sm.size() == k) {
            ArrayList<Integer> base = new ArrayList<>(sm);
            ans.add(base);
            return;
        }
        for (int i = idx; i <= 9; i++) {
            if (n - i >= 0) {
                sm.add(i);
                singleCombi(ans, sm, k, n - i, i + 1);
                sm.remove(sm.size() - 1);
            }
        }
    }

    public ArrayList<ArrayList<Integer>> combinationSum3(int k, int n) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> sm = new ArrayList<>();
        singleCombi(ans, sm, k, n, 1);
        return ans;
    }
}

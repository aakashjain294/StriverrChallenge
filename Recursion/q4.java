package Recursion;

import java.util.ArrayList;

public class q4 {
    public void singleCombi(ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> sm, int k, int n, int idx) {
        if (sm.size() == k) {
            ArrayList<Integer> base = new ArrayList<>(sm);
            ans.add(base);
            return;
        }
        for (int i = idx; i <= n; i++) {
            sm.add(i);
            singleCombi(ans, sm, k, n, i + 1);
            sm.remove(sm.size() - 1);
        }
    }

    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> sm = new ArrayList<>();
        singleCombi(ans, sm, k, n, 1);
        return ans;
    }
}

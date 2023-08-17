package com.xiabaike.interview;

import java.util.ArrayList;
import java.util.List;

public class Momenta {

    // cat filename -n 10
    // tail -nf 10 filename
    // head -n 10 filename
    // n   n行
    //  1
    //  11
    //  121
    //  1331
    public void sj (int n) {
        List<Integer> last = new ArrayList<>();
        last.add(1);
        for (int i = 2; i <= n; i++) {
            List<Integer> curr = row(last, i);
            System.out.println(curr.toString());
            last = curr;
        }
    }

    public List<Integer> row(List<Integer> last, int index) {
        List<Integer> curr = new ArrayList<>();
        int middle = index / 2;
        for (int i = 0; i < index - 1; i++) {
            int mid = i / 2;
            int sum = 0;
            if (i < middle) {
                for (int j = 0; j <= mid; j++) {
                    sum += last.get(j);
                }
            } else {
                for (int j = mid + 1; j <= i; j++) {
                    sum += last.get(j);
                }
            }
            curr.add(sum);
        }
        return curr;
    }

    public static void main(String[] args) {
        Momenta momenta = new Momenta();
        momenta.sj(6);
    }

}

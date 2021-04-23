package programmers;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class Solution {
    @Test
    void solution() {
        HashSet<Integer> set = new HashSet<>();
        permutation("","17", set);
        assertThat(set.stream().filter(this::isPrime).count()).isEqualTo(3);

    }

    private boolean isPrime(int num) {
        if (num == 0 || num == 1)  {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private void permutation(String prefix, String str, HashSet<Integer> set) {
        int n = str.length();
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
    }
}

package programmers;

import java.util.HashSet;

public class Solution {
    
    public int solution(String str) {
        HashSet<Integer> set = new HashSet<>();
        permutation("",str, set);
        return set.stream().filter(this::isPrime).count();
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

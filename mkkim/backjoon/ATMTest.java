package backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class ATMTest {
    private static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        sum(nums);
    }

    private static void sum(int[] nums) {
        Arrays.sort(nums);
        int prev = nums[0];
        int total = nums[0];
        for (int i = 1; i < nums.length; i++) {
            total += prev + nums[i];
            prev += nums[i];
        }
        System.out.println(total);
    }
}

package programmers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/*
 *
 * https://programmers.co.kr/learn/courses/30/lessons/49993
 *
 * "CBD"	["BACDE", "CBADF", "AECB", "BDA"]	2
 *
 *
 * */
public class Solution {

    @Test
    void solution() {
        String skill = "CBD";
        String[] skilltrees = {"BACDE", "CBADF", "AECB", "BDA"};
        assertThat(skiilCount(skill, skilltrees)).isEqualTo(2);
    }

    private int skiilCount(String skill, String[] skillTrees) {
        int count = 0;
        for (int i = 0; i < skillTrees.length; i++) {
            if (isSkill(skill, skillTrees[i])) {
                count++;
            }
        }
        return count;
    }

    private boolean isSkill(String skill, String skillTree) {
        int index = 0;
        for (int j = 0; j < skill.length(); j++) {
            for (int k = 0; k < skillTree.length(); k++) {
                if (skill.charAt(j) == skillTree.charAt(k)) {
                    if (index > k) {
                        return false;
                    }
                    break;
                }
                if (index <= k) {
                    index = k + 1;
                }
            }
        }
        return true;
    }
}

package study.programmers.level2;

public class prg49993 {
    public static void main(String[] args) {
        //스킬트리
        int answer = 0;
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

        int index = 0;
        while (true) {
            String skill_tree = skill_trees[index];
            String skill_tree_temp = skill_tree;
            int size = skill_tree.length();

            for(int i=0; i<size; i++) {
                String charSkill = String.valueOf(skill_tree_temp.charAt(i));
                if (!skill.contains(charSkill)) {
                    skill_tree = skill_tree.replace(charSkill, "");
                }

            }
            if (skill.indexOf(skill_tree) == 0) {
                answer++;
            }
            index++;
            if (index == skill_trees.length) break;
        }
        System.out.println(answer);
    }
}

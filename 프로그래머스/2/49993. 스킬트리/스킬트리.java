import java.util.*;

class Solution {
    static String[] data;
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String skill_tree : skill_trees) {
            if (isValid(skill, skill_tree)) {
                answer++;
            }
        }

        return answer;
    }
    private boolean isValid(String skill, String skill_tree) {
        int index = 0;

        for (char c : skill_tree.toCharArray()) {
            if (skill.indexOf(c) != -1) { // 스킬이 skill에 포함되어 있는지 확인
                if (c == skill.charAt(index)) {
                    index++;
                } else {
                    return false; // 스킬 순서가 올바르지 않음
                }
            }
        }

        return true; // 모든 스킬이 올바른 순서에 있음
    }
}
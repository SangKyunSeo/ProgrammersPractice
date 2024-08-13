import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        int[] numbers = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numbers);
        answer += numbers[0];
        answer += " ";
        answer += numbers[numbers.length - 1];
        return answer;
    }
}
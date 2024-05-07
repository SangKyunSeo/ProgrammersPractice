import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        
        int arr[] = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();
        answer = min + " " + max;
        
        return answer;
    }
}
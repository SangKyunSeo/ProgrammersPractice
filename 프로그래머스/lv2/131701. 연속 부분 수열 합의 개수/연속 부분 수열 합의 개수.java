import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        int size = elements.length;
        int idx = 0;
        Set<Integer> set = new HashSet<>();
        
        for(int i=0;i<size;i++){
            int sum = 0;
            for(int j=0;j<size;j++){
                if(i+j>=size)idx = i+j-size;
                else idx = i+j;
                sum+=elements[idx];
                set.add(sum);
            }
        }
        answer = set.size();
        return answer;
    }
}
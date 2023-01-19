import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        
        for(int i=0;i<tangerine.length;i++){
            map.put(tangerine[i],map.getOrDefault(tangerine[i],0)+1);
        }
        
        for(int key:map.keySet()){
            list.add(map.get(key));
        }
        
        Collections.sort(list,Collections.reverseOrder());
        
        
        for(int i=0;i<list.size();i++){
            sum+=list.get(i);
            answer++;
            if(sum>=k)break;
        }
        
        return answer;
    }
}
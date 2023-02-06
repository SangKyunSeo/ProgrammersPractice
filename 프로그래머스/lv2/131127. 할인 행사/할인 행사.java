import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int end = discount.length - 10;
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<=end;i++){
            boolean flag = false;
            
            for(int j=i;j<i+10;j++){
                map.put(discount[j],map.getOrDefault(discount[j],0)+1);
            }
            
            for(int j=0;j<want.length;j++){
                if(map.getOrDefault(want[j],0)>=number[j])flag=true;
                else {flag=false;break;}
            }
            if(flag)answer++;
            map.clear();
        }
        return answer;
    }
}
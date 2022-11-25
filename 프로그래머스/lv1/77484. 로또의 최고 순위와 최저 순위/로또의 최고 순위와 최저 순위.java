import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int hit = 0;
        int max = 0;
        
        for(int i=0;i<lottos.length;i++){
            boolean check = false;
            for(int j=0;j<win_nums.length;j++){
                if(lottos[i]==win_nums[j]){
                    check=true;
                    hit++;
                }
            }
            if(check==false){
                if(lottos[i]!=0)lottos[i]=-1;
            }
        }
        
        for(int i=0;i<lottos.length;i++){
            if(lottos[i]!=-1)max++;
        }
        
//         if(max==6)answer[0]=1;
//         else if(max==5)answer[0]=2;
//         else if(max==4)answer[0]=3;
//         else if(max==3)answer[0]=4;
//         else if(max==2)answer[0]=5;
//         else answer[0]=6;
        
//         if(hit==6)answer[1]=1;
//         else if(hit==5)answer[1]=2;
//         else if(hit==4)answer[1]=3;
//         else if(hit==3)answer[1]=4;
//         else if(hit==2)answer[1]=5;
//         else answer[1]=6;
        answer[0]=7-max;
        answer[1]=7-hit;
        if(answer[0]>=6)answer[0]=6;
        if(answer[1]>=6)answer[1]=6;
        return answer;
    }
}
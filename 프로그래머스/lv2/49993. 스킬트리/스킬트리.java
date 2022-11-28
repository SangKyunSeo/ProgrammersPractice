import java.util.*;
class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = -1;
//         int count = 0;
//         Queue<Character> q = new LinkedList<>();
        
//         StringBuilder sb;
//         for(int i=0;i<skill_trees.length;i++){
//             boolean check = false;
//             q.clear();
//             sb = new StringBuilder();
//             char[] arr = skill_trees[i].toCharArray();
            
//             for(int j=0;j<arr.length;j++){
//                 if(skill.contains(Character.toString(arr[j]))){
//                     check=true;
//                     if(q.contains(arr[j]))continue;
//                     else q.offer(arr[j]);
//                 }
//             }
//             if(check==false){
//                 count++;
//             }
//             while(!q.isEmpty()){
//                 sb.append(q.poll());
//             }
         
//             String s = sb.toString();
//             if(s.startsWith(Character.toString(skill.charAt(0)))){
//                 if(skill.contains(s)){
//                     count++;
//                 }
//             }
            
//         }
        
        ArrayList<String> skilltrees = new ArrayList<>(Arrays.asList(skill_trees));
        Iterator<String> it = skilltrees.iterator();
        while(it.hasNext()){
            if(skill.indexOf(it.next().replaceAll("[^"+skill+"]",""))!=0){
                it.remove();
            }
        }
        answer = skilltrees.size();
        return answer;
    }
}
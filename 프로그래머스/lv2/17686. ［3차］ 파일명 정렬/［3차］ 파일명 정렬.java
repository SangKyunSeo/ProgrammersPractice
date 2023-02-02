import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = {};
        Arrays.sort(files, new Comparator<String>(){
            public int compare(String s1, String s2){
                String[] file1 = detach(s1);
                String[] file2 = detach(s2);
                
                int headVal = file1[0].compareTo(file2[0]);
                
                if(headVal==0){
                    int num1 = Integer.parseInt(file1[1]);
                    int num2 = Integer.parseInt(file2[1]);
                    
                    return num1 - num2;
                }else{
                    return headVal;
                }
            }
            public String[] detach(String s){
                String head = "";
                String number = "";
                String tail = "";
                
                int idx = 0;
                for(;idx<s.length();idx++){
                    if(s.charAt(idx)>='0' && s.charAt(idx)<='9')break;
                    head += s.charAt(idx);
                }
                for(;idx<s.length();idx++){
                    if(!(s.charAt(idx)>='0' && s.charAt(idx)<='9'))break;
                    number+=s.charAt(idx);
                }
                for(;idx<s.length();idx++){
                    tail+=s.charAt(idx);
                }
                
                String[] file = {head.toLowerCase(),number,tail};
                return file;
            }
        });
        answer = files;
        return answer;
    }
}
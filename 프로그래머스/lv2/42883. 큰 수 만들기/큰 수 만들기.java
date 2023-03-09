import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        
        for(int i=0;i<number.length();i++){
            while(!stack.isEmpty()){
                if(k==0)break;
                if(Character.getNumericValue(stack.peek())<Character.getNumericValue(number.charAt(i))){
                    stack.pop();
                    k--;
                    if(k==0)break;
                }else{
                    stack.push(number.charAt(i));
                    break;
                }
            }
            if(stack.isEmpty())stack.push(number.charAt(i));
            else if(k==0)stack.push(number.charAt(i));
        }
        
        if(k!=0){
            for(int i=0;i<k;i++)stack.pop();
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        answer = sb.reverse().toString();
        return answer;
    }
}
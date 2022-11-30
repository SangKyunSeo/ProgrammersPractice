import java.util.*;
class point{
    int x,y;
    point(int x,int y){this.x = x;this.y = y;};
    public void setPoint(int x,int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    static point left = new point(3,0);
    static point right = new point(3,2);
    static StringBuilder sb = new StringBuilder();
    static String map[][] = {{"1","2","3"},{"4","5","6"},{"7","8","9"},{"*","0","#"}};
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        List<String> leftList = new ArrayList<>();
        List<String> rightList = new ArrayList<>();
        
        leftList.add("1");
        leftList.add("4");
        leftList.add("7");
        rightList.add("3");
        rightList.add("6");
        rightList.add("9");
        
        for(int i=0;i<numbers.length;i++){
            if(leftList.contains(Integer.toString(numbers[i]))){
                sb.append("L");
                leftlocation(Integer.toString(numbers[i]));
            }
            else if(rightList.contains(Integer.toString(numbers[i]))){
                sb.append("R");
                rightlocation(Integer.toString(numbers[i]));
            }
                
            else{
                check(hand,Integer.toString(numbers[i]));
            }
        }
        
        answer = sb.toString();
         return answer;
        
        
    }
        public static void leftlocation(String number){
            for(int i=0;i<4;i++){
                for(int j=0;j<3;j++){
                    if(map[i][j].equals(number)){
                        left.setPoint(i,j);
                    }
                }
            }
        }
        public static void rightlocation(String number){
            for(int i=0;i<4;i++){
                for(int j=0;j<3;j++){
                    if(map[i][j].equals(number)){
                        right.setPoint(i,j);
                    }
                }
            }
        }
        public static void check(String hand, String number){
            for(int i=0;i<4;i++){
                for(int j=0;j<3;j++){
                    if(map[i][j].equals(number)){
                        if((Math.abs(left.x-i)+Math.abs(left.y-j))>(Math.abs(right.x-i)+Math.abs(right.y-j))){
                            sb.append("R");
                            right.setPoint(i,j);
                        }
                        else if((Math.abs(left.x-i)+Math.abs(left.y-j))<(Math.abs(right.x-i)+Math.abs(right.y-j))){
                            sb.append("L");
                            left.setPoint(i,j);
                        }
                        else{
                            if(hand.equals("left")){
                                sb.append("L");
                                left.setPoint(i,j);
                            }else{
                                sb.append("R");
                                right.setPoint(i,j);
                            }
                        }
                    }
                }
            }
        }
}
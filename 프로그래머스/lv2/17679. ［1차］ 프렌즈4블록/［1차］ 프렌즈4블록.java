import java.util.*;

class Solution {
    static char element[];
    static char map[][];
    static int col = 0;
    static int row = 0;
    static boolean check[][];
    static boolean flag = true;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        row = m;
        col = n;
        map = new char[m][n];
        HashMap<Character,Integer> used = new HashMap<>();
        int index = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                map[i][j] = board[i].charAt(j);
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                used.put(map[i][j],0);
            }
        }
        element = new char[used.size()];
        for(char ch : used.keySet()){
            element[index] = ch;
            index++;
        }
        
        while(flag){
            flag = false;
            for(int i=0;i<element.length;i++){
                find(element[i]);
                eraseCheck();
            }
            move();
        }
        print();
        answer = cal();
        return answer;
    }
    public static void find(char c){
        check = new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(map[i][j]==c)check[i][j]=true;
            }
        }
    }
    public static void eraseCheck(){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(check[i][j]){
                    int nx = i + 1;
                    int ny = j + 1;
                    if(nx>=0&&ny>=0&&nx<row&&ny<col){
                        if(check[i][ny] && check[nx][j] && check[nx][ny]){
                            erase(i,j);
                        }
                    }
                }
            }
        }
    }
    public static void erase(int x,int y){
        flag=true;
        map[x][y]='.';
        map[x+1][y]='.';
        map[x][y+1]='.';
        map[x+1][y+1]='.';
    }
    public static void move(){
        for(int i=0;i<col;i++){
            Queue<Character> q = new LinkedList<>();
            for(int j=row-1;j>=0;j--){
                if(map[j][i]!='.')q.offer(map[j][i]);
            }
            for(int j=row-1;j>=0;j--){
                if(!q.isEmpty()){
                    map[j][i]=q.poll();    
                }else
                    map[j][i]='.';
            }
        }
    }
    public static int cal(){
        int count = 0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(map[i][j]=='.')count++;
            }
        }
        return count;
    }
    public static void print(){
         for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(map[i][j]);
            }
             System.out.println();
        }
    }
}
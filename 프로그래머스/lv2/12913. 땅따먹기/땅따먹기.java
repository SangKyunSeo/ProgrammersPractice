class Solution {
    static int[][] map;
    int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        map = new int[n][4];
        copy(land);
        
        for(int i=1;i<n;i++){
            cal(i,land);
        }
        for(int i=0;i<4;i++){
            if(answer<map[map.length-1][i])answer=map[map.length-1][i];
        }
        return answer;
    }
    public static void copy(int[][] land){
        for(int i=0;i<land.length;i++){
            for(int j=0;j<4;j++){
                map[i][j]=land[i][j];
            }
        }
    }
    public static void cal(int row,int[][] land){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(i!=j){
                    map[row][i]=Math.max(map[row][i],land[row][i]+map[row-1][j]);
                }
            }
           
        }
    
    }
}
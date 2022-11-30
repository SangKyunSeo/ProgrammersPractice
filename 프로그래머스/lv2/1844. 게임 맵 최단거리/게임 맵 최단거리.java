import java.util.*;

class point{
    int x,y,depth;
    point(int x,int y,int depth){
        this.x = x;
        this.y = y;
        this.depth = depth;
    }
}
class Solution {
    static int n,m;
    static int[][] map;
    static boolean visit[][];
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    static int min = Integer.MAX_VALUE;
    
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        map = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                map[i]=maps[i];
            }
        }
        
        visit = new boolean[n][m];
        
        bfs(0,0);
        
        answer = min;
        if(answer==Integer.MAX_VALUE)answer = -1;
        return answer;
    }
    public static void bfs(int x,int y){
        Queue<point> q = new LinkedList<>();
        q.offer(new point(x,y,1));
        visit[x][y]=true;
        while(!q.isEmpty()){
            point p = q.poll();
            
            for(int i=0;i<4;i++){
                int nx = dx[i] + p.x;
                int ny = dy[i] + p.y;
                
                if(nx>=0&&ny>=0&&nx<n&&ny<m){
                    if(!visit[nx][ny]&&map[nx][ny]==1){
                        visit[nx][ny]=true;
                        q.offer(new point(nx,ny,p.depth+1));
                    }
                }
                
                if(nx==n-1&&ny==m-1){
                    min = Math.min(min,p.depth+1);
                    return;
                }
            }
        }
        
    }
}
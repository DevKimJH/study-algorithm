package studyAlgorithm.D220206;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class b2667단지번호붙이기 {

    static int[][] map;
    static int[][] visit;
    static int[] aparts;
    static int index;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        visit = new int[N][N];
        aparts = new int[N*N];
        index = 0;

        for(int i = 0 ; i < N ; i++){
            String row = br.readLine();
            for(int j = 0 ; j < N ; j++){
                map[i][j] = row.charAt(j)-'0';
            }
        }

        int cnt=  0;

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(map[i][j] == 1 && visit[i][j] == 0){
                    dfs(i, j);
                    cnt++;
                    index++;
                }
            }
        }

        Arrays.sort(aparts);

        System.out.println(cnt);

        for(int i = 0 ; i < aparts.length ; i++){
            if(aparts[i] == 0) continue;

            System.out.println(aparts[i]);
        }
    }

    static void dfs(int x, int y){
        visit[x][y] = 1;
        aparts[index]++;

        for(int i = 0 ; i < 4 ; i++){
            int next_x = x + dx[i];
            int next_y = y + dy[i];
            if(next_x >= 0 && next_y >= 0 && next_x < N && next_y < N){
                if(map[next_x][next_y] == 1 && visit[next_x][next_y] == 0){
                    dfs(next_x, next_y);
                }
            }
        }
    }
}




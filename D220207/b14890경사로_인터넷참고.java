package studyAlgorithm.D220207;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14890경사로_인터넷참고 {

    static int N; // 지도 크기
    static int L; // 경사로 길이
    static int[][] map;
    static boolean[][] visited; // 경사로 놓은지 확인
    static int pathCnt;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        pathCnt = 0;

        map = new int[N][N];
        visited = new boolean[N][N];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 가능한 길인지 아닌지 체크
        for(int i = 0 ; i < N ; i++){
            if(checkPath(i, 0, true))
                pathCnt++;

            if(checkPath(0, i, false)){
                pathCnt++;
            }
        }

        System.out.println(pathCnt);
    }

    // true : 행 검사
    // false : 열 검사
    static boolean checkPath(int r, int c, boolean flag){
        int[] height = new int[N];
        boolean[] visited = new boolean[N];

        for(int i = 0 ; i < N ; i++){
            if(flag == true){
                height[i] = map[r][i];
            }
            else if(flag == false){
                height[i] = map[i][c];
            }
        }

        for(int i = 0 ; i < N-1 ; i++){
            // 높이가 같을 때
            if(height[i] == height[i+1]){
                continue;
            }
            // 내려가는 경사일때
            else if( height[i] - height[i+1] == 1){
                for(int j = i+1 ; j <= i + L ; j++){
                    // 범위 넘어가거나 칸의 높이가 다르거나 이미 경사로가 있는 경우
                    if(j >= N || height[i+1] != height[j] || visited[j]) return false;

                    visited[j] = true;
                }
            }
            // 올라가는 경사일때
            else if( height[i] - height[i+1] == -1){
                for(int j = i ; j > i - L ; j--){
                    // 범위 넘어가거나 칸의 높이가 다르거나 이미 경사로가 있는 경우
                    if(j < 0  || height[i] != height[j] || visited[j]) return false;
                    visited[j] = true;
                }
            }
            // 높이가 두칸이상 차이날때
            else{
                return false;
            }
        }

        return true;
    }
}

package studyAlgorithm.D220207;


import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
 * 1 : 익은 토마토
 * 0 : 익지 않은 토마토
 * -1 : 들어있지 않은 칸
 */
public class b7576토마토 {
    static int ans = 0;
    static int map[][];
    static int visit[][];
    static int N;
    static int M;
    static int[] pr = {-1 , 0 , 1, 0};
    static int[] pc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로

        map = new int[N][M];
        visit = new int[N][M];

        // 지도 세팅
        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < M ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    static int bfs(){
        Queue<int[]> queue = new LinkedList<>();
        int ans = 0;
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] == 1){
                    queue.add(new int[]{i, j});
                    visit[i][j] = 1;
                }
            }
        }

        while(!queue.isEmpty()){
            int curR = queue.peek()[0];
            int curC = queue.peek()[1];
            queue.poll();

            for(int i = 0 ; i < 4; i++){
                int nextR = curR + pr[i];
                int nextC = curC + pc[i];

                if(0 <= nextR && nextR < N && 0 <= nextC && nextC < M){
                    if(map[nextR][nextC] == 0){
                        queue.add(new int[]{nextR, nextC});
                        map[nextR][nextC] = map[curR][curC] + 1;
                    }

                    if(ans < map[nextR][nextC]) ans = map[nextR][nextC];

                }
            }
        }

        for(int i = 0; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                if(map[i][j] == 0) return -1;

                ans = Math.max(ans, map[i][j]);
            }
        }

        if(ans == 1) return 0;

        return ans-1;
    }
}

package studyAlgorithm.M2207.D16;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다
창고에 보광된 토마토들이 며칠이 지나면 다 익게 되는지, 그 최소 일수를 알고 싶어 한다

 */
public class B7576 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static class Node {
        int r;
        int c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] mapArr = new int[M][N];
        boolean[][] visitArr = new boolean[M][N];

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < N ; j++){
                mapArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            for(int i = 0 ; i < M ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(visitArr[i][j] == false && mapArr[i][j] == 1 ){
                        visitArr[i][j] = true;
                        process(mapArr, visitArr, i, j);
                    }
                }
            }

        }
    }

    static void process(int[][] mapArr, boolean[][] visitArr, int r, int c) {

        for(int i = 0 ; i < 4; i++){
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(0 <= nextR && nextR < mapArr.length && 0 <= nextC && nextC < mapArr[0].length){
                mapArr[nextR][nextC] = 1;
            }
        }
    }
}

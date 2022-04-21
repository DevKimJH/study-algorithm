package studyAlgorithm.D220421;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


/**
 N * M 크기의 얼음 틀이 있다.


4 5
00110
00011
11111
00000
 */


public class P음료수얼려먹기 {

    static class Node{
        int r;
        int c;

        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        // 얼음 틀 세로 길이
        int N = Integer.parseInt(st.nextToken());

        // 얼음 틀 가로 길이
        int M = Integer.parseInt(st.nextToken());

        int[][] mapArr = new int[N][M];
        boolean[][] visitArr = new boolean[N][M];

        for(int i = 0 ; i < N ; i++){
            String inputStr = br.readLine();
            for(int j = 0 ; j < M ; j++){
            //mapArr[i][j] = Integer.parseInt(st.nextToken());
                mapArr[i][j] = inputStr.charAt(j)-48;
            }
        }

        int answer = 0;

        //process(mapArr, visitArr, 0, 0);

        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < M ; j++){
                System.out.println(mapArr[i][j]);
                System.out.println(visitArr[i][j]);
                if(mapArr[i][j] == 0 && visitArr[i][j] == false){
                    process(mapArr, visitArr, i, j);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }

    static void process(int[][] mapArr, boolean[][] visitArr, int r, int c){
        //Stack<Node> s = new Stack();
        //s.push(new Node(r, c));
        visitArr[r][c] = true;

        for(int i = 0 ; i < 4 ; i++){
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if(0 <= nextR && nextR < mapArr.length && 0 <= nextC && nextC < mapArr[0].length){
                if(mapArr[nextR][nextC] == 0 && visitArr[nextR][nextC] == false){
                    //visitArr[nextR][nextC] = true;
                    System.out.println(nextR + " " + nextC);
                    process(mapArr, visitArr, nextR, nextC);
                }
            }
        }
    }
}

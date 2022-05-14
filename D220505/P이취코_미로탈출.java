package studyAlgorithm.D220505;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/**
5 6
101010
111111
000001
111111
111111
 */
public class P이취코_미로탈출 {

    static class Node{
        int r;
        int c;
        int weight;

        Node(int r, int c, int weight){
            this.r = r;
            this.c = c;
            this.weight = weight;
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int answer = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        // 세로 크기
        int N = Integer.parseInt(st.nextToken());

        // 가로 크기
        int M = Integer.parseInt(st.nextToken());

        int[][] mapArr = new int[N][M];
        boolean[][] visitArr = new boolean[N][M];
        int[][] weightArr = new int[N][M];

        for(int r = 0 ; r < N ; r++){
            String str = br.readLine();
            for(int c = 0 ; c < M ; c++){
                mapArr[r][c] = str.charAt(c)-48;
            }
        }

        process(0, 0, mapArr, visitArr, weightArr);
        System.out.println(weightArr[N-1][M-1]);
    }

    static void process(int r, int c, int[][] mapArr, boolean[][] visitArr, int[][] weightArr){
        Queue<Node> queue = new LinkedList();
        visitArr[r][c] = true;
        queue.add(new Node(r, c, 1));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int nodeR = node.r;
            int nodeC = node.c;
            int weight = node.weight;

            visitArr[nodeR][nodeC] = true;

            for(int i = 0 ; i < 4; i++){
                int nextR = nodeR + dr[i];
                int nextC = nodeC + dc[i];

                if(0 <= nextR && nextR < mapArr.length && 0 <= nextC && nextC < mapArr[0].length){
                    if(mapArr[nextR][nextC] == 1 && visitArr[nextR][nextC] == false){
                        queue.add(new Node(nextR, nextC, weight+1));
                        weightArr[nextR][nextC] = weight+1;
                        visitArr[nextR][nextC] = true;
                    }
                }
            }
        }
    }
}

package studyAlgorithm.D220421;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**

 N * M 크기의 직사각형 형태의 미로에 갇힘
 미로에는 여러 마리의 괴물이 있어 이를 피해 탈출해야 한다.
 동빈이의 위치는 (1,1)이고 미로의 출구는 (N,M)
 한 번에 한 칸씩 이동할 수 있다. 이때 괴물이 있는 부분은 0으로, 괴물이 없는 부분은 1로 표시

 동빈이가 탈출하기 위해 움직여야 하는 최소 칸의 개수 구하기

5 6
101010
111111
000001
111111
111111


* */



public class P미로탈출 {

    static class Node{
        int r;
        int c;
        int weight;

        Node(int r, int c, int weight){
            this.r  = r;
            this.c = c;
            this.weight = weight;
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] weightArr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        // 세로크기
        int N = Integer.parseInt(st.nextToken());

        // 가로크기
        int M = Integer.parseInt(st.nextToken());

        int[][] mapArr = new int[N][M];
        boolean[][] visitArr = new boolean[N][M];
        weightArr = new int[N][M];

        for(int i = 0 ; i < N ; i++){
            String inputStr = br.readLine();
            for(int j = 0 ; j < M ; j++){
                mapArr[i][j] = inputStr.charAt(j)-48;
            }
        }

        process(mapArr, visitArr, 0, 0);
        System.out.println(weightArr[N-1][M-1]);
    }

    static void process(int[][] mapArr, boolean[][] visitArr, int r, int c){
        Queue<Node> queue = new LinkedList();
        visitArr[r][c] = true;
        queue.add(new Node(r, c, 1));

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int nodeR = node.r;
            int nodeC = node.c;
            int weight = node.weight;

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

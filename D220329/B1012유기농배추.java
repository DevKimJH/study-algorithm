package studyAlgorithm.D220329;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 어떤 배추에 배추흰지렁이가 한 마리라도 살고 있으면 이 지렁이는 인접한 다른 배추로 이동할 수 있다. 그 배추들 역시 해충으로부터 보호받을 수 있다. 한 배추의 상하좌우 네 방향에 다른 배추가 위치한 경우 서로 인접해 있는 것이다.

 배추들이 모여있는 곳에는 배추흰지렁이가 한 마리만 있으면 되므로 서로 인접해있는 배추들이 몇 군데에 퍼져있는지 조사하면 총 몇 마리의 지렁이가 필요한지 알 수 있다. 예를 들어 배추밭이 아래와 같이 구성되어 있으면 최소 5마리의

 배추 흰지렁이가 필요하다. 0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅을 나타낸다.

 1 1 0 0 0 0 0 0 0 0
 0 1 0 0 0 0 0 0 0 0
 0 0 0 0 1 0 0 0 0 0
 0 0 0 0 1 0 0 0 0 0
 0 0 1 1 0 0 0 1 1 1
 0 0 0 0 1 0 0 1 1 1



 */

public class B1012유기농배추 {

    static boolean[][] visitArr;

    static int[] dx = { 0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};

    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스의 수
        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T ; i++){
            st = new StringTokenizer(br.readLine(), " ");

            // 배추밭의 가로 길이
            int M = Integer.parseInt(st.nextToken());

            // 배추밭의 세로 길이
            int N = Integer.parseInt(st.nextToken());

            // 배추가 심어져 있는 위치의 개수
            int K = Integer.parseInt(st.nextToken());

            // 지도 세팅
            int[][] mapArr = new int[N][M];
            visitArr = new boolean[N][M];


            // 배추 위치 세팅
            for(int j = 0 ; j < K ; j++){
                st = new StringTokenizer(br.readLine(), " ");
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                mapArr[r][c] = 1;
            }

            /*
            for(int j = 0 ; j < N ; j++){
                for(int k = 0 ; k < M ; k++){
                    System.out.print(mapArr[j][k] + " ");
                }
                System.out.println("");
            }
            */


            int answer = 0;

            for(int j = 0 ; j < N ; j++){
                for(int k = 0 ; k < M ; k++){
                    if(visitArr[j][k] == false && mapArr[j][k] == 1){
                        BFS(mapArr, k, j);
                        answer++;
                    }
                }
            }

            bw.write(String.valueOf(answer));
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    /**
     1 1 0 0 0 0 0 0 0 0
     0 1 0 0 0 0 0 0 0 0
     0 0 0 0 1 0 0 0 0 0
     0 0 0 0 1 0 0 0 0 0
     0 0 1 1 0 0 0 1 1 1
     0 0 0 0 1 0 0 1 1 1
     0 0 0 0 0 0 0 1 1 1
     0 0 0 0 0 0 0 0 0 0
     */

    static void BFS(int[][] mapArr, int x, int y){
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(x, y));
        visitArr[y][x] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            for(int i = 0 ; i < 4 ; i++){
                int nextX = node.x + dx[i];
                int nextY = node.y + dy[i];

                if(0 <= nextX && nextX < mapArr[0].length && 0 <= nextY && nextY < mapArr.length){
                    if(visitArr[nextY][nextX] == false && mapArr[nextY][nextX] == 1){
                        queue.add(new Node(nextX, nextY));
                        visitArr[nextY][nextX] = true;
                    }
                }
            }
        }
    }
}

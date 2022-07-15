package studyAlgorithm.M2207.D15;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
5 5
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
0 0 0 0 0
 */
public class B1926 {

    static int answer = 0;
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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] mapArr = new int[N][M];
        boolean[][] visitArr = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                mapArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visitArr[i][j] == false && mapArr[i][j] == 1) {
                    count++;
                    process(mapArr, visitArr, i, j);
                }
            }
        }

        System.out.println(count);
        System.out.println(answer);
    }

    static void process(int[][] mapArr, boolean[][] visitArr, int r, int c) {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(new Node(r, c));
        visitArr[r][c] = true;
        int count = 0;


        while (!queue.isEmpty()) {
            Node node = queue.poll();
            count++;
            for (int i = 0; i < 4; i++) {
                int nextR = node.r + dr[i];
                int nextC = node.c + dc[i];

                if (0 <= nextR && nextR < mapArr.length && 0 <= nextC && nextC < mapArr[0].length) {
                    if (mapArr[nextR][nextC] == 1 && visitArr[nextR][nextC] == false) {
                        queue.add(new Node(nextR, nextC));
                        visitArr[nextR][nextC] = true;
                    }
                }
            }
        }

        answer = Math.max(count, answer);
    }
}


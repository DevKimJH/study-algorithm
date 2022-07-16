package studyAlgorithm.M2207.D16;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*

 */
public class B2178 {
    static int N, M;
    static class Node{
        int r;
        int c;
        int point;

        Node(int r, int c){
            this.r = r;
            this.c = c;
            point = 1;
        }

        Node(int r, int c, int point){
            this.r = r;
            this.c = c;
            this.point = point;
        }
    }

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] mapArr = new int[N+1][M+1];
        boolean[][] visitArr = new boolean[N+1][M+1];

        for(int i = 1 ; i <= N ; i++){
            String inputStr = br.readLine();
            for(int j = 1 ; j <= M ; j++){
                mapArr[i][j] = Integer.parseInt(inputStr.substring(j-1, j));
            }
        }

        process(mapArr, visitArr, 1, 1);
    }

    static void process(int[][] mapArr, boolean[][] visitArr, int r, int c){
        Queue<Node> queue = new LinkedList();

        queue.add(new Node(r, c));
        visitArr[r][c] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.r == N && node.c == M){
                System.out.println(node.point);
            }

            for(int i = 0 ; i < 4 ; i++){
                int nextR = node.r + dr[i];
                int nextC = node.c + dc[i];
                int point = node.point + 1;

                if(1 <= nextR && nextR < mapArr.length && 1 <= nextC && nextC < mapArr[0].length){
                    if(mapArr[nextR][nextC] == 1 && visitArr[nextR][nextC] == false){
                        queue.add(new Node(nextR, nextC, point));
                        visitArr[nextR][nextC] = true;
                    }
                }
            }
        }
    }
}

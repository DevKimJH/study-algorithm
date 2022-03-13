package studyAlgorithm.D220311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/**
 * BFS와 DFS 인접리스트로 풀어보기
 */
public class b1260 {

    class EdgeInfo{
        public int arriveVertex;
        public int weight;

        public EdgeInfo(int arriveVertex, int weight){
            this.arriveVertex = arriveVertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        // 정점의 개수
        int N = Integer.parseInt(st.nextToken());

        // 간선의 개수
        int M = Integer.parseInt(st.nextToken());

        // 탐색을 시작할 정점의 번호
        int V = Integer.parseInt(st.nextToken());

        int[][] vertexArr = new int[N+1][N+1];
        boolean[] visitArr = new boolean[N+1];

        // 간선 세팅
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());

            vertexArr[startIdx][endIdx] = 1;
            vertexArr[endIdx][startIdx] = 1;
        }

        DFS(vertexArr, visitArr, V);
        System.out.println("");
        visitArr = new boolean[N+1];
        BFS(vertexArr, visitArr, V);
    }

    static void DFS(int[][] vertexArr, boolean[] visitArr, int V){
        Stack stack = new Stack();
        visitArr[V] = true;
        System.out.print(V + " ");

        for(int i = 1 ; i < visitArr.length ; i++){
            if (vertexArr[V][i] == 1 && visitArr[i] == false){
                DFS(vertexArr, visitArr, i);
            }
        }
    }

    static void BFS(int[][] vertexArr, boolean[] visitArr, int V){
        Queue<Integer> queue = new LinkedList();
        queue.add(V);
        visitArr[V] = true;
        while(!queue.isEmpty()){
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for(int i = 0 ; i < visitArr.length ; i++){
                if(vertexArr[vertex][i] == 1){
                    if(visitArr[i] == false){
                        queue.add(i);
                        visitArr[i] = true;
                    }
                }
            }
        }
    }
}

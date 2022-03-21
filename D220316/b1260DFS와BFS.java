package studyAlgorithm.D220316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class b1260DFS와BFS {

    static int[][] mapArr;
    static boolean[] visitArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        // 정점의 개수
        int N = Integer.parseInt(st.nextToken());
        mapArr = new int[N+1][N+1];
        visitArr = new boolean[N+1];
        // 간선의 개수
        int M = Integer.parseInt(st.nextToken());
        // 탐색을 시작할 정점의 번호
        int V = Integer.parseInt(st.nextToken());

        // 정점과 간선 세팅
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int vertexOne = Integer.parseInt(st.nextToken());
            int vertexTwo = Integer.parseInt(st.nextToken());

            mapArr[vertexOne][vertexTwo] = 1;
            mapArr[vertexTwo][vertexOne] = 1;
        }

        DFS(V);
        visitArr = new boolean[N+1];
        System.out.println("");
        BFS(V);
    }

    // DFS는 재귀 구현
    static void DFS(int V){
        visitArr[V] = true;
        System.out.print(V + " ");
        visitArr[V] = true;

        for(int i = 1 ; i < visitArr.length ; i++){
            if (mapArr[V][i] == 1 && visitArr[i] == false){
                DFS(i);
            }
        }
    }

    // BFS는 큐 구현
    static void BFS(int V){
        Queue<Integer> queue = new LinkedList();
        queue.add(V);
        visitArr[V] = true;
        //System.out.print(V + " ");

        while(!queue.isEmpty()){
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            for(int i = 1 ; i < visitArr.length ; i++){
                if(mapArr[vertex][i] == 1 && visitArr[i] == false){
                    queue.add(i);
                    visitArr[i] = true;
                }
            }
        }

    }
}

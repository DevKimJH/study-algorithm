package studyAlgorithm.D220308;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/**
 입력 값 테스트

6 9
1
1 2 8
1 3 1
1 4 2
3 2 5
3 4 2
4 5 3
4 6 5
5 6 1
6 1 5
 */
public class b1753최단경로 {
    static int[] minWeighArr;

    public static class Edge implements Comparable<Edge>{
        public int weight;
        public int arriveVertex;
        public int departVertex;

        public Edge(int departVertex, int arriveVertex, int weight){
            this.departVertex = departVertex;
            this.arriveVertex = arriveVertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge edge){
            return this.weight - edge.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        // 정점의 개수
        int V = Integer.parseInt(st.nextToken());

        // 간선의 개수
        int E = Integer.parseInt(st.nextToken());

        // 시작 정점
        int startVertex = Integer.parseInt(br.readLine());

        // 최단경로
        minWeighArr = new int[V+1];
        ArrayList<Edge>[] graph = new ArrayList[V+1];

        for(int i = 1 ; i <= V ; i++){
            graph[i] = new ArrayList<Edge>();
            minWeighArr[i] = Integer.MAX_VALUE;
        }

        // 간선 세팅
        for(int i = 0 ; i < E ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int departVertex = Integer.parseInt(st.nextToken());
            int arriveVertex = Integer.parseInt(st.nextToken());
            int weight  = Integer.parseInt(st.nextToken());

            graph[departVertex].add(new Edge(departVertex, arriveVertex, weight));
        }

        /*
        for(int i = 1 ; i < graph.length ; i++){
            if(!graph[i].isEmpty()){
                for(int j = 0 ; j < graph[i].size() ; j++){
                    System.out.print(graph[i].get(j).departVertex);
                    System.out.print(graph[i].get(j).arriveVertex);
                    System.out.print(graph[i].get(j).weight);
                }
                System.out.println("");
            }
        }*/

        process(graph, startVertex);
    }

    static void process(ArrayList<Edge>[] graph, int startVertex){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        minWeighArr[startVertex] = 0;
        pq.add(new Edge(0, startVertex, 0));

        while(!pq.isEmpty()){
            // 우선순위 큐에서 vertex 하나 뽑음
            Edge edge = pq.poll();

            // vertex에서 인접한 정점 검색
            for(int i = 0 ; i < graph[edge.arriveVertex].size() ; i++){
                // 우선순위 큐에서 뽑은 vertex와 인접한 정점
                int arriveVertex = graph[edge.arriveVertex].get(i).arriveVertex;

                // 우선순위 큐에서 뽑은 vertex와 인접한 정점까지 거리
                int weight = graph[edge.arriveVertex].get(i).weight;

                // 현재 저장되어있는 최소거리 배열에 있는 값보다
                // 현재까지의 경로 가중치 + 우선순위 큐에서 뽑은 vertex까지의 거리가 작으면
                if(minWeighArr[arriveVertex] > edge.weight + weight){
                    minWeighArr[arriveVertex] = edge.weight + weight;

                    pq.add(new Edge(0, arriveVertex, edge.weight + weight));
                }
            }
        }

        for(int i = 1; i < minWeighArr.length ; i++){
            if(minWeighArr[i] == Integer.MAX_VALUE){
                System.out.println("INF");
            }
            else{
                System.out.println(minWeighArr[i]);
            }
        }
    }
}

package studyAlgorithm.D220405;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;


/**
6 5
1 2
2 5
5 1
3 4
4 6
 */

public class B11724연결요소의개수_실패 {

    static boolean[] visitArr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        // 정점의 개수
        int N = Integer.parseInt(st.nextToken());
        
        // 간선의 개수
        int M = Integer.parseInt(st.nextToken());

        // 연결 요소 Count
        int answer = 0;

        ArrayList[] arrayLists = new ArrayList[N+1];
        visitArr = new boolean[N+1];

        for(int i = 0 ; i < N ; i++){
            arrayLists[i] = new ArrayList();
        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int inputFirstNum = Integer.parseInt(st.nextToken());
            int inputSecondNum = Integer.parseInt(st.nextToken());

            // 간선의 양 끝점 추가
            arrayLists[inputFirstNum].add(inputSecondNum);
        }

        for(int i = 1 ; i <= N ; i++){

            if(visitArr[i] == false){
                answer++;
                process(arrayLists, i);
            }

        }


        /*
        // 맵 출력 //
        for(int i = 0 ; i < N ; i++){
            for(int j = 0 ; j < arrayLists[i].size() ; j++){
                System.out.print(arrayLists[i].get(j));
            }
            System.out.println("");
        }

        */

        System.out.println(answer);
    }


    /**
    1. idx와 인접한 정점을 스택에 담는다.
    2.
     */
    
    static void process(ArrayList[] arrayLists, int idx){
        Stack stack = new Stack();

        if(arrayLists[idx] != null) {
            visitArr[idx] = true;
            for (int i = 0; i < arrayLists[idx].size(); i++) {
                int adjacentVertex = (int) arrayLists[idx].get(i);
                if (visitArr[adjacentVertex] == false) {
                    stack.push(adjacentVertex);
                    visitArr[adjacentVertex] = true;
                }
            }


            while(!stack.isEmpty()){
                process(arrayLists, (int) stack.pop());
            }

        }
    }
}

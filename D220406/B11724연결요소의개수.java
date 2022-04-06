package studyAlgorithm.D220406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11724연결요소의개수 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        // 정점의 개수
        int N = Integer.parseInt(st.nextToken());

        // 간선의 개수
        int M = Integer.parseInt(st.nextToken());

        int[][] mapArr = new int[N+1][N+1];
        boolean[] visitArr = new boolean[N+1];

        // 연결 요소 구하기 위한 변수
        int answer = 0;

        // 그래프 세팅
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int inputFirstNumber = Integer.parseInt(st.nextToken());
            int inputSecondNumber = Integer.parseInt(st.nextToken());

            mapArr[inputFirstNumber][inputSecondNumber] = 1;
            mapArr[inputSecondNumber][inputFirstNumber] = 1;
        }

        for(int i = 1 ; i <= N ; i++){
            if(visitArr[i] == false){
                process(mapArr, visitArr, i);
                answer++;
            }
        }

        System.out.println(answer);
    }

    static void process(int[][] mapArr, boolean[] visitArr, int idx){
        if(visitArr[idx] == true) return;

        visitArr[idx] = true;

        for(int i = 1 ; i < visitArr.length ; i++){
            if(visitArr[i] == false && mapArr[idx][i] == 1){
                process(mapArr, visitArr, i);
            }
        }
    }
}

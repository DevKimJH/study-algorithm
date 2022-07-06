package studyAlgorithm.D220626;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 모든 행성을 탐사하는데 걸리는 최소 시간 계산
 입력으로는 ana호가 탐색할 (행성의 개수)와
         ana호가 발사되는 (행성의 위치)
         ana호가 행성 간 이동을 하는데 걸리는 시간

 행성의 위치는 0부터 시작하여 0은 행렬에서 0번째 인덱스에 해당하는 행성을 의미

 모든 행성을 탐사하는데 걸리는 최소 시간
 탐사 후 다시 시작 행성으로 돌아올 필요는 없으며, 이미 방문한 행성도 중복해서 갈 수 있다



 */


public class B17182 {
        static boolean[] visitArr;
        static int minNum = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 행성의 개수
        int N = Integer.parseInt(st.nextToken());



        // 발사되는 행성의 위치
        int K = Integer.parseInt(st.nextToken());

        int[][] mapArr = new int[N][N];
        visitArr = new boolean[N];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                mapArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visitArr[K] = true;
        process(K, mapArr, 0, -1, -1);
    }

    static void process(int nodeNumber, int[][] mapArr, int sum, int prevNodeNum, int pprevNodeNum){
        for(int i = 0 ; i < mapArr.length ; i++){

            // 전체 탐색했으면
            for(int j = 0 ; j < mapArr.length ; j++){
                if(j == mapArr.length-1){
                    if(minNum > sum) minNum = sum;
                    return;
                }
            }

            // 같은 번호 탐색 방지
            if(i == nodeNumber){
                continue;
            }

            // 무한 루프 방지
            if(pprevNodeNum == nodeNumber && i == prevNodeNum){
                continue;
            }

            if(prevNodeNum == -1){
                prevNodeNum = nodeNumber;
            }
            else{
                pprevNodeNum = prevNodeNum;
                prevNodeNum = nodeNumber;
            }

            visitArr[i] = true;
            sum = sum + mapArr[nodeNumber][i];
            process(i, mapArr, sum, prevNodeNum, pprevNodeNum);
            visitArr[i] = false;
        }
    }
}

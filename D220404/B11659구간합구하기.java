package studyAlgorithm.D220404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 수 N개가 주어졌을 때 i번째 수에서 j번째 수까지의 합을 구하는 프로그램을 작성하시오.

 입력
 ---
 1번째 줄에 수의 개수 N ( 1 <= N <= 100,000) / 합을 구해야 하는 횟수 M ( 1 <= M <= 100,000)
 2번째 줄에 N개의 수가 주어진다.
 3번째 줄에 합을 구해야 하는 구간 i와 j가 구해진다.

 */
public class B11659구간합구하기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        
        // 데이터의 개수
        int N = Integer.parseInt(st.nextToken());
        
        // 질의 개수
        int M = Integer.parseInt(st.nextToken());

        // 배열의 합 구하기
        int[] numArr = new int[N+1];
        int[] sumArr = new int[N+1];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 1 ; i <= N ; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
            sumArr[i] = sumArr[i-1] + numArr[i];

        }

        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int firstZone = Integer.parseInt(st.nextToken());
            int secondZone = Integer.parseInt(st.nextToken());
            System.out.println(sumArr[secondZone] - sumArr[firstZone-1]);
        }

    }
}

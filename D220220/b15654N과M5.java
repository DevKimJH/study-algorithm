package studyAlgorithm.D220220;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 N개의 자연수 중에서 M개를 고른 수열
 둘째 줄에 N개의 수가 주어진다.
 */
public class b15654N과M5 {
        static int[] answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] numArr = new int[N];
        boolean[] chkArr = new boolean[N];
        answer = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0 ; i < N ; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr);

        process(0, numArr, chkArr, N, M);
    }

    static void process(int idx, int[] numArr, boolean[] chkArr, int N, int M){
        if(idx == M){
            for(int i = 0 ; i < M ; i++){
                System.out.print(answer[i] + " ");
            }
            System.out.println("");
        }

        for(int i = 0 ; i < N ; i++){
            if(chkArr[i] == false){
                chkArr[i] = true;
                answer[idx] = numArr[i];
                process(idx+1, numArr, chkArr, N, M);
                chkArr[i] = false;
            }
        }
    }
}

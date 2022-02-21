package studyAlgorithm.D220220;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 N개의 자연수 중에서 M개를 고른 수열
 같은 수를 여러 번 골라도 된다.


 */


public class b15656N과M7 {
    static int[] answer;
    static BufferedWriter bw;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

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

        bw.flush();
    }

    static void process(int idx, int[] numArr, boolean[] chkArr, int N , int M) throws Exception{
        if(idx == M){
            for(int i = 0 ; i < M ; i++){
                bw.write(answer[i] + " ");
            }
            bw.write('\n');
        }

        if(idx >= M){
            return;
        }

        for(int i = 0 ; i < N ; i++){
            answer[idx] = numArr[i];
            process(idx+1, numArr, chkArr, N , M);
        }
    }
}

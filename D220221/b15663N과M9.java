package studyAlgorithm.D220221;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 N개의 자연수 중에서 M개를 고른 수열
 수열은 사전 순으로 증가한느 순서로 출력해야 한다.
 */

public class b15663N과M9 {
    static BufferedWriter bw;
    static int[] answer;
    static boolean[] chkArr;
    static HashMap hashMap;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] numArr = new int[N];
        chkArr = new boolean[N];
        answer = new int[N];
        hashMap = new HashMap();
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0 ; i < N ; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr);

        process(0, numArr, N, M);

        bw.flush();
    }

    static void process(int idx, int[] numArr, int N, int M) throws Exception{
        if(idx == M){
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < M ; i++){
                //bw.write(answer[i] + " ");
                sb.append(answer[i]);
            }

            if(hashMap.get(Double.parseDouble(sb.toString())) == null){
                for(int i = 0 ; i < M ; i++){
                    bw.write(answer[i] + " ");
                }

                hashMap.put(Double.parseDouble(sb.toString()), Double.parseDouble(sb.toString()));
                bw.write("\n");
            }
            else{

            }
        }

        if(idx >= M){
            return;
        }

        for(int i = 0 ; i < N ; i++){
            if(chkArr[i] == false){
                chkArr[i] = true;
                answer[idx] = numArr[i];
                process(idx+1, numArr, N, M);
                chkArr[i] = false;
            }
        }
    }
}

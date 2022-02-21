package studyAlgorithm.D220220;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class b15657N과M8 {


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

        process(0, numArr, N, M);

        bw.flush();
    }

    static void process(int idx, int[] numArr, int N, int M) throws Exception{
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
            if(idx == 0){
                answer[idx] = numArr[i];
                process(idx+1, numArr, N, M);
            }
            else if(answer[idx-1] <= numArr[i]){
                answer[idx] = numArr[i];
                process(idx+1, numArr, N, M);
            }
        }
    }
}

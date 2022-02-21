package studyAlgorithm.D220220;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


/**
1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
 */
public class b15649N과M1 {
        static BufferedWriter bw;
        static int[] answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] chkArr = new boolean[N+1];
        answer = new int[N+1];

        for(int i = 1 ; i <= N ; i++){
            chkArr[i] = false;
        }

        process(0, chkArr, N, M);

    }

    static void process(int idx, boolean[] chkArr, int N, int M){
        if(idx == M){
            for(int i = 0 ; i < M ; i++){
                System.out.print(answer[i] + " " );
            }
            System.out.println("");
        }

        for(int i = 1 ; i <= N ; i++){
            if(chkArr[i] == false){
                chkArr[i] = true;
                answer[idx] = i;
                process(idx+1, chkArr, N, M);
                chkArr[i] = false;
            }
        }
    }
}

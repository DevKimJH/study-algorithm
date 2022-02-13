package studyAlgorithm.D220213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


/**
 1부터 N까지 자연수 중에서 M개를 고른 수열
 같은 수를 여러 번 골라도 된다.
 */
public class b15651N과M3 {

    static int[] answer;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        answer = new int[M];
        process(0, 0, N, M);
        bw.flush();
    }


    static void process(int index, int cnt, int N, int M) throws Exception{
        if(cnt == M){
            for(int i = 0 ; i < M ; i++){
                bw.write(answer[i] + " ");
            }
            bw.write("\n");
        }

        if(index >= M){
            return;
        }

        for(int i = 1 ; i <= N ; i++){
            if(index < M){
                answer[index] = i;
                process(index+1,cnt+1, N, M);
            }
        }
    }
}

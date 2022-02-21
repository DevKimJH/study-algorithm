package studyAlgorithm.D220221;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class b15665N과M11 {

    static BufferedWriter bw;
    static int[] answer;
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
            answer[idx] = numArr[i];
            process(idx+1, numArr, N, M);
        }
    }
}

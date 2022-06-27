package studyAlgorithm.D220627;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B13164 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] stdArr = new int[N];
        int[] heightArr = new int[N - 1];

        st = new StringTokenizer(br.readLine(), " ");


        for (int i = 0; i < N; i++) {
            stdArr[i] = Integer.parseInt(st.nextToken());

            if (i > 0) {
                heightArr[i - 1] = stdArr[i] - stdArr[i - 1];
            }
        }

        Arrays.sort(heightArr);

        int answer = 0;

        for (int i = 0; i < heightArr.length - (K - 1); i++) {
            answer = answer + heightArr[i];
        }

        System.out.println(answer);
    }
}


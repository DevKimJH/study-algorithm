package studyAlgorithm.D220620;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B2018 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 15
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            int num = i;
            int copyN = N;

            while (true) {
                copyN = copyN - num;
                num++;

                if (copyN == 0) {
                    answer++;
                    break;
                } else if (copyN < 0) {
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}


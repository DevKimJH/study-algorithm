package studyAlgorithm.D220628;


import java.io.*;
import java.util.*;

public class B15661 {
    static int N;
    static int M;
    static int[][] player;
    static boolean[] isStart;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        isStart = new boolean[N];
        player = new int[N][N];
        for (int i = 0; i < N; i++)
            player[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (M = 1; M < N; M++)
            bt(0, 0);
        System.out.print(result);
    }
    static void bt(int depth, int start) {
        if (depth == M) {
            int Ssum = 0;
            int Lsum = 0;
            for (int i = 0; i < N - 1; i++)
                for (int j = i+1; j < N; j++) {
                    if (isStart[i] && isStart[j])
                        Ssum += player[i][j] + player[j][i];
                    if (!isStart[i] && !isStart[j])
                        Lsum += player[i][j] + player[j][i];
                }
            result = Math.min(result, Math.abs(Ssum - Lsum));
            return;
        }
        for (int i = start; i < N; i++) {
            isStart[i] = true;
            bt(depth + 1, i + 1);
            isStart[i] = false;
        }
    }
}
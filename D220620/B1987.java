package studyAlgorithm.D220620;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1987 {
    static int count = 0;
    static int answer = 1;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] charMap = new char[R][C];
        boolean[][] visitMap;


        for (int i = 0; i < R; i++) {
            String inputStr = br.readLine();
            for (int j = 0; j < C; j++) {
                charMap[i][j] = inputStr.charAt(j);
            }
        }

        count = 1;
        visitMap = new boolean[R][C];
        HashMap hashMap = new HashMap();
        process(0, 0, charMap, visitMap, hashMap);

        System.out.println(answer);
    }

    static void process(int r, int c, char[][] charMap, boolean[][] visitMap, HashMap hashMap) {
        char charVal = charMap[r][c];
        hashMap.put(charVal, "1");
        visitMap[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int nextR = r + dr[i];
            int nextC = c + dc[i];

            if (0 <= nextR && nextR < charMap.length && 0 <= nextC && nextC < charMap[0].length) {
                charVal = charMap[nextR][nextC];
                if (visitMap[nextR][nextC] == false && hashMap.get(charVal) != "1") {
                    count++;
                    if (answer < count) {
                        answer = count;
                    }
                    process(nextR, nextC, charMap, visitMap, hashMap);
                    count--;
                    visitMap[nextR][nextC] = false;
                    hashMap.put(charVal, "0");
                }
            }
        }
    }
}
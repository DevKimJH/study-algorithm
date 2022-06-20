package studyAlgorithm.D220620;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B3109 {

    static int[] dr = {-1, 0, 1};
    static int answer = 0;
    static boolean chkArrive = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] mapArr = new char[r][c];
        boolean[][] visitArr = new boolean[r][c];


        for (int i = 0; i < r; i++) {
            String inputStr = br.readLine();
            for (int j = 0; j < c; j++) {
                //System.out.println(inputStr.charAt(j));
                mapArr[i][j] = inputStr.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            chkArrive = false;
            process(i, 0, mapArr, visitArr);
        }

        System.out.println(answer);
    }

    static void process(int r, int c, char[][] mapArr, boolean[][] visitArr) {

        if (c == mapArr[0].length - 1) {
            answer++;
            chkArrive = true;
        }
        visitArr[r][c] = true;
        for (int i = 0; i < 3; i++) {
            int nextR = r + dr[i];
            int nextC = c + 1;
            if (0 <= nextR && nextR < mapArr.length && nextC < mapArr[0].length) {
                if (visitArr[nextR][nextC] == false && mapArr[nextR][nextC] == '.') {
                    process(nextR, nextC, mapArr, visitArr);
                    if (chkArrive == true) {
                        return;
                    }
                }
            }
        }
    }
}


package studyAlgorithm.D220505;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P이취코_왕실의나이트 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int[][] mapArr = new int[9][9];
        int[][] moveArr = {{2, -1}, {2, 1}, {-2, -1}, {-2, 1}, {1, 2}, {1, -2}, {-1, -2}, {-1, 2}};

        String str = br.readLine();

        // R 좌표
        int knightR = str.charAt(0)-96;

        // C 좌표
        int knightC = str.charAt(1)-48;

        int answer = 0;

        for(int i = 0 ; i < 8 ; i++){
            int nextR = knightR + moveArr[i][0];
            int nextC = knightC + moveArr[i][1];

            if(1 <= nextR && nextR < 9 && 1 <= nextC && nextC < 9){
                answer++;
            }
        }

        System.out.println(answer);

    }
}

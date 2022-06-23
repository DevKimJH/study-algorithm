package studyAlgorithm.D220623;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B14500 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 세로크기
        int N = Integer.parseInt(st.nextToken());

        // 가로크기
        int M = Integer.parseInt(st.nextToken());

        int[][] mapArr = new int[N][M];

        int maxNum = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                mapArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int score = 0;
                // case 1
                try {

                    score = mapArr[i][j] + mapArr[i + 1][j] + mapArr[i + 1][j - 1] + mapArr[i + 1][j + 1];
                    if (maxNum < score) maxNum = score;

                } catch (Exception e) {
                }



                /* case 2
                    10
                    11
                    10
                 */
                try {

                    score = mapArr[i][j] + mapArr[i + 1][j] + mapArr[i + 2][j] + mapArr[i + 1][j + 1];
                    if (maxNum < score) maxNum = score;

                } catch (Exception e) {
                }

                /* case 3
                    111
                    010
                 */
                try {

                    score = mapArr[i][j] + mapArr[i][j + 1] + mapArr[i][j + 2] + mapArr[i + 1][j + 1];
                    if (maxNum < score) maxNum = score;

                } catch (Exception e) {
                }


                /* case 4
                    01
                    11
                    01
                 */
                try {

                    score = mapArr[i][j + 1] + mapArr[i + 1][j] + mapArr[i + 1][j + 1] + mapArr[i + 2][j + 1];
                    if (maxNum < score) maxNum = score;

                } catch (Exception e) {
                }

                /* case 5
                    11
                    11
                 */
                try {

                    score = mapArr[i][j] + mapArr[i][j + 1] + mapArr[i + 1][j] + mapArr[i + 1][j + 1];
                    if (maxNum < score) maxNum = score;

                } catch (Exception e) {
                }

                /* case 6
                    1
                    1
                    1
                    1
                 */
                try {

                    score = mapArr[i][j] + mapArr[i + 1][j] + mapArr[i + 2][j] + mapArr[i + 3][j];
                    if (maxNum < score) maxNum = score;

                } catch (Exception e) {
                }

                /* case 7
                    1111
                 */
                try {
                    score = mapArr[i][j] + mapArr[i][j + 1] + mapArr[i][j + 2] + mapArr[i][j + 3];
                    if (maxNum < score) maxNum = score;

                } catch (Exception e) {
                }

                /* case 8
                    10
                    10
                    11
                 */
                try {

                    score = mapArr[i][j] + mapArr[i + 1][j] + mapArr[i + 2][j] + mapArr[i + 2][j + 1];
                    if (maxNum < score) maxNum = score;

                } catch (Exception e) {
                }

                /* case 9
                    111
                    100
                 */
                try {

                    score = mapArr[i][j] + mapArr[i][j + 1] + mapArr[i][j + 2] + mapArr[i + 1][j];
                    if (maxNum < score) maxNum = score;

                } catch (Exception e) {
                }


                /* case 10
                    11
                    01
                    01
                 */
                try {

                    score = mapArr[i][j] + mapArr[i][j + 1] + mapArr[i + 1][j + 1] + mapArr[i + 2][j + 1];
                    if (maxNum < score) maxNum = score;

                } catch (Exception e) {
                }

                /* case 11
                    001
                    111
                 */
                try {

                    score = mapArr[i][j + 2] + mapArr[i + 1][j] + mapArr[i + 1][j + 1] + mapArr[i + 1][j + 2];
                    if (maxNum < score) maxNum = score;

                } catch (Exception e) {
                }

                /* case 12
                    11
                    10
                    10
                 */
                try {

                    score = mapArr[i][j] + mapArr[i][j + 1] + mapArr[i + 1][j] + mapArr[i + 2][j];
                    if (maxNum < score) maxNum = score;

                } catch (Exception e) {
                }

                /* case 13
                    111
                    001
                 */
                try {
                    score = mapArr[i][j] + mapArr[i][j + 1] + mapArr[i][j + 2] + mapArr[i + 1][j + 2];
                    if (maxNum < score) maxNum = score;
                } catch (Exception e) {
                }

                /* case 14
                    01
                    01
                    11
                 */
                try {
                    score = mapArr[i][j + 1] + mapArr[i + 1][j + 1] + mapArr[i + 2][j + 1] + mapArr[i + 2][j];
                    if (maxNum < score) maxNum = score;
                } catch (Exception e) {
                }

                /* case 15
                    100
                    111
                 */

                try {
                    score = mapArr[i][j] + mapArr[i + 1][j] + mapArr[i + 1][j + 1] + mapArr[i + 1][j + 2];
                    if (maxNum < score) maxNum = score;
                } catch (Exception e) {
                }

                /* case 16
                    10
                    11
                    01
                 */
                try {
                    score = mapArr[i][j] + mapArr[i + 1][j] + mapArr[i + 1][j + 1] + mapArr[i + 2][j + 1];
                    if (maxNum < score) maxNum = score;
                } catch (Exception e) {
                }

                /* case 17
                    011
                    110
                 */
                try {
                    score = mapArr[i][j + 1] + mapArr[i][j + 2] + mapArr[i + 1][j] + mapArr[i + 1][j + 1];
                    if (maxNum < score) maxNum = score;
                } catch (Exception e) {
                }

                /* case 18
                    01
                    11
                    10
                 */
                try {
                    score = mapArr[i][j + 1] + mapArr[i + 1][j] + mapArr[i + 1][j + 1] + mapArr[i + 2][j];
                    if (maxNum < score) maxNum = score;
                } catch (Exception e) {
                }

                /* case 19
                    110
                    011
                 */
                try {
                    score = mapArr[i][j] + mapArr[i][j + 1] + mapArr[i + 1][j + 1] + mapArr[i + 1][j + 2];
                    if (maxNum < score) maxNum = score;
                } catch (Exception e) {
                }
            }
        }

        System.out.println(maxNum);
    }
}


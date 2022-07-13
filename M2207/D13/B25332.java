package studyAlgorithm.M2207.D13;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
 A = {A1, A2, ..., AN}
 B = {B1, B2, ..., BN}

 Ai + Ai+1 + ... + Aj = Bi + Bi+1 + ... + Bj 를 만족하는 양의 정수 i, j(i <= j) 쌍의 개수 구하기


3
1 2 3
1 3 2
---
3
11 12 13
22 23
33

1. 11 / 22 / 33 비교
2. 12(11 + 22) / 23(22 + 33) / 비교
3. 13(11 + 23) 비교
--------------------------------------------------
6
23 13 31 17 29 19
23 13 31 17 29 19
---
21
11 12 13 14 15 16
22 23 24 25 26
33 34 35 36
44 45 46
55 56
66

1. 11 (11 + 00) / 22 (22 + 00) / 33(33 + 00) / 44(44 + 00) / 55(55 + 00) / 66(66 + 00) 비교
2. 12 (11 + 22) / 23 (22 + 33) / 34(33 + 44) / 45(44 + 55) / 56(55+66)
3. 13 (11 + 23) / 24 (22 + 34) / 35(33 + 45) / 46(44 + 56)
4. 14 (11 + 24) / 25 (22 + 35) / 36(33 + 46)
5. 15 (11 + 25) / 26 (22 + 36)
6. 16 (11 + 26)
 */

public class B25332 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 합 기록 저장용
        //int[][] firstSumMemo = new int[N][N];
        HashMap<String, Integer> firstSumMemo = new HashMap<>();
        //int[][] secondSumMemo = new int[N][N];
        HashMap<String, Integer> secondSumMemo = new HashMap<>();
        long answer = 0;

        /* 수열 세팅 */
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < N; j++) {
            //firstSumMemo[j][j] = Integer.parseInt(st.nextToken());
            firstSumMemo.put(j + "" + j, Integer.parseInt(st.nextToken()));
            //firstSumMemo[j][j] = Long.parseLong(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < N; j++) {
            //secondSumMemo[j][j] = Long.parseLong(st.nextToken());
            //secondSumMemo[j][j] = Integer.parseInt(st.nextToken());
            secondSumMemo.put(j + "" + j, Integer.parseInt(st.nextToken()));
        }

        /* sumMemo[N][N] 세팅 */
        /*
        for(int j = 0 ; j < N ; j++){
            firstSumMemo[j][j] = firstArray[j];
        }

        for(int j = 0 ; j < N ; j++){
            secondSumMemo[j][j] = secondArray[j];
        }
        */

        for (int i = 0; i < N; i++) {
            if (firstSumMemo.get(i + "" + i) == secondSumMemo.get(i + "" + i)) {
                answer++;
            }
        }

        /* sumMemo[N][N] 이외 값 세팅 */
        // 11, 22, 33, 44, 55, 66

        /*
        01 12 23 34 45
        02 13 24 35
        03 14 25
        04 15
        05
         */

        int idx = N - 1;
        int gap = 1;
        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < idx; j++) {
                //System.out.print(j + "" + (j+gap) + " ");
                int firstIdx = j;
                int secondIdx = j + gap;

                firstSumMemo.put(firstIdx + "" + secondIdx, firstSumMemo.get(firstIdx + "" + firstIdx) + firstSumMemo.get((firstIdx + 1) + "" + secondIdx));
                secondSumMemo.put(firstIdx + "" + secondIdx, secondSumMemo.get(firstIdx + "" + firstIdx) + secondSumMemo.get((firstIdx + 1) + "" + secondIdx));

                boolean isTrue = firstSumMemo.get(firstIdx + "" + secondIdx).toString().equals(secondSumMemo.get(firstIdx + "" + secondIdx).toString());

                if (isTrue) {
                    answer++;
                }
            }
            idx--;
            gap++;
        }

        System.out.print(answer);

        // 삽질 1
        /*
        for(int i = 5 ; i > 0 ; i--){
            for(int j = 0 ; j < i ; j++){
                System.out.print(j+1 + "" + 0 + " ");
            }
            System.out.println("");
        }

        int idx = 1;
        for(int i = 5 ; i >= 0 ; i--){
            idx++;
           for(int j = idx ; j <= 6 ; j++){
               System.out.print(j + " ");
           }
           System.out.println("");
        }

         */
    }

    /*
    11 (11 + 00) / 22 (22 + 00) / 33(33 + 00) / 44(44 + 00) / 55(55 + 00) / 66(66 + 00) 비교
    12 (11 + 22) / 23 (22 + 33) / 34(33 + 44) / 45(44 + 55) / 56(55+66)
    13 (11 + 23) / 24 (22 + 34) / 35(33 + 45) / 46(44 + 56)
    14 (11 + 24) / 25 (22 + 35) / 36(33 + 46)
    15 (11 + 25) / 26 (22 + 36)
    16 (11 + 26)

    13 = 11 + 23
     */
}


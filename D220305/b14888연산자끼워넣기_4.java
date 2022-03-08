package studyAlgorithm.D220305;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14888연산자끼워넣기_4 {

    static int maxNum = Integer.MIN_VALUE;
    static int minNum = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];
        int[] processArr = new int[N-1];
        boolean[] visitArr = new boolean[N-1];

        int processIdx = 0;
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0 ; i < N ; i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0 ; i < 4 ; i++){
            int processCnt = Integer.parseInt(st.nextToken());
            for(int j = 0 ; j < processCnt ; j++){
                processArr[processIdx++] = i;
            }
            //processArr[i] = Integer.parseInt(st.nextToken());
        }

        process(N, 1, numArr, processArr, visitArr, numArr[0]);

        System.out.println(maxNum);
        System.out.println(minNum);
    }

    static void process(int N, int idx, int[] numArr, int[] processArr, boolean[] visitArr, int number) {
            if (idx == N) {
                if (number > maxNum) {
                    maxNum = number;
                }

                if (number < minNum) {
                    minNum = number;
                }
            } else {
                for (int i = 0; i < N-1; i++) {
                    if (visitArr[i] == false) {
                        visitArr[i] = true;
                        if (processArr[i] == 0) {
                            //number += numArr[idx];
                            process(N, idx + 1, numArr, processArr, visitArr, number + numArr[idx]);
                        } else if (processArr[i] == 1) {
                            //number -= numArr[idx];
                            process(N, idx + 1, numArr, processArr, visitArr, number - numArr[idx]);
                        } else if (processArr[i] == 2) {
                            //number *= numArr[idx];
                            process(N, idx + 1, numArr, processArr, visitArr, number * numArr[idx]);
                        } else if (processArr[i] == 3) {
                            //number /= numArr[idx];
                            process(N, idx + 1, numArr, processArr, visitArr, number / numArr[idx]);
                        }

                        //process(N, idx + 1, numArr, processArr, visitArr, number);

                        visitArr[i] = false;
                    }
                }
            }
    }
}

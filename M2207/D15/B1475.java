package studyAlgorithm.M2207.D15;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B1475 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int[] numberArr = new int[10];

        int answer = 0;

        for (int i = 0; i < inputStr.length(); i++) {
            int idx = inputStr.charAt(i) - 48;
            if (idx == 9) {
                idx = 6;
            }

            numberArr[idx]++;

            if (idx == 6) {
                int value = (int) Math.ceil(numberArr[idx] / (2.0));
                if (answer < value) {
                    answer = value;
                }
            } else {
                if (answer < numberArr[idx]) {
                    answer = numberArr[idx];
                }
            }
        }

        System.out.print(answer);
    }
}


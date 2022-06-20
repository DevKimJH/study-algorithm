package studyAlgorithm.D220620;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * L개의 알파벳으로 구성
 * 최소 한 개의 모음(aeiou)
 * 최소 두 개의 자음
 * <p>
 * C개의 문자가 주어졌을 때 가능성 있는 암호들을 모두 구하는 프로그램
 */
public class B1759 {

    static int countVow = 0; // 모음
    static int countCon = 0; // 자음


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int L = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        //ArrayList<Character> charArr1 = new ArrayList<>();
        //ArrayList<Character> charArr2 = new ArrayList<>();
        char[] charArr1 = new char[C];
        boolean[] useArr = new boolean[C];

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < C; i++) {
            charArr1[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(charArr1);
        process(0, L, charArr1, useArr, sb, 0);
    }

    static void process(int idx, int L, char[] charArr, boolean[] useArr, StringBuilder sb, int number) {
        if (idx == L) {
            if (countVow > 0 && countCon > 1) {
                System.out.println(sb);
            }
            return;
        }

        for (int i = number; i < charArr.length; i++) {
            if (useArr[i] == false) {
                useArr[i] = true;
                sb.append(charArr[i]);
                if (charArr[i] == 'a' || charArr[i] == 'e' ||
                        charArr[i] == 'i' || charArr[i] == 'o' || charArr[i] == 'u') {
                    countVow++;
                } else {
                    countCon++;
                }
                process(idx + 1, L, charArr, useArr, sb, i);
                sb.delete(idx, idx + 1);
                useArr[i] = false;
                if (charArr[i] == 'a' || charArr[i] == 'e' ||
                        charArr[i] == 'i' || charArr[i] == 'o' || charArr[i] == 'u') {
                    countVow--;
                } else {
                    countCon--;
                }
            }
        }
    }
}


package studyAlgorithm.D220228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b1676팩토리얼0의개수 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int answer = 0;

        answer = answer + (N / 5);
        answer = answer + (N / 25);
        answer = answer + (N/125);

        System.out.print(answer);
    }
}

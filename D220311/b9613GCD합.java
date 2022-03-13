package studyAlgorithm.D220311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b9613GCD합 {
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 테스트 케이스의 수 t
        int t = Integer.parseInt(br.readLine());

        // 수의 개수 n
        int[] arr;
        for(int i = 0 ; i < t ; i++){
            answer = 0;
            st = new StringTokenizer(br.readLine(), " " );
            int n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            for(int j = 0 ; j < n ; j++){
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for(int j = 0 ; j < arr.length ; j++){
                for(int k = j+1 ; k < arr.length ; k++){
                    answer += GCD(arr[j], arr[k]);
                }
            }
            System.out.println(answer);
        }
    }

    static int GCD(int firstNum, int secondNum) {
        if (secondNum == 0) {
            return firstNum;
        }

        return GCD(secondNum, firstNum % secondNum);
    }
}

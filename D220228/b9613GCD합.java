package studyAlgorithm.D220228;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 양의 정수 n개가 주어졌을 때, 가능한 모든 쌍의 GCD의 합을 구하는 프로그램을 작성하시오.

 첫째 줄에 테스트 케이스의 개수 t가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있다.
 각 테스트 케이스는 수의 개수
 */
public class b9613GCD합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < t ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int[] numArr = new int[st.countTokens()];
            long answer = 0;
            int idx = 0;

            // 입력받은 수 arr 세팅
            while(st.hasMoreTokens()){
                numArr[idx++] = Integer.parseInt(st.nextToken());
            }

            for(int j = 1 ; j < numArr.length ; j++){
                for(int k = j+1 ; k < numArr.length ; k++){
                    answer += GCD(numArr[j], numArr[k]);
                }
            }
            System.out.println(answer);
        }
    }

    /*
    static int GCD(int num1, int num2){
       if(num1 % num2 == 0){
           return num2;
       }

       return GCD(num2, num1%num2);
    }*/

    static int GCD(int num1, int num2){
        if(num2 == 0){
            return num1;
        }
        else{
            return GCD(num2, num1%num2);
        }
    }
}

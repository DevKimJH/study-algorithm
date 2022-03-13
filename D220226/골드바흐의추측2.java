package studyAlgorithm.D220226;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


/**
 4보다 큰 모든 짝수는 두 홀수 소수의 합으로 나타낼 수 있다.
 예를 들어 8은 3+5로 나타낼 수 있고, 3과 5는 모두 홀수인 소수이다.
 또, 20 = 3 + 17 = 7 + 13
 42 = 5 + 37 = 11 + 31 = 13 + 29 = 19 + 23 이다.

 입력
 --
 하나 또는 그 이상의 테스트 케이스. 테스트 케이스의 개수는 100,000개를 넘지 않는다.
 각 테스트 케이스는 짝수 정수 n 하나로 이루어져 있다.(6 <= n <= 1000000)
 입력의 마지막 줄에는 0이 하나 주어진다.

 출력
 --
 각 테스트 케이스에 대해서, n = a + b 형태로 출력한다. 이때 a와 b는 홀수 소수이다.
 숫자와 연산자는 공백 하나로 구분되어져 있다.
 만약, n을 만들 수 있는 방법이 여러 가지라면, b-a가 가장 큰 것을 출력한다. 또, 두 홀수 소수의 합으로
 n을 나타낼 수 없는 경우에는 "Goldbach's conjecture is wrong."을 출력한다.
 */

public class 골드바흐의추측2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            int inputNum = Integer.parseInt(br.readLine());
            boolean wrongFlag = false;

            if(inputNum == 0){
                break;
            }

            int startNum = inputNum-1;

            for(int i = startNum ; i >= 2; i = i-2){
                // maxB가 소수
                if(process(i)){
                    int firstNum = inputNum - i;
                    if(firstNum == 1) continue;

                    boolean result = process(firstNum);

                    if(result){
                        System.out.println(inputNum + " = " + firstNum + " + " + i);
                        wrongFlag = true;
                        break;
                    }
                }
            }

            if(wrongFlag == false){
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }

    static boolean process(int num){
        if(num < 2){
            return false;
        }

        for(int i = 2 ; i * i <= num ; i++){
            if(num % i == 0){
                return false;
            }
        }

        return true;
    }
}

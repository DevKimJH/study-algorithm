package studyAlgorithm.D220316;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * N개의 음이 아닌 정수들이 있다.
 * 정수들을 순서를 바꾸지 않고 적절히 더하거나 빼서 타겟 넘버를 만들려고 한다.
 *
 * 숫자를 적절히 더하고 빼서 타겟 넘버를 만드는 방법의 수를 return
 *
 *
 */
public class p타겟넘버 {

    static int answer = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        /*
        int[] numbers = {1,1,1,1,1};
        int target = 3;
        */

        int[] numbers = {4, 1, 2, 1};
        int target = 4;

        process(numbers, target, 0,0);

        System.out.println(answer);
    }

    static void process(int[] numbers, int target, int number, int idx){
        if(idx == numbers.length){
            if(number == target){
                answer++;
            }
        }

        if(idx >= numbers.length){
            return;
        }

        process(numbers, target, number + numbers[idx], idx+1);
        process(numbers, target, number - numbers[idx], idx+1);
    }
}

package studyAlgorithm.D220506;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 5
 5
 2
 3
 4
 1
 */
public class B2750수정렬하기_삽입정렬 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] numberArr = new int[N];

        for(int i = 0 ; i < N ; i++){
            numberArr[i] = Integer.parseInt(br.readLine());
        }

        MySort(numberArr);
    }

    // 5 2 3 4 1
    // 2 5 3 4 1
    // 2 3 5 4 1
    // 2 3 4 5 1
    // 1 2 3 4 5
    static void MySort(int[] numberArr){
        for(int i = 1 ; i < numberArr.length ; i++){
            int num = numberArr[i]; // 2

            int j = i-1;

            while(j >= 0 && num < numberArr[j]){
                numberArr[j+1] = numberArr[j];
                j--;
            }

            numberArr[j+1] = num;
        }
    }
}

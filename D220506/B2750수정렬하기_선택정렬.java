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
public class B2750수정렬하기_선택정렬 {

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

    static void MySort(int[] numberArr){
        for(int i = 0 ; i < numberArr.length ; i++){
            int minNum = numberArr[i];
            int minNumIdx = i;
            for(int j = i+1 ; j < numberArr.length ; j++){
                if(minNum > numberArr[j]){
                    minNum = numberArr[j];
                    minNumIdx = j;
                }
            }

            int temp =  numberArr[i];
            numberArr[i] = numberArr[minNumIdx];
            numberArr[minNumIdx] = temp;

            System.out.println(numberArr[i]);
        }
    }
}

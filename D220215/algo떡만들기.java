package studyAlgorithm.D220215;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 떡볶이 떡의 길이가 일정하지 않다. 대신 한 봉지 안에 들어가는 떡의 총 길이는 절단기로 잘라서 맞춰준다.
 * 절단기에 높이(H)를 지정하면 줄지어진 떡을 한 번에 절단한다. 높이가 H보다 긴 떡은 H위의 부분이 잘릴 것이고, 낮은 떡은 잘리지 않는다.
 *
 * 19, 14, 10, 17인 떡이 나란히 있고 절단기 높이를 15cm로 지정하면 자른 뒤 떡 = 15 14 10 15
 * 잘린 떡 4 0 0 2 손님은 6cm만큼의 길이를 가져간다.
 *
 * 요청한 총 길이가 M일 때 적어도 M만큼의 떡을 얻기 위해 절단기에 설정할 수 있는 높이의 최댓값
 *
 *
4 6
19 15 10 17

 15

 4 0 0 2
 ---
6 8
10 13 15 17 18 20 22 24

 18
 0 0 0 0 0 2 2 4
 ---
8 35
10 20 30 40 50 60 70 80

 40
 00 00 00 00 10 20 30 40 = 100

 59
 00 00 00 00 00 01 11 21 33
 ---
4 200
40 50 60 70

 5
 35 45 55 65
 ---
5 20
4 26 40 42 46

 36
 0 0 4 6 10
 ---

 1 <= N <= 1000000
 1 <= M <= 2000000000

5 20
4 42 40 26 46
 */
public class algo떡만들기 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine(), " ");
        // 떡의 개수
        int N = Integer.parseInt(st.nextToken());

        // 요청한 떡의 길이
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0 ; i < N ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        process(arr, arr[0], arr[arr.length-1], M);
    }

    //static void process(int[] arr, int start, int end, int M){
    static void process(int[] arr, int firstValue, int secondValue, int M){
        //int middle = (start + end)/2;
        int middleValue = (firstValue + secondValue)/2;
        int value = 0;

        for(int i = 0 ; i < arr.length ; i++){
            //int calcValue = arr[i] - arr[middle];
            int calcValue = arr[i] - middleValue;
            if(calcValue > 0){
                value += arr[i] - middleValue;
                //value += arr[i] - arr[middle];
            }
        }

        if(value == M){
            System.out.println(middleValue);
            return;
        }
        else if(M > value){
            process(arr, firstValue, middleValue-1, M);
        }
        else if(M <= value){
            process(arr, middleValue+1, secondValue, M);
        }
    }
}

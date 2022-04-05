package studyAlgorithm.D220404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 자기 점수 중 최댓값을 골랐다.
 그런 다음 최댓값을 M이라 했을 때 모든 점수를 점수 / M * 100 으로 고쳤다.
 최고점이 70점, 수학 점수가 50점이라면 수학 점수는 50 / 70 * 100 이므로 71.43점이다.
 이 방버으로 계산했을 때 새로운 평균을 구하는 프로그램을 작성하시오.
 */



public class B1546평균구하기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // 시험을 본 과목의 개수
        int N = Integer.parseInt(br.readLine());

        double[] arr = new double[N];

        st = new StringTokenizer(br.readLine(), " ");

        double maxNum = Double.MIN_VALUE;

        // 각 과목의 시험 성적
        for(int i = 0 ; i < N ; i++){
            arr[i] = Double.parseDouble(st.nextToken());
            // 최댓값 구하는 process
            if(maxNum < arr[i]){
                maxNum = arr[i];
            }
        }

        // 새로운 점수로 계산 
        for(int i = 0 ; i < N ; i++){
            arr[i] = arr[i] / maxNum * 100;
        }
        
        // 평균 구하기
        double answer = 0;
        for(int i = 0 ; i < N ; i++){
            answer += arr[i];
        }

        System.out.println(answer/N);
    }
}

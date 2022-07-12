package studyAlgorithm.M2207.D12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 입려값이 2,3,1,2,2

 1. 작은 수부터 넣기 ( 1, .. 2, .. 3, ..
 2. count랑 memberArr[idx] 랑 같으면 answer++
 3. 다르면
 */
public class E모험가길드 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] memberArr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            memberArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(memberArr);

        int idx = 0;
        int count = 1;
        int answer = 0;
        while(idx < N){
            // 1일 경우 들어옴
            if(count == memberArr[idx]){
                count = 1;
                answer++;
            }
            else{
                count++;
            }
            idx++;
        }

        System.out.print(answer);
    }
}

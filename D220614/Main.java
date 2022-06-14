package studyAlgorithm.D220614;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


/**
 4 1
 1 2 3 4
 2 3 4 5
 3 4 5 6
 4 5 6 7
 3 3 4 4
 2 2 3 4
 3 4 3 4
 1 1 4 4
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        // 표의 크기
        int N = Integer.parseInt(st.nextToken());

        // 구해야하는 횟수
        int M = Integer.parseInt(st.nextToken());

        int[][] numArr = new int[N+1][N+1];
        int[][] sumArr = new int[N+1][N+1];

        for(int i = 1 ; i <= N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1 ; j <= N ; j++){
                int inputNumber = Integer.parseInt(st.nextToken());
                numArr[i][j] = inputNumber;
                sumArr[i][j] = sumArr[i][j-1] + inputNumber;
            }
        }


        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int firstStartIdx   = Integer.parseInt(st.nextToken());
            int firstEndIdx     = Integer.parseInt(st.nextToken());
            int secondStartIdx  = Integer.parseInt(st.nextToken());
            int secondEndIdx    = Integer.parseInt(st.nextToken());

            if(firstStartIdx == secondStartIdx && firstEndIdx == secondEndIdx){
                sb.append(numArr[firstStartIdx][firstEndIdx]).append("\n");
            }
            else if(firstStartIdx == secondStartIdx){
                int calcResult = sumArr[secondStartIdx][secondEndIdx] - numArr[firstStartIdx][firstEndIdx-1];
                sb.append(calcResult).append("\n");
            }
            else{
                int calcResult = 0;
                for(int j = firstStartIdx ; j <= secondStartIdx ; j++){

                    if(j == firstStartIdx){
                        calcResult += sumArr[j][4] - sumArr[j][firstEndIdx-1];
                    }
                    else if(j == secondStartIdx){
                        calcResult += sumArr[j][secondEndIdx] - sumArr[j][firstEndIdx-1];
                    }
                    else{
                        calcResult += sumArr[j][4] - sumArr[j][firstEndIdx-1];
                    }

                    //calcResult += sumArr[j][4] - numArr[j][firstEndIdx-1];
                }

                sb.append(calcResult).append("\n");
            }
        }

        bw.write(sb+"");
        bw.close();

    }
}


package studyAlgorithm.M2207.D2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 학교에서 집으로 가려고 한다.
 도시의 크기는 무한대,
 도시의 세로 도로는 모든 정수 x좌표마다 있고,
      가로 도로는 모든 정수 y좌표마다 있다.

 현재 위치는 (0,0), (X,Y)에 위치한 집으로 가려고 한다.
 걸을 수 있는 방법은 두가지
 - 도로를 따라서 가로나 세로로 한 블록 움직여서 이번 사거리에서 저 사거리로 움직이는 방법
 - 블록을 대각선으로 가로지르는 방법

 세준이가 집으로 가는데 걸리는 최소 시간을 구하는 프로그램을 작성하시오
 */
public class B1459 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 집의 위치
        int X = Integer.parseInt(st.nextToken());

        // 집의 위치
        int Y = Integer.parseInt(st.nextToken());

        // 걸어서 한 블록 가는데 걸리는 시간
        int W = Integer.parseInt(st.nextToken());

        // 대각선으로 한 블록을 가로지르는 시간
        int S = Integer.parseInt(st.nextToken());

        int answer = 0;

        /**
         X좌표와 Y좌표중 작은 값까지는
         대각선으로 이동이 가능하다.
         */
        int diagonalPoint = 0;
        if(X > Y){
            diagonalPoint = Y;
        }
        else{
            diagonalPoint = X;
        }

        // 걸어서 블록 두번 이동하는 시간이
        // 대각선으로 한 블록 이동하는 시간보다
        // 오래 걸리면
        if(W*2 > S && Y > 0 ){
            answer = diagonalPoint * S;
        }
        else{
            answer = diagonalPoint * W*2;
        }

        answer = answer + Math.abs(Y-X) * W;

        System.out.println(answer);

    }
}

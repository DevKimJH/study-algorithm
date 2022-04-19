package studyAlgorithm.D220419;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 왕실 정원은 체스판과 같은 8 * 8 좌표 정면이다.
 왕실 정원의 특정한 한 칸에 나이트가 서 있다. 나이트는 매우 충성스러운 신하로서 매일 무술을 연마한다.

 나이트는 말을 타고 있기 때문에 이동을 할 때 L자 형태로만 이동할 수 있으며 정원 밖으로는 나갈 수 없다.
 나이트는 특정한 위치에서 다음과 같은 2가지 경우로 이동할 수 있다.

 1. 수평으로 두 칸 이동한 뒤에 수직으로 한 칸 이동하기
 2. 수직으로 두 칸 이동한 뒤에 수평으로 한 칸 이동하기

 8 * 8 좌표 평면상에서 나이트의 위치가 주어졋을 때 나이트가 이동할 수 있는 경우의 수를 출력

 왕실 정원 행 위치를 1 ~ 8 로 표현
 왕실 정원 열 위치는 a ~ h 로 표현

 ex) 만약 나이트가 a1에 있을 때 이동할 수 있는 경우의 수는 다음 2가지이다.
 1. 오른쪽으로 두 칸 이동 후 아래로 한 칸 이동하기(c2)
 2. 아래로 두 칸 이동 후 오른쪽으로 한 칸 이동하기(b3)
 */

public class P왕실의나이트 {

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int[][] steps = {{-2,-1}, {-1,-2}, {1, -2}, {2, -1}, {2, 1}, {1,2}, {-1,2}, {-2,1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        String knightPosition = br.readLine();

        // 열
        int c = knightPosition.charAt(0) - 96;

        // 행
        int r = knightPosition.charAt(1) - 48;

        System.out.println(c);
        System.out.println(r);

        int answer = 0;

        // 상 우 하 좌
        for(int i = 0 ; i < 4 ; i++){

            int nextR = r + dr[i] + dr[i];
            int nextC = c + dc[i] + dc[i];

            if(0 < nextR && nextR < 9 && 0 < nextC && nextC < 9){
                for(int j = 0 ; j < 2 ; j++){
                    // 상이나 하로 이동했을때
                    if(i == 0 || i == 2){
                        // 좌로 이동
                        if(j == 0){
                            if(1 < nextC){
                                answer++;
                            }
                        }
                        // 우로 이동
                        else if(j == 1){
                            if(nextC < 8){
                                answer++;
                            }
                        }

                    }
                    // 좌나 우로 이동했을때
                    else if(i == 1 || i == 3){
                        // 상으로 이동
                        if(j == 0){
                            if(1 < nextR){
                                answer++;
                            }
                        }
                        // 하로 이동
                        else if(j==1){
                            if(nextR < 8){
                                answer++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(answer);
    }
}

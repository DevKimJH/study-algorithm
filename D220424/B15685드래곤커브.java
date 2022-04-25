package studyAlgorithm.D220424;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 드래곤 커브는 다음과 같은 세 가지 속성으로 이루어져 있으며, 이차원 좌표 평면 위에서 정의된다.

 좌표 평면의 X축은 -> 방향, y축은 아래 방향이다.

 1. 시작 점
 2. 시작 방향
 3. 세대

 0세대 드래곤 커브는 아래 그림과 같은 길이가 1인 선분이다. 아래 그림은 (0,0)에서 시작하고, 시작 방향은 오른쪽인 0세대 드래곤 커브이다.

 (0,0) (1,0)

 1세대 드래곤 커브는 0세대 드래곤 커브를 끝 점을 기준으로 시계 방향으로 90도 회전시킨 다음 0세대 드래곤 커브의 끝 점에 붙인 것이다.
 끝 점이란 시작 점에서 선분을 타고 이동했을 때, 가장 먼 거리에 있는 점을 의미한다.


 첫째 줄에 드래곤 커브의 개수 N(1<= N <= 20)이 주어진다. 둘째 줄부터 N개의 줄에는 드래곤 커브의 정보가 주어진다. 드래곤 커브의 정보는
 x, y, d, g로 이루어져 있다. x와 y는 드래곤 커브의 시작 점, d는 시작 방향, g는 세대이다.


 0 ->
 1 위
 2 <-
 3 아래

 */

public class B15685드래곤커브 {

    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;


        // 드래곤 커브의 개수
        int N = Integer.parseInt(br.readLine());

        int[][] mapArr = new int[101][101];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int c = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            //int direction = Integer.parseInt(st.nextToken());
            StringBuilder direction = new StringBuilder(st.nextToken());
            StringBuilder prevDirection = new StringBuilder();
            int curve = Integer.parseInt(st.nextToken());
            mapArr[r][c] = 1;


            /**
             0 -- 0
             1 -- 01
             2 -- 01 21
             3 -- 0121 2321
             4 -- 01212321 23032321
             */
            /*
            1
            0 0 0 3
            */

            for(int j = 1 ; j <= curve ; j++){
                prevDirection = new StringBuilder(direction);
                prevDirection.reverse();
                int sizeOfPrevDirection = prevDirection.length();
                for(int k = 0 ; k < sizeOfPrevDirection ; k++){
                    prevDirection.replace(k, k+1, String.valueOf((Integer.parseInt(prevDirection.substring(k, k+1))+1)%4));
                }
                direction = direction.append(prevDirection);
            }

            for(int j = 0 ; j < direction.length() ; j++){
                int nextD = direction.charAt(j)-48;
                int nextR = r + dr[nextD];
                int nextC = c + dc[nextD];

                if(0 <= nextR && 0 <= 100 && 0 <= nextC && nextC <= 100){
                    //System.out.println(nextR + " " + nextC);

                    mapArr[nextR][nextC] = 1;
                    r = nextR;
                    c = nextC;
                }
            }
        }

        // 사각형 체크
        int answer = 0;
        for(int i = 0 ; i < 100 ; i++){
            for(int j = 0 ; j < 100 ; j++){

                if(mapArr[i][j] == 1){
                    //System.out.println(i + " " + j);
                }

                if(mapArr[i][j] == 1 && mapArr[i][j+1] == 1 && mapArr[i+1][j] == 1 && mapArr[i+1][j+1] == 1){
                    answer++;
                }
            }
        }



        System.out.println(answer);
    }
}
